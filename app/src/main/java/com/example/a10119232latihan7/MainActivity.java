package com.example.a10119232latihan7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.a10119232latihan7.Adapter.NewsAdapter;
import com.example.a10119232latihan7.Api.ApiEndPoint;
import com.example.a10119232latihan7.Api.ApiService;
import com.example.a10119232latihan7.Model.ArticlesModel;
import com.example.a10119232latihan7.Model.ResponseModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*M Faisal Obara
10119232
IF 6
08 Juli 2022*/

public class MainActivity extends AppCompatActivity {

    private NewsAdapter viewAdapter;
    private List<ArticlesModel> mItems = new ArrayList<>();
    private static final String status = "ok";

    @BindView(R.id.recyclerNews)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        viewAdapter = new NewsAdapter(this, mItems);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(viewAdapter);

        loadDataNews();
    }

    private void loadDataNews() {
        ApiService api = ApiEndPoint.getClient().create(ApiService.class);

        Call<ResponseModel> call = api.getNews();
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                String status = response.body().getStatus();
                System.out.println("STATUS: "+status);
//                progressBar.setVisibility(View.GONE);
                mItems = response.body().articles;
                System.out.println("STATUS articles "+mItems);
                viewAdapter = new NewsAdapter(MainActivity.this,mItems);
                recyclerView.setAdapter(viewAdapter);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
//                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Oops, your connection is BAD!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}