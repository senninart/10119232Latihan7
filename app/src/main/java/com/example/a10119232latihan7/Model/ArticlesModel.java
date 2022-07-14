package com.example.a10119232latihan7.Model;

import com.google.gson.annotations.SerializedName;

/*M Faisal Obara
10119232
IF 6
08 Juli 2022*/

public class ArticlesModel {

    @SerializedName("author")
    public String author;
    @SerializedName("title")
    public String title;
    @SerializedName("description")
    public String description;

    public String getAuthor() {return author;}

    public String getTitle() {return title;}

    public String getDescription() {return description;}
}
