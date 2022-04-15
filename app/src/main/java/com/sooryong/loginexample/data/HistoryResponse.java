package com.sooryong.loginexample.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HistoryResponse {
    @SerializedName("EventID")
    public int eventID;

    @SerializedName("SensorID")
    public String sensorID;

    @SerializedName("SensorName")
    public String sensorName;

    @SerializedName("EventType")
    public String eventType;

    @SerializedName("EventDate")
    public String eventDate;

    @SerializedName("EventTime")
    public String eventTime;

    @SerializedName("UserID")
    public int userID;

    public int getEventID() { return eventID; }

    public String getSensorID() { return sensorID; }

    public String getSensorName() { return sensorName; }

    public String getEventType() { return eventType; }

    public String getEventDate() { return eventDate; }

    public String getEventTime() { return eventTime; }

    public int getUserID() { return userID; }

}
