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

package com.sai.quotes.quotes.pictures;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.sai.quotes.quotes.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.ArrayList;

/**
 * A fragment representing a single step in a wizard. The fragment shows a dummy title indicating
 * the page number, along with some dummy text.
 * <p>
 * ScreenSlideActivity} samples.</p>
 */
public class PicturesPageFragment extends Fragment {


    private ArrayList<String> student;
    private TextView quotesLargeTV, currentItemValue, errloading;
    private View controlsView;
    ImageView heartWhite, heartRed, shareImg;
    private SharedPreferences.Editor editor;
    private SharedPreferences sharedPreferences;
    private String selectedarray;
    private ArrayList<String> favouritearraySP;
    BottomSheetBehavior mBottomSheetBehavior1;
    ProgressBar loadingPG;


    /**
     * The argument key for the page number this fragment represents.
     */
    public static final String ARG_PAGE = "page";

    /**
     * The fragment's page number, which is set to the argument value for {@link #ARG_PAGE}.
     */
    private int mPageNumber;
    ArrayList<PicturesPOJO> ifsendarr;

    /**
     * Factory method for this fragment class. Constructs a new fragment for the given page number.
     */
    public static PicturesPageFragment create(int pageNumber) {
        PicturesPageFragment fragment = new PicturesPageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
//        args.putString("dummy_array",ifsendarr);
        fragment.setArguments(args);
        return fragment;
    }

    public PicturesPageFragment() {
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

        //Get to SharedPreferences
        Gson gson = new Gson();
        //For default value, just to get no errors while getting no value from the SharedPreferences
        String empty_list = gson.toJson(new ArrayList<PicturesPOJO>());

        ArrayList<PicturesPOJO> selectedPOJO = gson.fromJson(sharedPreferences.getString("selectedarray", empty_list),
                new TypeToken<ArrayList<PicturesPOJO>>() {
                }.getType());


        // Inflate the layout containing a title and body text.
        final ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.picture_screen_layout, container, false);
        final ImageView imageView = (ImageView) rootView.findViewById(R.id.pictures_IV);
        TextView headingTV = (TextView) rootView.findViewById(R.id.pictures_headingTV);
        TextView bodyTV = (TextView) rootView.findViewById(R.id.pictures_bodyTV);
        currentItemValue = (TextView) rootView.findViewById(R.id.current_Item_value);
        final View bottomSheet = rootView.findViewById(R.id.bottom_sheet1);
        errloading = (TextView) rootView.findViewById(R.id.err_txt);
        loadingPG = (ProgressBar) rootView.findViewById(R.id.laoding_pg);


        // Create global configuration and initialize ImageLoader with this config
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getActivity()).build();
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(getContext()));

        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true).showImageOnFail(android.R.drawable.stat_notify_error)
                .showImageOnFail(android.R.drawable.stat_notify_error)
                .showImageOnLoading(android.R.drawable.stat_notify_error).cacheOnDisc(true)
                .bitmapConfig(Bitmap.Config.RGB_565).build();
        // Load image, decode it to Bitmap and display Bitmap in ImageView (or any other view
//	which implements ImageAware interface)
        imageLoader.displayImage(selectedPOJO.get(mPageNumber).getUrl(), imageView, options, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
loadingPG.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                errloading.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                loadingPG.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        }, new ImageLoadingProgressListener() {
            @Override
            public void onProgressUpdate(String imageUri, View view, int current, int total) {
            }
        });


        imageLoader.displayImage(selectedPOJO.get(mPageNumber).getUrl(), imageView);




      /*  Transformation transformation = new Transformation() {

            @Override
            public Bitmap transform(Bitmap source) {
                int targetWidth = 500;

                double aspectRatio = (double) source.getHeight() / (double) source.getWidth();
                int targetHeight = (int) (targetWidth * aspectRatio);
                Bitmap result = Bitmap.createScaledBitmap(source, targetWidth, targetHeight, false);
                if (result != source) {
                    // Same bitmap is returned if sizes are the same
                    source.recycle();
                }
                return result;
            }

            @Override
            public String key() {
                return "transformation" + " desiredWidth";
            }
        };

//        mMessage_pic_url = message_pic_url;

        Picasso.with(getContext())
                .load(selectedPOJO.get(mPageNumber).getUrl())
                .error(android.R.drawable.stat_notify_error)
                .transform(transformation)
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        bottomSheet.setVisibility(View.VISIBLE);
//                        holder.progressBar_picture.setVisibility(View.GONE);
                        Toast.makeText(getContext(),"onsucess",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError() {
                        bottomSheet.setVisibility(View.GONE);
                        Toast.makeText(getContext(),"onerror",Toast.LENGTH_SHORT).show();
                        Log.e("picasoerror", "error");
//                        holder.progressBar_picture.setVisibility(View.GONE);
                    }
                });
*/


//        Picasso.with(getContext())
//                .load(selectedPOJO.get(mPageNumber).getUrl())
//                .into(imageView);
//        Picasso.with(getContext()).setLoggingEnabled(true);
        headingTV.setText(selectedPOJO.get(mPageNumber).getHeading());
        bodyTV.setText(selectedPOJO.get(mPageNumber).getBody());
//        quotesLargeTV.setText("\"" + selctedarrayitems.get(mPageNumber).toString() + "\"");
        currentItemValue.setText(mPageNumber + 1 + "/" + String.valueOf(selectedPOJO.size()));
        mBottomSheetBehavior1 = BottomSheetBehavior.from(bottomSheet);
        mBottomSheetBehavior1.setState(BottomSheetBehavior.STATE_COLLAPSED);
        mBottomSheetBehavior1.setPeekHeight(100);
        rootView.findViewById(R.id.pictures_IV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bottomSheet.post(new Runnable() {
                    @Override
                    public void run() {
                        if (mBottomSheetBehavior1.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                            mBottomSheetBehavior1.setPeekHeight(100);
                            mBottomSheetBehavior1.setState(BottomSheetBehavior.STATE_EXPANDED);
                        } else {
                            mBottomSheetBehavior1.setState(BottomSheetBehavior.STATE_COLLAPSED);
                        }
//                        mBottomSheetBehavior1.setPeekHeight(100);
//                        mBottomSheetBehavior1.setState(BottomSheetBehavior.STATE_EXPANDED);
                    }
                });
            }
        });

        return rootView;
    }

    /**
     * Returns the page number represented by this fragment object.
     */
    public int getPageNumber() {
        return mPageNumber;
    }
}
