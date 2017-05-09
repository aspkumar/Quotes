package com.sai.quotes.quotes;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sai.quotes.quotes.allquotes.VPTMain;
import com.sai.quotes.quotes.biography.BiographyMain;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView categories;
    private FrameLayout frameLayoutFragment;
    private LinearLayout layer;
    private String[] qodarray;
    String formattedDate,dateValue;
    int randVal;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layer = (LinearLayout) findViewById(R.id.layer);
        frameLayoutFragment = (FrameLayout) findViewById(R.id.frame_layout_for_fragment);
        qodarray = getResources().getStringArray(R.array.qodarray);


        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        formattedDate = df.format(calendar.getTime());
        SharedPreferences sharedPreferences = getSharedPreferences("mypreference", MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        dateValue = sharedPreferences.getString("dateval", "");
        randVal=sharedPreferences.getInt("randVal",0);

        if (dateValue==null ){
            dateValue=formattedDate;
            editor.putString("dateVal",dateValue);

        }


        categories = (TextView) findViewById(R.id.category_TV);
        categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FragmentManager fm = getFragmentManager();
                final FragmentTransaction ft = fm.beginTransaction();
                layer.setVisibility(View.GONE);
                frameLayoutFragment.setVisibility(View.VISIBLE);
                ft.replace(R.id.frame_layout_for_fragment, new ListFragment());
                ft.commit();
            }
        });


        findViewById(R.id.all_quotes_TV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VPTMain.class);
                startActivity(intent);
            }
        });


        findViewById(R.id.favouritesTV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent favintent = new Intent(MainActivity.this, QuotesListActivity.class);
                favintent.putExtra("clickedcategory", "favarray");
                startActivity(favintent);
            }
        });

        findViewById(R.id.boigraphyTV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bioIntent = new Intent(MainActivity.this, BiographyMain.class);
                startActivity(bioIntent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        layer.setVisibility(View.VISIBLE);
        frameLayoutFragment.setVisibility(View.INVISIBLE);
    }


    @Override
    public void onClick(View v) {

    }
}
