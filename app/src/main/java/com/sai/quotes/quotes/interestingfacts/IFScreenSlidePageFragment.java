/*
 * Copyright 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sai.quotes.quotes.interestingfacts;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sai.quotes.quotes.R;

import java.util.ArrayList;

/**
 * A fragment representing a single step in a wizard. The fragment shows a dummy title indicating
 * the page number, along with some dummy text.
 * <p>
 * ScreenSlideActivity} samples.</p>
 */
public class IFScreenSlidePageFragment extends Fragment {


    private ArrayList<String> student;
    private TextView quotesLargeTV, currentItemValue;
    private View controlsView;
    ImageView heartWhite, heartRed, shareImg;
    private SharedPreferences.Editor editor;
    private SharedPreferences sharedPreferences;
    private String selectedarray;
    private ArrayList<String> favouritearraySP;

    /**
     * The argument key for the page number this fragment represents.
     */
    public static final String ARG_PAGE = "page";

    /**
     * The fragment's page number, which is set to the argument value for {@link #ARG_PAGE}.
     */
    private int mPageNumber;
    ArrayList<InterestingFactsPOJO> ifsendarr;

    /**
     * Factory method for this fragment class. Constructs a new fragment for the given page number.
     */
    public static IFScreenSlidePageFragment create(int pageNumber) {
        IFScreenSlidePageFragment fragment = new IFScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
//        args.putString("dummy_array",ifsendarr);
        fragment.setArguments(args);
        return fragment;
    }

    public IFScreenSlidePageFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageNumber = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        sharedPreferences = getContext().getSharedPreferences("mypreference", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
//        selectedarray = sharedPreferences.getString("selectedarray", "");
//        selectedarray = selectedarray.replace("[", "");
//        selectedarray = selectedarray.replace("]", "");
//        selectedarray = selectedarray.replace(".,", ".~");
//        final ArrayList<String> selctedarrayitems = new ArrayList<>();
//
//        if (selectedarray != null) {
//            selctedarrayitems.addAll(Arrays.asList(selectedarray.split("\\s*~\\s*")));
//
//        }
//
//
//        String selectedValue = sharedPreferences.getString("storespValues", "");
//        selectedValue = selectedValue.replace("[", "");
//        selectedValue = selectedValue.replace("]", "");
//        selectedValue = selectedValue.replace(".,", ".~");
//        favouritearraySP = new ArrayList<>();
//
//
//        if (selectedValue != null) {
//            favouritearraySP.addAll(Arrays.asList(selectedValue.split("\\s*~\\s*")));
//        }


        //Get to SharedPreferences
        Gson gson = new Gson();
        //For default value, just to get no errors while getting no value from the SharedPreferences
        String empty_list = gson.toJson(new ArrayList<InterestingFactsPOJO>());

        ArrayList<InterestingFactsPOJO> selectedPOJO = gson.fromJson(sharedPreferences.getString("selectedarray", empty_list),
                new TypeToken<ArrayList<InterestingFactsPOJO>>() {
                }.getType());


//        String[] arraytodisplay=getResources().getStringArray(R.array.arr);

//        int a = 1;

        // Inflate the layout containing a title and body text.
        ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.if_screen_layout, container, false);
//        controlsView = rootView.findViewById(R.id.control_toolbar_fullscreen);
//        heartWhite = (ImageView) controlsView.findViewById(R.id.heart_icon_white);
//        heartRed = (ImageView) controlsView.findViewById(R.id.heart_icon_red);
//        shareImg = (ImageView) controlsView.findViewById(R.id.share_icon);
//        quotesLargeTV = (TextView) rootView.findViewById(R.id.textView);
//        currentItemValue= (TextView) rootView.findViewById(R.id.current_Item_value);


        // Set the title view to show the page number.
//        ((TextView) rootView.findViewById(android.R.id.text1)).setText(
//                getString(mPageNumber + 1));

//        ((TextView) rootView.findViewById(android.R.id.text1)).setText(selctedarrayitems.get(mPageNumber).toString());


        TextView headingTV = (TextView) rootView.findViewById(R.id.heading_TV);
        TextView bodyTV = (TextView) rootView.findViewById(R.id.body_TV);
        currentItemValue = (TextView) rootView.findViewById(R.id.current_Item_value);
        RelativeLayout mainLayout= (RelativeLayout) rootView.findViewById(R.id.main_layout_if_screen);
        mainLayout.getBackground().setAlpha(140);

        headingTV.setText(selectedPOJO.get(mPageNumber).getHeading().toString());
        bodyTV.setText(selectedPOJO.get(mPageNumber).getBody().toString());
//        quotesLargeTV.setText("\"" + selctedarrayitems.get(mPageNumber).toString() + "\"");
        currentItemValue.setText(mPageNumber + 1 + "/" + String.valueOf(selectedPOJO.size()));
//
//        final String currentItem = selctedarrayitems.get(mPageNumber).toString();

        //heart image appearNCE and onclick action
//        holder.quoteItemTV.setText(quotesarray[position]);
//        if (favouritearraySP.contains(currentItem)) {
//
//            heartWhite.setVisibility(View.INVISIBLE);
//            heartRed.setVisibility(View.VISIBLE);
//        } else {
//            heartWhite.setVisibility(View.VISIBLE);
//            heartRed.setVisibility(View.INVISIBLE);
//        }
//
//        heartWhite.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                    one.get(position).setId(true);
//                heartWhite.setVisibility(View.INVISIBLE);
//                heartRed.setVisibility(View.VISIBLE);
//                favouritearraySP.add(currentItem);
//                editor.putString("storespValues", favouritearraySP.toString());
//                editor.commit();
//            }
//        });
//
//
//        heartRed.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                heartWhite.setVisibility(View.VISIBLE);
//                heartRed.setVisibility(View.INVISIBLE);
//                favouritearraySP.remove(currentItem);
//                editor.putString("storespValues", favouritearraySP.toString());
//                editor.commit();
//            }
//        });
//
//
//        shareImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent sendIntent = new Intent();
//                sendIntent.setAction(Intent.ACTION_SEND);
//                sendIntent.putExtra(Intent.EXTRA_TEXT, selctedarrayitems.get(mPageNumber).toString() + "\n\r" + "~Swami Vivekananda");
//                sendIntent.setType("text/plain");
//                startActivity(Intent.createChooser(sendIntent, selctedarrayitems.get(mPageNumber).toString()));
//            }
//        });
        return rootView;
    }

    /**
     * Returns the page number represented by this fragment object.
     */
    public int getPageNumber() {
        return mPageNumber;
    }
}
