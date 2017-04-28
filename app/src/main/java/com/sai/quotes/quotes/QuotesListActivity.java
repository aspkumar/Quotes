package com.sai.quotes.quotes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by DELL on 23-04-2017.
 */

public class QuotesListActivity extends AppCompatActivity {
    String itemClicked;
    String[] quotestopass;
    RecyclerView recyclerViewQuotes;
    String arrayName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes_list);
        Intent intent = getIntent();
        itemClicked = intent.getStringExtra("clickedcategory");
        if (itemClicked.equals("Self-Confidence")) {
            quotestopass = getResources().getStringArray(R.array.selfconfidencearray);
        arrayName="selfconfidencearray";
        }


        recyclerViewQuotes= (RecyclerView) findViewById(R.id.recycler_view_quotes_LV);
        RecyclerAdapterQuotes adapter = new RecyclerAdapterQuotes(this, quotestopass,arrayName);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewQuotes.setLayoutManager(mLayoutManager);
        recyclerViewQuotes.addItemDecoration(new SimpleDividerItemDecoration(this));
        recyclerViewQuotes.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}
