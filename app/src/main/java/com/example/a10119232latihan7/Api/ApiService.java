package com.example.a10119232latihan7.Api;

import com.example.a10119232latihan7.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

/*M Faisal Obara
10119232
IF 6
08 Juli 2022*/

public interface ApiService {
    @GET("top-headlines?from=2022-07-07&country=us&apiKey=1a298eeeea1a4d95a787c61db162c244")
    Call<ResponseModel> getNews();
}
