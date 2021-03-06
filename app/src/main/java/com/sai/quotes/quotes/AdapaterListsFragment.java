package com.sai.quotes.quotes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by DELL on 23-04-2017.
 */


class AdapaterListsFragment extends RecyclerView.Adapter<AdapaterListsFragment.MyViewHolder> {

    Context context;
    String[] array;


    public AdapaterListsFragment(Context context, String[] array) {
        this.context = context;
        this.array = array;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_view, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.conents_TV.setText(array[position]);
        holder.numbers_TV.setText(String.valueOf(position+1));
        String clicledtext = (String) holder.conents_TV.getText();
        clicledtext = clicledtext.replace(" ", "");
        final String finalClicledtext = clicledtext;
        holder.conents_TV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quotesintent = new Intent(context, QuotesListActivity.class);
                quotesintent.putExtra("clickedcategory", finalClicledtext);
                context.startActivity(quotesintent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return array.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView conents_TV, numbers_TV;

        public MyViewHolder(View itemView) {
            super(itemView);
            conents_TV = (TextView) itemView.findViewById(R.id.list_item_name);
            numbers_TV = (TextView) itemView.findViewById(R.id.numbers_TV);
        }
    }
}
