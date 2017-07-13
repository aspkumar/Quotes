package com.sai.quotes.quotes;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.sai.quotes.quotes.allquotes.VPTMain;
import com.sai.quotes.quotes.biography.BiographyMain;
import com.sai.quotes.quotes.interestingfacts.InterestingFactsMain;
import com.sai.quotes.quotes.pictures.PictureSlideActivity;
import com.sai.quotes.quotes.pictures.PicturesPOJO;
import com.sai.quotes.quotes.retrofit.Picture;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView quotes, categories, biography, favourites, interesting, pictures, contentQOD;
    private FrameLayout frameLayoutFragment;
    private LinearLayout layer, layer1, layer2, layer3;
    private RelativeLayout qodLayout;
    private String[] qodarray;
    String formattedDate, dateValue;
    int randVal;
    private String[] quotesarray;
    private ArrayList<String> favouritearraySP;
    private SharedPreferences sharedpreferences;
    private SharedPreferences.Editor editor;
    List<Picture> urllink;
    String[] urllinks;
    ArrayList<PicturesPOJO> picheadandbody;
    Toolbar toolbar;
    Boolean boolvalue;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        FirebaseCrash.report(new Exception("My first Android non-fatal error"));
//
//        //I'm also creating a log message, which we'll look at in more detail later//
//        FirebaseCrash.log("MainActivity started");

        layer = (LinearLayout) findViewById(R.id.layer);
        layer1 = (LinearLayout) findViewById(R.id.layer1);
        layer2 = (LinearLayout) findViewById(R.id.layer2);
        layer3 = (LinearLayout) findViewById(R.id.layer3);
        frameLayoutFragment = (FrameLayout) findViewById(R.id.frame_layout_for_fragment);
        qodarray = getResources().getStringArray(R.array.qodarray);

        contentQOD = (TextView) findViewById(R.id.content_QOD);
        qodLayout = (RelativeLayout) findViewById(R.id.qod_layout);

        //addding toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Swami Vivekananda");
        toolbar.setTitleTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.mipmap.ic_app_icon);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent result = getIntent();
        boolvalue= result.getBooleanExtra("fragmentValue", false);

//dashboard items declaration
        quotes = (TextView) findViewById(R.id.all_quotes_TV);
        categories = (TextView) findViewById(R.id.category_TV);
        biography = (TextView) findViewById(R.id.boigraphyTV);
        favourites = (TextView) findViewById(R.id.favouritesTV);
        interesting = (TextView) findViewById(R.id.interestingTV);
        pictures = (TextView) findViewById(R.id.picturesTV);

        //click listeners
        quotes.setOnClickListener(this);
        categories.setOnClickListener(this);
        biography.setOnClickListener(this);
        favourites.setOnClickListener(this);
        interesting.setOnClickListener(this);
        pictures.setOnClickListener(this);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        formattedDate = df.format(calendar.getTime());
        SharedPreferences sharedPreferences = getSharedPreferences("mypreference", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        dateValue = sharedPreferences.getString("dateVal", "");
        randVal = sharedPreferences.getInt("randVal", 0);
        Random r = new Random();
        int i1;

        if (dateValue == null) {
            dateValue = formattedDate;
            editor.putString("dateVal", dateValue);
            i1 = r.nextInt(qodarray.length) - 1;
            editor.putInt("randVal", i1);
            contentQOD.setText(qodarray[i1]);
            editor.commit();
        } else if (dateValue.equals(formattedDate)) {
            contentQOD.setText(qodarray[randVal]);
        } else if (!dateValue.equals(formattedDate)) {
            dateValue = formattedDate;
            editor.putString("dateVal", dateValue);
            i1 = r.nextInt(qodarray.length) - 1;
            editor.putInt("randVal", i1);
            contentQOD.setText(qodarray[i1]);
            editor.commit();
        }




    }

    @Override
    public void onBackPressed() {
        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 1) {
            super.onBackPressed();

         /*   frameLayoutFragment.setVisibility(View.GONE);
            layer.setVisibility(View.VISIBLE);
            layer1.setVisibility(View.VISIBLE);
            layer2.setVisibility(View.VISIBLE);
//                layer3.setVisibility(View.GONE);
            toolbar.setVisibility(View.VISIBLE);
            qodLayout.setVisibility(View.VISIBLE);*/
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            //additional code
        } else {
            getFragmentManager().popBackStack();
//            finish();
        }

        if (count == 0 ) {
            finish();

        }

    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.all_quotes_TV:
                Intent intent = new Intent(MainActivity.this, VPTMain.class);
                startActivity(intent);
                break;
            case R.id.category_TV:
                final FragmentManager fm = getFragmentManager();
                final FragmentTransaction ft = fm.beginTransaction();


                toolbar.setVisibility(View.INVISIBLE);
                layer.setVisibility(View.GONE);
                layer1.setVisibility(View.GONE);
                layer2.setVisibility(View.GONE);
