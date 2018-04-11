package com.rtmap.traffic.touch.model.entity;

public class BairTrafInfo {
    private Long airTrafId;

    private String airport;

    private String pictureName;

    private String pictureUrl;

    private String serviceCode;

    private String title;

    private Integer sort;

    private String airportName;

    public Long getAirTrafId() {
        return airTrafId;
    }

    public void setAirTrafId(Long airTrafId) {
        this.airTrafId = airTrafId;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport == null ? null : airport.trim();
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName == null ? null : pictureName.trim();
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode == null ? null : serviceCode.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName == null ? null : airportName.trim();
    }
}