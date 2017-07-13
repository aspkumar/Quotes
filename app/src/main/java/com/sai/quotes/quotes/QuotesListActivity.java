package com.sai.quotes.quotes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by DELL on 23-04-2017.
 */

public class QuotesListActivity extends AppCompatActivity implements View.OnClickListener {
    String itemClicked;
    String[] quotestopass;
    RecyclerView recyclerViewQuotes;
    String arrayName;
    Boolean expandrcollapseval=false;
    View controlView;
    ImageView a2z, z2a, expand, collapse;
    private ArrayList<String> favouritearraySP;
    private TextView nofav;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes_list);

        //Adding toolbar to the activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("Favourites");
        toolbar.setTitleTextColor(ContextCompat.getColor(getApplicationContext(),R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        nofav= (TextView) findViewById(R.id.no_fav_txt);

        Intent intent = getIntent();
        itemClicked = intent.getStringExtra("clickedcategory");
        if (itemClicked.equalsIgnoreCase("Self-Confidence")) {
            quotestopass = getResources().getStringArray(R.array.selfconfidencearray);
            arrayName = "selfconfidencearray";
        } else if (itemClicked.equalsIgnoreCase("StrenghtisLife")) {
            quotestopass = getResources().getStringArray(R.array.strengthislifearray);
            arrayName = "strengthislifearray";
        }else if (itemClicked.equalsIgnoreCase("favarray")){
            SharedPreferences sharedPreferences = getSharedPreferences("mypreference", Context.MODE_PRIVATE);
            String selectedValue = sharedPreferences.getString("storespValues", "");
            selectedValue = selectedValue.replace("[", "");
            selectedValue = selectedValue.replace("]", "");
            selectedValue = selectedValue.replace(".,", ".~");
            favouritearraySP = new ArrayList<>();


            if (selectedValue != null) {
                favouritearraySP.addAll(Arrays.asList(selectedValue.split("\\s*~\\s*")));
            }


            quotestopass= (String[]) favouritearraySP.toArray(new String[favouritearraySP.size()]);
        }

        controlView = findViewById(R.id.control_toolbar);
        a2z = (ImageView) controlView.findViewById(R.id.a2z_icon);
        z2a = (ImageView) controlView.findViewById(R.id.z2a_icon);
        expand = (ImageView) controlView.findViewById(R.id.expand_icon);
        collapse = (ImageView) findViewById(R.id.collapse_icon);
        a2z.setOnClickListener(this);
        z2a.setOnClickListener(this);
        expand.setOnClickListener(this);
        collapse.setOnClickListener(this);

        Collections.sort(Arrays.asList(quotestopass), String.CASE_INSENSITIVE_ORDER);
        recyclerViewQuotes = (RecyclerView) findViewById(R.id.recycler_view_quotes_LV);

        if(quotestopass.length==1){
            recyclerViewQuotes.setVisibility(View.GONE);
            nofav.setVisibility(View.VISIBLE);
        }
        else {
//        Collections.reverse(Arrays.asList(quotestopass));

            RecyclerAdapterQuotes adapter = new RecyclerAdapterQuotes(this, quotestopass, arrayName, expandrcollapseval);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerViewQuotes.setLayoutManager(mLayoutManager);
            recyclerViewQuotes.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
//            recyclerViewQuotes.addItemDecoration(new SimpleDividerItemDecoration(this));
            recyclerViewQuotes.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.z2a_icon:
            case R.id.a2z_icon:
            case R.id.expand_icon:
            case R.id.collapse_icon:


                if (v.getId() == R.id.a2z_icon) {
                    z2a.setVisibility(View.VISIBLE);
                    a2z.setVisibility(View.INVISIBLE);
                    Collections.reverse(Arrays.asList(quotestopass));
                    Toast.makeText(getApplicationContext(), "toast mas", Toast.LENGTH_SHORT).show();
                } else if (v.getId() == R.id.z2a_icon) {
                    z2a.setVisibility(View.INVISIBLE);
                    a2z.setVisibility(View.VISIBLE);
                    Collections.reverse(Arrays.asList(quotestopass));
                    Toast.makeText(getApplicationContext(), "toast mas", Toast.LENGTH_SHORT).show();
                }else if (v.getId()==R.id.expand_icon)
                {
                    expand.setVisibility(View.INVISIBLE);
                    collapse.setVisibility(View.VISIBLE);

                }
                else if(v.getId()==R.id.collapse_icon)
                {
                    expand.setVisibility(View.VISIBLE);
                    collapse.setVisibility(View.INVISIBLE);
                }





//                if(a2z.getVisibility()==View.VISIBLE){
//                    Collections.reverse(Arrays.asList(quotestopass));
//                }

                if (collapse.getVisibility() == View.VISIBLE) {
                    expandrcollapseval = true;
                }
                else
                    expandrcollapseval=false;

                recyclerViewQuotes = (RecyclerView) findViewById(R.id.recycler_view_quotes_LV);
                RecyclerAdapterQuotes adapter = new RecyclerAdapterQuotes(this, quotestopass, arrayName, expandrcollapseval);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerViewQuotes.setLayoutManager(mLayoutManager);
                recyclerViewQuotes.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
//                recyclerViewQuotes.addItemDecoration(new SimpleDividerItemDecoration(this));
                recyclerViewQuotes.setAdapter(adapter);
                adapter.notifyDataSetChanged();
//                Toast.makeText(getApplicationContext(),"toast mas",Toast.LENGTH_SHORT).show();
                break;


        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    finish();
    }
}
