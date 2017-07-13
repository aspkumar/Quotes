package com.sai.quotes.quotes.retrofit;

/**
 * Created by PrasannakumarA on 5/9/2017.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ExamplPojo {

    @SerializedName("pictures")
    @Expose
    private List<Picture> pictures = null;

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

}