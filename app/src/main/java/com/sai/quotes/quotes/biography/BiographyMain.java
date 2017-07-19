package com.sai.quotes.quotes.biography;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.sai.quotes.quotes.R;

import java.util.Random;

/**
 * Created by DELL on 09-05-2017.
 */

public class BiographyMain extends AppCompatActivity {
    TextView headingMain, contemtMain;
    InterstitialAd mInterstitialAd;
    private AdView mAdView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biography);

        mAdView = (AdView) findViewById(R.id.bioadView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstialadd_id));
        AdRequest adRequest1 = new AdRequest.Builder().build();
        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequest1);
        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                mInterstitialAd.show();
//                showInterstitial();
            }
        });







    /*    // set the ad unit ID
        mInterstitialAd.setAdUnitId(getString(R.string.interstialadd_id));

        AdRequest adRequest1 = new AdRequest.Builder()
                .build();

        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequest1);

        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();
            }
        });
*/


        //Adding toolbar to the activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Biography");
        toolbar.setTitleTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        headingMain = (TextView) findViewById(R.id.vivekananda_TV);
        contemtMain = (TextView) findViewById(R.id.content_TV);
        Typeface face1 = Typeface.createFromAsset(getAssets(), "fonts/pacifo.ttf");
        headingMain.setTypeface(face1);
//        headingMain.setText("sdfsadfsadf");
//        String steps = "Hello Everyone";
//        String title = "Bold Please!";
        String svnname = "Swami Vivekananda";
        String chilhood = "Childhood:";
        String youth = "Youth:";
        String foundramkrishmiss = "Foundation of Ramakrishna Mission:";
        String lastdays = "Last Days:";


//        SpannableString ss1 = new SpannableString(title);
//        ss1.setSpan(new StyleSpan(Typeface.BOLD), 0, ss1.length(), 0);
        SpannableString ss2 = new SpannableString(svnname);
        ss2.setSpan(new StyleSpan(Typeface.BOLD), 0, ss2.length(), 0);
        SpannableString ss3 = new SpannableString(chilhood);
        ss3.setSpan(new StyleSpan(Typeface.BOLD), 0, ss3.length(), 0);
        SpannableString ss4 = new SpannableString(youth);
        ss4.setSpan(new StyleSpan(Typeface.BOLD), 0, ss4.length(), 0);
        SpannableString ss5 = new SpannableString(foundramkrishmiss);
        ss5.setSpan(new StyleSpan(Typeface.BOLD), 0, ss5.length(), 0);
        SpannableString ss6 = new SpannableString(lastdays);
        ss6.setSpan(new StyleSpan(Typeface.BOLD), 0, ss6.length(), 0);

//        contemtMain.append(ss1);
//        contemtMain.append("\n");
//        contemtMain.append(steps);
        contemtMain.append(ss2);
        contemtMain.append(" (Sanskrit: स्वामी विवेकानन्द; Bengali: স্বামী বিবেকানন্দ, Shami Bibekānondo) (January 12, 1863–July 4, 1902) was the chief disciple of Sri Ramakrishna Paramahansa. At birth, he was called Narendranath Datta (Bengali: নরেন্দ্রনাথ দত্ত). He was the founder of Ramakrishna Mission. He introduced Hindu philosophies of Vedanta and Yoga in Europe and America. He brought Hinduism to the status of a major world religion during the end of the 19th century. Vivekananda is considered to be a major force in the revival of Hinduism in modern India. He is perhaps best known for his inspiring speech beginning with \"Sisters and Brothers of America\". Through this he introduced Hinduism at the Parliament of the World's Religions at Chicago in 1893.\n" + "\n");
        contemtMain.append(ss3);
        contemtMain.append("\n" + "Swami Vivekananda was born in Shimla Pally in Calcutta on 12 January 1863. He was named Narendranath Datta. His father Vishwanath Datta was an attorney of Calcutta High Court. His mother was Bhuvaneshwari Devi. Narendranath's thinking and personality were influenced by his parents—the father by his rational mind and the mother by her religious temperament. From his mother he learnt the power of self-control. Young Narendra was an expert in meditation and could enter the state of samadhi very easily. He saw a light while falling asleep. Once he had a vision of Buddha during his meditation. During his childhood, he had a great fascination for wandering ascetics and monks. He was also an expert in games and naughty things. Even in his young age he showed remarkable leadership qualities. His childhood friend was Kamal Reddy.\n" + "\n");
        contemtMain.append(ss4);
        contemtMain.append("\n" + "In his youth he visited the Brahmo Samaj and later he came in contact with Sri Ramakrishna. Sri Ramakrishna initiated him, and after his death Naren left his house. He took the monk-name ogivami Vivekananda and stayed at the Boranagar Monastery with his monk-brothers. Later he set out for touring India. He wandered from place to place until he reached Trivandum and decided to attend the Parliament of Religions at Chicago. He delivered the great speech at Chicago and brought Hinduism to the status of a major religion.\n" + "\n");
        contemtMain.append(ss5);
        contemtMain.append("\n" + "Vivekananda became very popular after delivering lectures at many places of America and England. He came back to India and founded the Ramakrishna Maths and Mission in 1897. He also founded the Advaita Ashrama in Mayavati, near Almora on March 19, 1899. The Ashrama was a branch of the Ramakrishna Math. He composed the famous arati song, Khandana Bhava Bandhana\n" + "\n");
        contemtMain.append(ss6);
        contemtMain.append("\n" + "On 4 July, 1902 he woke up in the early morning, went to the chapel at Belur Math and meditated for three hours. He taught Shukla-Yajur-Veda, Sanskrit grammar and the philosophy of yoga to pupils, later discussing with colleagues a planned Vedic college in the Ramakrishna Math. At seven p.m. Vivekananda went to his room, asking not to be disturbed; he died at 9:10 p.m. while meditating.\n" + "\n");


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }
  /*  private void showInterstitial() {
        Random r = new Random();
        if (mInterstitialAd.isLoaded()) {
            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {

                            mInterstitialAd.show();
                            AdRequest adRequest = new AdRequest.Builder().build();
                            mInterstitialAd.loadAd(adRequest);
                        }
                    },
                    r.nextInt(7000 - 5000) + 5000);

        }
    }*/

    @Override
    public void onResume() {
        // Start or resume the game.
        super.onResume();
        showInterstitial();
    }
    @Override
    protected void onStart() {
        super.onStart();
        showInterstitial();
    }

}
