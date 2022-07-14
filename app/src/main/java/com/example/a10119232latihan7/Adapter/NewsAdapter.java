package com.example.a10119232latihan7.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a10119232latihan7.Model.ArticlesModel;
import com.example.a10119232latihan7.R;

import java.util.List;

/*M Faisal Obara
10119232
IF 6
08 Juli 2022*/

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyHolder> {
    List<ArticlesModel> mList;
    Context ctx;

    public NewsAdapter(Context ctx, List<ArticlesModel> mList){
        this.mList = mList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        ArticlesModel newsModel = mList.get(position);
        if (position<=10) {
            holder.title.setText(newsModel.getTitle());
            holder.description.setText(newsModel.getDescription());
            if (newsModel.getAuthor() == null) {
                holder.author.setText("Anonymous");
            } else {
                holder.author.setText(newsModel.getAuthor());
            }
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView title,description,author,count;
        ArticlesModel userListModelData;
        public MyHolder(@NonNull View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.txtTitle);
            description = (TextView) v.findViewById(R.id.txtDescription);
            author = (TextView) v.findViewById(R.id.txtAuthor);
        }
    }
}
