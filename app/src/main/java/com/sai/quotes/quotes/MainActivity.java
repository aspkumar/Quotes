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

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crash.FirebaseCrash;
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
import java.util.Collections;
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
    private AdView mAdView;
    private FirebaseAnalytics mFirebaseAnalytics;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);


// Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

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
        boolvalue = result.getBooleanExtra("fragmentValue", false);

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
        FirebaseCrash.report(new Exception("My first Android non-fatal error"));


    }


    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }


    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
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

        if (count == 0) {
            finish();

        }

    }


    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.all_quotes_TV:
                Intent intent = new Intent(MainActivity.this, VPTMain.class);
                startActivity(intent);
                mFirebaseAnalytics.logEvent("allquotes_click", null);
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
                mFirebaseAnalytics.logEvent("category_click", null);

                break;
            case R.id.boigraphyTV:
                Intent bioIntent = new Intent(MainActivity.this, BiographyMain.class);
                startActivity(bioIntent);
                mFirebaseAnalytics.logEvent("biography_click", null);
                break;
            case R.id.favouritesTV:
                Intent favintent = new Intent(MainActivity.this, QuotesListActivity.class);
                favintent.putExtra("clickedcategory", "favarray");
                startActivity(favintent);
                mFirebaseAnalytics.logEvent("favourites_click", null);

                break;
            case R.id.interestingTV:
                Intent interestingIntent = new Intent(MainActivity.this, InterestingFactsMain.class);
                startActivity(interestingIntent);
                mFirebaseAnalytics.logEvent("interstingfacts_click", null);
                break;
            case R.id.picturesTV:
                picheadandbody = new ArrayList<>();
                picheadandbody.add(new PicturesPOJO("BELUR MATH, 1977 Swamiji’s Temple", "hree days before his passing away, as the swami [Swamiji] was walking up and down on the spacious lawn of the monastery in the afternoon with Swami Premananda, he pointed to a particular spot on the bank of the Ganga, and said to his brother monk gravely, “When I give up the body, cremate it there!”\n" +
                        "\n" +


                        "Swamiji entered mahasamadhi on July 4, 1902. This memorial was erected in his honor on the very spot where he was cremated.", "http://i.imgur.com/AAyPdqa.jpg    - swamiji106"));
                picheadandbody.add(new PicturesPOJO("KASHMIR, 1898", "Left to right: Josephine MacLeod, Mrs. Ole Bull (sitting), Swami Vivekananda, Sister Nivedita.\n" +
                        "\n" +
                        "While in Kashmir and the surrounding area, Swamiji and his companions made many excursions to shrines, palaces, the ruins of old temples, and other places of historic interest.", "http://i.imgur.com/226Yz4d.jpg    - 71"));
                picheadandbody.add(new PicturesPOJO("SHILLONG, 1901", "Swamiji wrote to Swami Swarupananda on May 15, 1901: “I have just returned from my tour through East Bengal and Assam. As usual, am quite tired and broken down.” And in a letter to Josephine MacLeod he wrote from Belur Math on June 14, 1901, “As for me, I was thrown hors de combat [disabled] in Assam. The climate of the Math is just reviving me a bit.”\n" +
                        "\n", "http://i.imgur.com/HFAjlgT.jpg    -105"));
                picheadandbody.add(new PicturesPOJO("SOUTH PASADENA, CALIFORNIA, JANUARY 1900", "While in South Pasadena Swamiji stayed at the home of the Mead sisters--Mrs. Alice Hansbrough, Mrs. Carrie Wyckoff, and Miss Helen Mead. The other members of the household were Mr. Mead (the sisters' father), his two grandchildren--Mrs. Hansbrough's daughter, Dorothy, and Mrs. Wyckoff 's son, Ralph, and the housekeeper, Miss Fairbanks. \"How so many people could fit comfortably into so small a house is a marvel. But even with guests, they managed with apparent ease.\"\n" +
                        "\n" +
                        "In this photo Swamiji is shown standing, leaning on an umbrella, at a corner of the Meads' house, the rose vine at his back, \"while Mrs. Wyckoff, standing on the porch, peeps from behind a pillar. Only a portion of the house is visible in this particular photograph; but in the book Swami Turiyananda by Swami Ritajananda there is a full view of it.\"\n" +
                        "\n", "http://i.imgur.com/SzXWxb1.jpg    -85"));
                picheadandbody.add(new PicturesPOJO("KASHMIR, 1898--In a Houseboat", "Barely visible in the houseboat (left to right): Josephine MacLeod, Swami Vivekananda, Mrs. Ole Bull, Sister Nivedita.", "http://i.imgur.com/HNB87gy.jpg    -70"));
                picheadandbody.add(new PicturesPOJO("COSSIPORE GARDEN HOUSE, 1886", "Shortly before Sri Ramakrishna gave up his body at Cossipore, Swamiji had an exalted spiritual experience there. Seeing him Sri Ramakrishna said: “Now then, the Mother has shown you everything. Just as a treasure is locked up in a box, so will this realization you have just had be locked up and the key shall remain with me. You have work to do. When you have finished my work, the treasure box will be unlocked again; and you will know everything then, as you did just now.”", "http://i.imgur.com/eevzwUT.jpg    -3"));
                picheadandbody.add(new PicturesPOJO("CHENNAI, FEBRUARY 1897", "Sitting on chair (left to right): Tarapada (a monk from another order), Swami Shivananda, Swami Vivekananda, Swami Niranjanananda, and Swami Sadananda. \n" +
                        "Standing (left to right): Alasinga Perumal, J. J. Goodwin, M. N. Banerjee, and other local devotees. \n" +
                        "Front row (left to right): (second) Biligiri Iyengar, (fourth) M. C. Nanjunda Rao.3\n" +
                        "\n", "http://i.imgur.com/vZtzB0h.jpg    -60"));
                picheadandbody.add(new PicturesPOJO("SOUTH PASADENA, CALIFORNIA, JANUARY 1900", "Swami Vivekananda in center; on his right, a Mrs. Bruce; behind him, Carrie Wyckoff; on his left, Alice Hansbrough. The others are unknown. In Vivekananda: A Biography in Pictures, some of the other picnickers are identified. As the source of these identifications cannot be verified, these people have not been listed.", "http://i.imgur.com/tjTLYpY.jpg    -87"));
                picheadandbody.add(new PicturesPOJO("SAN FRANCISCO, CALIFORNIA, 1900", "\"As was the case everywhere, Swamiji met people of all kinds in San Francisco, and, as was the case always, he was equally friendly to all. 'He seemed to like all people,' Mrs. Hansbrough once said. 'He was most compassionate; it seemed as if he never saw distinctions between people--almost as if he didn't see the difference between a duck and a man!'\"", "http://i.imgur.com/1DlbhlM.jpg    -97"));
                picheadandbody.add(new PicturesPOJO("LONDON, DECEMBER 1896", "Miss Emmeline Souter, an admirer of Swamiji and a wealthy friend of the Reverend Hugh R. Haweis, arranged for some photographs to be made of Swamiji. In a letter written from Kolkata on May 5, 1897, to Margaret Noble (Sister Nivedita), Swamiji said: \"The only help I got in the world was in England, from Miss Souter and Mr. Sturdy.", "http://i.imgur.com/wvPPFBM.jpg    -48"));
                picheadandbody.add(new PicturesPOJO("GREEN ACRE, AUGUST 1894", "From left to right: Swami Vivekananda, Sarah J. Farmer, M. H. Gulesian, and Dr. Edward Everett Hale.", "http://i.imgur.com/aIz5ij7.jpg    -32"));
                picheadandbody.add(new PicturesPOJO("CALCUTTA, (JUNE 20?), 1899", "This photo was taken at 8 Bosepara Lane in Calcutta at the rented house of Sri Boshi Sen's family. The Holy Mother was living in this house at that time. ", "http://i.imgur.com/J4hhV8N.jpg    -77"));
                picheadandbody.add(new PicturesPOJO("CHICAGO, SEPTEMBER 1893", "An Actual Scene at One of the Sessions of the Parliament\n" +
                        "This photograph was taken on the morning of September 21, 1893-the eleventh day of the parliament. It was published in 1893 as the frontispiece of John Henry Barrows’", "http://i.imgur.com/88xdJAG.jpg    -18"));
                picheadandbody.add(new PicturesPOJO("LONDON, DECEMBER 1896", "In his Bengali book, Londone Swami Vivekananda, Mahendra Nath has given us an insight into Swamiji’s inner world at this time:\n" +
                        "\n" +
                        "“You see,” Swamiji said, “at night I go to my room and lie down. I keep quiet for a while, and then within me so much ananda arises that I cannot stay lying down. I see the Blissful Mother. Men, animals, the sky and earth--all are saturated with bliss. I cannot lie down any longer; so I get up and dance in the middle of the room. That bliss can no longer be confined within my heart. The whole world becomes filled with it, as it were.” Even as he said this, Swamiji began to dance like a child for a little while. Then he said with affection to those who were present, “Be happy, don't be depressed; the Mother is everywhere; all will be filled with bliss!”", "http://i.imgur.com/OAdT6N7.jpg    -52"));
                picheadandbody.add(new PicturesPOJO("GREENACRE, AUGUST 1894", "Swami Vivekananda seated in front. Ralph Waldo Trine (standing) in cowboy hat.\n" +
                        "\n" +
                        "In this photo Swamiji is seated under the “Swami’s Pine” with his class. “This photograph was discovered by Elva Nelson [of the Ramakrishna Vedanta Society, Boston] and may well be the photograph he spoke of in his letter to the Hale sisters: ‘Herewith I send a photograph Cora Stockham took of the group under the tree.", "http://i.imgur.com/FKGxDuY.jpg    -30"));
                picheadandbody.add(new PicturesPOJO("COLOMBO, JANUARY 1897", "An excerpt from a Colombo local paper, the Ceylon Independent, describes how Swamiji was received when he arrived there: “As the day was closing and the night approached, when the auspicious and sacred hour of ‘sandhya’ noted by the Hindu shastras as the best suited for devotion came round as the harbinger of the coming great events of the day, the sage of noble figure, of sedate countenance with large, luminous eyes, arrived, dressed in the orange garb of a sannyasin, accompanied by the Swami Niranjanananda and others. . . . No words can describe the feelings of the vast masses and their expressions of love, when they saw the steam launch bearing the sage, steaming towards the jetty.”", "http://i.imgur.com/vhlUQmg.jpg    -57"));
                picheadandbody.add(new PicturesPOJO("NEW YORK, APRIL 6, 1895", "Swamiji’s palm impression appeared in the book Language of the Hand by Cheiro. Cheiro was a famous palmist in the late nineteenth and early twentieth centuries. No doubt, one of Swamiji’s wealthy friends in New York took him to Cheiro to have his palm read.", "http://i.imgur.com/eBRmEcl.jpg    -38"));
                picheadandbody.add(new PicturesPOJO("CHENNAI, FEBRUARY 1897", "It is not known to date who arranged for Mr. T. G. Appavan Mudaliar to take these two photos. However, it seems likely that one of Swamiji’s admirers was behind it, like K. Sundararama Iyer, or Biligiri Iyengar, who provided his residenceľCastle Kernan (later named Vivekananda House, and presently being maintained by Sri Ramakrishna Math, Chennai)ľfor Swamiji’s nine?day stay in Chennai, or perhaps one of Swamiji’s ardent disciples from Chennai.", "http://i.imgur.com/x6lLDHh.jpg    -59"));
                picheadandbody.add(new PicturesPOJO("CHICAGO, SEPTEMBER 1893", "During the Parliament of Religions, this poster of Swamiji was made by the Goes Lithographic Co., Chicago, 1893. It was posted throughout the city to draw people’s attention to the fair. Swamiji had become famous overnight and was a major attraction.", "http://i.imgur.com/6QboFQc.jpg    -22"));
                picheadandbody.add(new PicturesPOJO("GREEN ACRE, AUGUST 1894", "Swami Vivekananda, Sarah Farmer (seated to his left), Charles Malloy (standing), with white hat and walking stick.", "http://i.imgur.com/YvzPTAO.jpg    -31"));
                picheadandbody.add(new PicturesPOJO("CHICAGO, SEPTEMBER 1893 (Harrison)", "Swamiji has inscribed this photo: “Samata sarvabhuteshu etanmuktasya lakshanam. Equality in all beings this is the sign of the free -- Vivekananda”", "http://i.imgur.com/bSwhQgg.jpg    -23"));
                picheadandbody.add(new PicturesPOJO("JAIPUR, 1891 (probably)", " “At Jaipur the disciple [perhaps Lala Govinda Sahai whom Swamiji initiated in Rajputana in 1891] insisted on the swami’s posing for a photograph. The swami, much against his wishes, finally consented. This was the first time that a photo of him as a wandering monk was taken.”", "http://i.imgur.com/tbnizEt.jpg    -8"));
                picheadandbody.add(new PicturesPOJO("CHICAGO, SEPTEMBER 1893 -- Swami Vivekananda, Hindu Monk", "This photograph of Swamiji as a delegate to the Parliament of Religions also appeared in Neely’s History of the Parliament of Religions. It appears to have been taken not only on the same day as the East Indian Group, but at the same time. Swamiji is holding a piece of paper in his hand (although in this photo it is in his right hand, in the group photo it is in his left hand) and his official delegate tag is pinned to his robe in both photos. The drape of his turban and his general stance suggest that the two photos were taken one after the other.", "http://i.imgur.com/4vlA2Zw.jpg    -15"));
                picheadandbody.add(new PicturesPOJO("COSSIPORE GARDEN HOUSE, AUGUST 16, 1886", "when Sri Ramakrishna had been dressed in an ochre cloth and decorated with sandal paste and flowers, the photographs were taken. ", "http://i.imgur.com/Bqkwhfi.jpg    -5"));
                picheadandbody.add(new PicturesPOJO("CHICAGO, SEPTEMBER 1893 -- The East Indian Group", "This photograph appeared for the first time in Neely’s History of the Parliament of Religions and Religious Congresses at the World’s Columbian Exposition published in Chicago in 1893. From left to right: \"Narasimha Chaira [Narasimhacharya of Chennai], Lakeshnie Narain [Lakshmi Narain, a barrister from Lahore], Swami Vivekananda, H. Dharmapala [Anagarika Hewivitarne Dharmapala, a Buddhist from Ceylon and later the founder of the Mahabodhi Society in Kolkata], and Vichand Ghandi [Virchand Gandhi, a lawyer of Mumbai and the chief exponent of the Jain religion.]", "http://i.imgur.com/WRSII1B.jpg    -14"));
                picheadandbody.add(new PicturesPOJO("COSSIPORE GARDEN HOUSE, AUGUST 16, 1886", "when Sri Ramakrishna had been dressed in an ochre cloth and decorated with sandal paste and flowers, the photographs were taken. Sri Ramakrishna’s body was placed on a cot which was decorated all over with flowers. Then the Master’s body was adorned with sandal paste on his face and garlands around his neck. Ram Datta stood in front of the cot and asked Narendra to stand by his side. The rest of us stood silently behind on the staircase. The Bengal Photographers took two group photographs.", "http://i.imgur.com/InNQcaM.jpg    -4"));
                picheadandbody.add(new PicturesPOJO("circa 1892 or early 1893", "The photographs of Swamiji during his wandering days in 1892 and early 1893 clearly confirm the accounts given by those who met him at that time. When Swamiji first arrived in Belgaum, he stayed with the father of G. S. Bhate who remembered that the swami \"was rather striking in appearance and appeared to be even at first sight somewhat out of the common run of men. . . . Though he wore clothes bearing the familiar color of a sannyasin’s garments, he appeared to be dressed differently from the familiar brotherhood of sannyasins.", "http://i.imgur.com/zg1szwp.jpg    -11"));
                picheadandbody.add(new PicturesPOJO("IN AMERICA", "This photo is often referred to as probably at the Hale residence, Chicago, 1893. But \"Mrs. Herbert E. Hyde (Mary Hale’s niece) could not recognize this as being a room in the Hale’s house or in the Walton Place flatľboth of which places she knew very well as a child.\" Sister Gargi (Marie Louise Burke) has speculated that if the photo were taken in 1893 before the Parliament of Religions, then it could possibly have been taken in the Lyon’s house in Chicago.", "http://i.imgur.com/Yo6rxT4.jpg    -13"));
                picheadandbody.add(new PicturesPOJO("CALCUTTA, circa 1886", "Sri Ramakrishna once said of Swamiji: “He is a burning, roaring fire consuming all impurities to ashes.”", "http://i.imgur.com/ZqSKyNp.jpg    -2"));
                picheadandbody.add(new PicturesPOJO("circa 1892 or early 1893", "Another interesting anecdote about Swamiji’s appearance around this time comes from D. B. Raghunath Rao, the youngest son of D. R. Balaji Rao of Chennai, who was a close friend of Swamiji. Balaji told his son: \"Swamiji was an arresting personality with handsome features, always smiling and had a robust constitution. His voice had a pleasant ringing tone.\" Raghunath Rao continues: \"My father who was fond of tying his turban in various modes, presented one such length of cloth to Swamiji. It is this that adorns his head in the popular photographs published; and the sash around his waist which we also see in the photos [Chicago, 1893] was presented to him by the Maharaja of Khetri.\"", "http://i.imgur.com/RWeB4VP.jpg    -12"));
                picheadandbody.add(new PicturesPOJO("BELGAUM, OCTOBER 1892", "Haripada Mitra was one of Swamiji's hosts while he was staying in Belgaum in 1892. Haripada convinced Swamiji to accept both him and his wife as disciples. In his reminiscences, he remarked further:\n" +
                        "\n" +
                        "I had a desire to have his photograph. He would not agree. I persisted, and after a long drawn tussle, he gave his consent and a photograph was taken on the 28th. [This photo was taken prior to the twenty-eighth, since Swamiji is reported to have left Belgaum on the twenty-seventh.] As Swamiji had not agreed to be photographed on an earlier occasion, in spite of the earnest request of another gentleman, I had to send two copies of this one to him on request.", "http://i.imgur.com/DCm7s6u.jpg    -9"));
                picheadandbody.add(new PicturesPOJO("JAIPUR, 1891 (probably)", "“At Jaipur the disciple [perhaps Lala Govinda Sahai whom Swamiji initiated in Rajputana in 1891] insisted on the swami’s posing for a photograph. The swami, much against his wishes, finally consented. This was the first time that a photo of him as a wandering monk was taken.”", "http://i.imgur.com/3JiLMDx.jpg    -7"));
                picheadandbody.add(new PicturesPOJO("TRIVANDRUM, DECEMBER 1892", "This photo was taken by Prince Martanda Varma of Travancore. K. Sundararama Iyer, the tutor of Prince Martanda Varma (the first prince of Travancore), remarked in his reminiscences", "http://i.imgur.com/1Maealh.jpg    -10"));
                picheadandbody.add(new PicturesPOJO("BARANAGORE MATH, JANUARY 30, 1887", "A Gospel of Sri Ramakrishna was published by the San Francisco Vedanta Society in 1912 under Swami Trigunatita’s direction. A quaint variation of this Baranagore Math photograph was printed in the 1912 edition of the Gospel.", "http://i.imgur.com/KxNUalC.jpg    -6"));
                picheadandbody.add(new PicturesPOJO("CALCUTTA, circa 1885", "The best descriptions of Swamiji around this time have been given by his master, Sri Ramakrishna. On a certain occasion the Master said to the disciples present, pointing to Narendranath, “Behold! Here is Naren. See! See! Oh what power of insight he has! It is like the shoreless sea of radiant knowledge! ", "http://i.imgur.com/w94m0Xz.jpg"));


                Collections.reverse(picheadandbody);
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
                mFirebaseAnalytics.logEvent("pictures_click", null);
                break;
        }
    }




}

