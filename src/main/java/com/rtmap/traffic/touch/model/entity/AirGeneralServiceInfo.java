package com.rtmap.traffic.touch.model.entity;

public class AirGeneralServiceInfo {
    private Long airServiceId;

    private String airport;

    private String pictureName;

    private String pictureUrl;

    private String serviceCode;

    private String title;

    private Integer sort;

    private String airportName;

    private String htmlUrlType;

    private String terminal;

    private String terminalName;

    private Long parentId;

    private String parentName;

    public Long getAirServiceId() {
        return airServiceId;
    }

    public void setAirServiceId(Long airServiceId) {
        this.airServiceId = airServiceId;
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

    public String getHtmlUrlType() {
        return htmlUrlType;
    }

    public void setHtmlUrlType(String htmlUrlType) {
        this.htmlUrlType = htmlUrlType == null ? null : htmlUrlType.trim();
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal == null ? null : terminal.trim();
    }

    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName == null ? null : terminalName.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName == null ? null : parentName.trim();
    }
}