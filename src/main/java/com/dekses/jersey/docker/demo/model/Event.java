package com.dekses.jersey.docker.demo.model;

import org.json.simple.JSONObject;

public class Event {

    private int userId;

    private String eventTime;

    private long eventLocLongitude;

    private String noun;

    private String pay;

    private int timeSpent;

    private JSONObject properties;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public long getEventLocLongitude() {
        return eventLocLongitude;
    }

    public void setEventLocLongitude(long eventLocLongitude) {
        this.eventLocLongitude = eventLocLongitude;
    }

    public String getNoun() {
        return noun;
    }

    public void setNoun(String noun) {
        this.noun = noun;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }

    public JSONObject getProperties() {
        return properties;
    }

    public void setProperties(JSONObject properties) {
        this.properties = properties;
    }

    public Event(int userId, String eventTime, long eventLocLongitude, String noun, String pay, int timeSpent, JSONObject properties) {
        this.userId = userId;
        this.eventTime = eventTime;
        this.eventLocLongitude = eventLocLongitude;
        this.noun = noun;
        this.pay = pay;
        this.timeSpent = timeSpent;
        this.properties = properties;
    }

}
