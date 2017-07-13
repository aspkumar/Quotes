/*
package com.sai.quotes.quotes.pictures;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.sai.quotes.quotes.R;

import java.util.ArrayList;

*/
/**
 * Created by PrasannakumarA on 5/19/2017.
 *//*


class PictueresRecyclerView extends RecyclerView.Adapter<PictueresRecyclerView.MyViewHolder> {

    Context context;
    ArrayList<String> dummyArray;
    private SharedPreferences sharedpreferences;
    private SharedPreferences.Editor editor;


    public PictueresRecyclerView(Context context, ArrayList<String> dummyArray) {
        this.context = context;
        this.dummyArray = dummyArray;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_grid_view, parent, false);
        sharedpreferences = context.getSharedPreferences("mypreference", Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {



        // Create global configuration and initialize ImageLoader with this config
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).build();
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(context));

        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true).showImageOnFail(android.R.drawable.stat_notify_error)
                .showImageOnFail(android.R.drawable.stat_notify_error)
                .showImageOnLoading(android.R.drawable.stat_notify_error).cacheOnDisc(true)
                .bitmapConfig(Bitmap.Config.RGB_565).build();
        // Load image, decode it to Bitmap and display Bitmap in ImageView (or any other view
//	which implements ImageAware interface)

        imageLoader.displayImage(dummyArray.get(position), holder.ivgrid, options, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
//                loadingPG.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
//                errloading.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
//                loadingPG.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        }, new ImageLoadingProgressListener() {
            @Override
            public void onProgressUpdate(String imageUri, View view, int current, int total) {
            }
        });


//        imageLoader.displayImage(selectedPOJO.get(mPageNumber).getUrl(), imageView);


    }

    @Override
    public int getItemCount() {
        return dummyArray.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
       ImageView ivgrid;
        public MyViewHolder(View itemView) {
            super(itemView);
            ivgrid = (ImageView) itemView.findViewById(R.id.image_view_grid);
        }
    }
}
*/
