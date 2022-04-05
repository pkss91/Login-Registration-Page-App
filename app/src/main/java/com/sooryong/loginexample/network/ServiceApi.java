package com.sooryong.loginexample.network;

import com.sooryong.loginexample.data.JoinData;
import com.sooryong.loginexample.data.JoinResponse;
import com.sooryong.loginexample.data.LoginData;
import com.sooryong.loginexample.data.LoginResponse;
import com.sooryong.loginexample.data.HistoryResponse;
import com.sooryong.loginexample.data.HistoryData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.GET;

public interface ServiceApi {
    @POST("/user/login")
    Call<LoginResponse> userLogin(@Body LoginData data);

    @POST("/user/join")
    Call<JoinResponse> userJoin(@Body JoinData data);

    @GET("/test/history")
    Call<HistoryResponse> getData();
}