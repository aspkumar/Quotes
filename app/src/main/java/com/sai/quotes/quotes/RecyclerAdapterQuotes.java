package com.sai.quotes.quotes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by DELL on 23-04-2017.
 */

public class RecyclerAdapterQuotes extends RecyclerView.Adapter<RecyclerAdapterQuotes.QuotesVH> {

    private Context context;
    private String[] quotesarray;
    private ArrayList<String> favouritearraySP;
    private SharedPreferences sharedpreferences;
    private SharedPreferences.Editor editor;
    private String arrayName;
    private Boolean expandrcollapseval;

    public RecyclerAdapterQuotes(Context context, String[] quotesarray, String arrayName, Boolean expandrcollapseval) {
        this.context = context;
        this.quotesarray = quotesarray;
        this.arrayName = arrayName;
        this.expandrcollapseval = expandrcollapseval;
    }


    @Override
    public QuotesVH onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_quotes, parent, false);
        sharedpreferences = context.getSharedPreferences("mypreference", Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
//        sharedpreferences.edit().clear();
//        editor.commit();


        String selectedValue = sharedpreferences.getString("storespValues", "");
        selectedValue = selectedValue.replace("[", "");
        selectedValue = selectedValue.replace("]", "");
        selectedValue = selectedValue.replace(".,", ".~");
        favouritearraySP = new ArrayList<>();


        if (selectedValue != null) {
            favouritearraySP.addAll(Arrays.asList(selectedValue.split("\\s*~\\s*")));

        }


        return new QuotesVH(itemView);
    }

    @Override
    public void onBindViewHolder(final QuotesVH holder, final int position) {

        if (expandrcollapseval) {
            holder.quoteItemTV.setMaxLines(20);
            holder.share.setVisibility(View.VISIBLE);
        }
        else
            holder.share.setVisibility(View.GONE);

        holder.quoteItemTV.setText(quotesarray[position]);
        if (favouritearraySP.contains(quotesarray[position])) {

            holder.heart_white.setVisibility(View.INVISIBLE);
            holder.heart_red.setVisibility(View.VISIBLE);
        } else {
            holder.heart_white.setVisibility(View.VISIBLE);
            holder.heart_red.setVisibility(View.INVISIBLE);
        }

        holder.heart_white.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    one.get(position).setId(true);
                holder.heart_white.setVisibility(View.INVISIBLE);
                holder.heart_red.setVisibility(View.VISIBLE);
                favouritearraySP.add(quotesarray[position]);
                editor.putString("storespValues", favouritearraySP.toString());
                editor.commit();
            }
        });


        holder.heart_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.heart_white.setVisibility(View.VISIBLE);
                holder.heart_red.setVisibility(View.INVISIBLE);
                favouritearraySP.remove(quotesarray[position]);
                editor.putString("storespValues", favouritearraySP.toString());
                editor.commit();
            }
        });

        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,quotesarray[position]+ "\n\r"+ "~Swami Vivekananda" );
                sendIntent.setType("text/plain");
                context.startActivity(Intent.createChooser(sendIntent,quotesarray[position]));
            }
        });
        holder.quoteItemTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sf = Arrays.toString(quotesarray);
                editor.putString("selectedarray", Arrays.toString(quotesarray));
                editor.commit();
                Intent quotesfull = new Intent(context, ScreenSlideActivity.class);
                quotesfull.putExtra("itemposition", position);
                quotesfull.putExtra("arrName", quotesarray);
                quotesfull.putExtra("arrLenght", quotesarray.length);
                context.startActivity(quotesfull);
            }
        });
    }

    @Override
    public int getItemCount() {
        return quotesarray.length;
    }

    public class QuotesVH extends RecyclerView.ViewHolder {
        TextView quoteItemTV;
        ImageView heart_red, heart_white, share;

        public QuotesVH(View itemView) {
            super(itemView);
            quoteItemTV = (TextView) itemView.findViewById(R.id.list_quote_itemTV);
            heart_red = (ImageView) itemView.findViewById(R.id.heart_icon_red);
            heart_white = (ImageView) itemView.findViewById(R.id.heart_icon_white);
            share = (ImageView) itemView.findViewById(R.id.share_icon);
        }
    }
}
