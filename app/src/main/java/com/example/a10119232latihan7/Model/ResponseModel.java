package com.example.a10119232latihan7.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/*M Faisal Obara
10119232
IF 6
08 Juli 2022*/

public class ResponseModel {

    @SerializedName("status")
    public String status;
    @SerializedName("articles")
    public List<ArticlesModel> articles = new ArrayList<>();

    public String getStatus() {return status;}

    public List<ArticlesModel> getArticles() {return articles;}
}
