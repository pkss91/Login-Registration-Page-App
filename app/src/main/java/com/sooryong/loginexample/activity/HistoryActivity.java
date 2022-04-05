package com.sooryong.loginexample.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sooryong.loginexample.R;
import com.sooryong.loginexample.data.HistoryResponse;
import com.sooryong.loginexample.data.HistoryData;
import com.sooryong.loginexample.data.RecyclerAdapter;
import com.sooryong.loginexample.network.RetrofitClient;
import com.sooryong.loginexample.network.ServiceApi;

import java.util.List;
import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    HistoryResponse dataList;

    List<HistoryData> dataInfo;

    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        dataInfo = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ServiceApi apiInterface = RetrofitClient.getClient().create(ServiceApi.class);

        Call<HistoryResponse> call = apiInterface.getData();

        recyclerAdapter = new RecyclerAdapter(getApplicationContext(), null);
        recyclerView.setAdapter(recyclerAdapter);

        call.enqueue(new Callback<HistoryResponse>() {
            @Override
            public void onResponse(Call<HistoryResponse> call, Response<HistoryResponse> response) {

                dataList = response.body();

                Log.d("Response", dataList.toString());

                dataInfo = dataList.result;

                recyclerAdapter = new RecyclerAdapter(getApplicationContext(), dataInfo);
                recyclerView.setAdapter(recyclerAdapter);
            }

            @Override
            public void onFailure(Call<HistoryResponse> call, Throwable t) {

                Log.d("Response", t.getMessage());
            }
        });
    }

}