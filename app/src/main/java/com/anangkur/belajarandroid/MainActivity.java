package com.anangkur.belajarandroid;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.anangkur.belajarandroid.API.APIService;
import com.anangkur.belajarandroid.API.ApiInterface;
import com.anangkur.belajarandroid.model.RespondAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private SwipeRefreshLayout swipe;
    private RecyclerView recyclerView;
    private MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.maintoolbar);
        swipe = findViewById(R.id.SwipeRefresh);
        recyclerView = findViewById(R.id.ListView);

        mainAdapter = new MainAdapter();
        recyclerView.setAdapter(mainAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        ApiInterface service = APIService.getRetrofitInstance().create(ApiInterface.class);
        service.getAllData().enqueue(new Callback<RespondAPI>() {
            @Override
            public void onResponse(Call<RespondAPI> call, Response<RespondAPI> response) {
                mainAdapter.setData(response.body().getArticles());
            }

            @Override
            public void onFailure(Call<RespondAPI> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
