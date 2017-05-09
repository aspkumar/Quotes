package com.sai.quotes.quotes.biography;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.widget.TextView;

import com.sai.quotes.quotes.R;

/**
 * Created by DELL on 09-05-2017.
 */

public class BiographyMain extends AppCompatActivity{
    TextView headingMain,contemtMain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biography);

        headingMain= (TextView) findViewById(R.id.vivekananda_TV);
        contemtMain= (TextView) findViewById(R.id.content_TV);
        Typeface face1= Typeface.createFromAsset(getAssets(), "fonts/pacifo.ttf");
        headingMain.setTypeface(face1);
//        headingMain.setText("sdfsadfsadf");
        String steps = "Hello Everyone";
        String title="Bold Please!";

        SpannableString ss1=  new SpannableString(title);
        ss1.setSpan(new StyleSpan(Typeface.BOLD), 0, ss1.length(), 0);
        contemtMain.append(ss1);
        contemtMain.append("\n");
        contemtMain.append(steps);
        contemtMain.append("aaaaaaaaaaaanaaaaaaaaaaaaaaaLorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.aaa");
    }
}
