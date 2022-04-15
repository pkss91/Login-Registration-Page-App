package com.sooryong.loginexample.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Path;

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
        //Toast.makeText(HistoryActivity.this, "spot1", Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        dataInfo = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ServiceApi apiInterface = RetrofitClient.getClient().create(ServiceApi.class);
        Call<List<HistoryResponse>> call = apiInterface.getData();

        recyclerAdapter = new RecyclerAdapter(getApplicationContext(), null);
        recyclerView.setAdapter(recyclerAdapter);

        call.enqueue(new Callback<List<HistoryResponse>>() {
            @Override
            public void onResponse(Call<List<HistoryResponse>> call, Response<List<HistoryResponse>> response) {
                List<HistoryResponse> historyResponses = response.body();
                Toast.makeText(HistoryActivity.this, "History", Toast.LENGTH_SHORT).show();

                //looping through entire history responses list
                for (int i=0;i<historyResponses.size();i++)
                {
                    Log.d("Response", historyResponses.get(i).getEventType());
                }

                recyclerAdapter = new RecyclerAdapter(getApplicationContext(), dataInfo);
                recyclerView.setAdapter(recyclerAdapter);
            }

            @Override
            public void onFailure(Call<List<HistoryResponse>> call, Throwable t) {
                Log.d("Response", t.getMessage());
            }
        });
    }

}