package com.sai.quotes.quotes.allquotes;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sai.quotes.quotes.R;

/**
 * Created by PrasannakumarA on 5/3/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context context;
    String[] values;


    public RecyclerViewAdapter(Context context, String[] values) {
        this.context = context;
        this.values = values;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_quotes, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.itemname.setText(values[position]);
    }

    @Override
    public int getItemCount() {
        return values.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView itemname;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemname = (TextView) itemView.findViewById(R.id.list_item_name);
        }
    }
}
