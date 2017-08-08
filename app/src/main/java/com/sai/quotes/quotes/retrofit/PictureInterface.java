package com.sai.quotes.quotes.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by PrasannakumarA on 5/9/2017.
 */

public interface PictureInterface {
    @GET("/bins/mwgqp")
    Call<ExamplPojo> getMyJson();
}
