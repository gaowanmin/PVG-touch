package com.rtmap.traffic.touch.model.entity;

public class TaxiFeescale {
    private Integer feescaleId;

    private String cityName;

    private String distance;

    private String day;

    private String night;

    public Integer getFeescaleId() {
        return feescaleId;
    }

    public void setFeescaleId(Integer feescaleId) {
        this.feescaleId = feescaleId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance == null ? null : distance.trim();
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day == null ? null : day.trim();
    }

    public String getNight() {
        return night;
    }

    public void setNight(String night) {
        this.night = night == null ? null : night.trim();
    }
}