package com.sooryong.loginexample.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HistoryResponse {
    @SerializedName("code")
    public String code;

    @SerializedName("message")
    public String message;

    @SerializedName("result")
    public List<HistoryData> result;

    @Override
    public String toString() {

        return "HistoryResponse{" + "result=" + result +'}';
    }

}
