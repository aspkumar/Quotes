package com.sai.quotes.quotes;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sai.quotes.quotes.allquotes.VPTMain;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView categories;
    FrameLayout frameLayoutFragment;
    LinearLayout layer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layer = (LinearLayout) findViewById(R.id.layer);
        frameLayoutFragment = (FrameLayout) findViewById(R.id.frame_layout_for_fragment);


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
                Intent intent=new Intent(MainActivity.this,VPTMain.class);
                startActivity(intent);
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
