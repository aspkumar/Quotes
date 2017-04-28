package com.sai.quotes.quotes;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView categories;
    FrameLayout frameLayoutFragment;
    LinearLayout layer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layer = (LinearLayout) findViewById(R.id.layer);
        frameLayoutFragment = (FrameLayout) findViewById(R.id.frame_layout_for_fragment);
        final FragmentManager fm = getFragmentManager();
        final FragmentTransaction ft = fm.beginTransaction();


        categories = (TextView) findViewById(R.id.category_TV);
        categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layer.setVisibility(View.GONE);
                frameLayoutFragment.setVisibility(View.VISIBLE);
                ft.replace(R.id.frame_layout_for_fragment, new ListFragment());
                ft.commit();
            }
        });


    }

    @Override
    public void onBackPressed() {
        layer.setVisibility(View.VISIBLE);
        frameLayoutFragment.setVisibility(View.INVISIBLE);
    }
}