//                layer3.setVisibility(View.GONE);
                qodLayout.setVisibility(View.GONE);
                frameLayoutFragment.setVisibility(View.VISIBLE);
                ft.replace(R.id.frame_layout_for_fragment, new ListFragment());
                ft.addToBackStack(null);
                ft.commit();
                break;
            case R.id.boigraphyTV:
                Intent bioIntent = new Intent(MainActivity.this, BiographyMain.class);
                startActivity(bioIntent);
                break;
            case R.id.favouritesTV:
                Intent favintent = new Intent(MainActivity.this, QuotesListActivity.class);
                favintent.putExtra("clickedcategory", "favarray");
                startActivity(favintent);
                break;
            case R.id.interestingTV:
                Intent interestingIntent = new Intent(MainActivity.this, InterestingFactsMain.class);
                startActivity(interestingIntent);
                break;
            case R.id.picturesTV:
                picheadandbody = new ArrayList<>();
                picheadandbody.add(new PicturesPOJO("headdddd1", "bodyyyy1", "http://imgh.us/svn.jpg"));
                picheadandbody.add(new PicturesPOJO("headdddd2", "bodyyyy2", "http://imgh.us/svn1.jpg"));
                picheadandbody.add(new PicturesPOJO("headdddd3", "bodyyyy3", "http://imgh.us/svn2.jpg"));
                picheadandbody.add(new PicturesPOJO("headdddd4", "bodyyyy4", "http://imgh.us/4_2359.jpg"));
                picheadandbody.add(new PicturesPOJO("headdddd5", "bodyyyy5", "http://imgh.us/brueclee.jpg"));
                Gson gson = new Gson();


//                ArrayList<ListAdapterItemsSelected> mSelectedList = new ArrayList<ListAdapterItemsSelected>();
                String jsonString = gson.toJson(picheadandbody);
//                SharedPreferences sp = context.getSharedPreferences("KEY", Context.MODE_PRIVATE);
                sharedpreferences = getSharedPreferences("mypreference", Context.MODE_PRIVATE);
                editor = sharedpreferences.edit();
                //Save to SharedPreferences
                editor.putString("selectedarray", jsonString).commit();


//                String sf = Arrays.toString(quotesarray);
//                editor.putString("selectedarray", Arrays.toString(quotesarray));
//                editor.commit();
                Intent pictureIntent = new Intent(getApplicationContext(), PictureSlideActivity.class);
                pictureIntent.putExtra("itemposition", 0);
                pictureIntent.putExtra("arrName", picheadandbody);
                pictureIntent.putExtra("arrLenght", picheadandbody.size());
//                quotesfull.putParcelableArrayListExtra("dummy_array", dummyArray);
//                pictureIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(pictureIntent);


//               Intent pictureintent=new Intent(getApplicationContext(),PicturesMain.class);
//               pictureintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(pictureintent);
                break;
        }
    }


}

