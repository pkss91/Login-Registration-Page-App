package com.sooryong.loginexample.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HistoryData {

    @SerializedName("eventID")
    private int eventID;

    @SerializedName("eventType")
    private String eventType;

    @SerializedName("eventDate")
    private String eventDate;

    @SerializedName("userID")
    private int userID;

    @SerializedName("sensorID")
    private String sensorID;

    public HistoryData(int eventID, String eventType, String eventDate, int userID, String sensorID) {
        super();
        this.eventID = eventID;
        this.eventType = eventType;
        this.eventDate = eventDate;
        this.userID = userID;
        this.sensorID = sensorID;
    }

    public int getEventID() {
        return eventID;
    }

    public String getEventType() {
        return eventType;
    }

    public String getEventDate() { return eventDate; }

    public int getUserID() {
        return userID;
    }

    public String getSensorID() { return sensorID; }


}
