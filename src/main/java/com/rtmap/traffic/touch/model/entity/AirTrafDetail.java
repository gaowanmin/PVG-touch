package com.rtmap.traffic.touch.model.entity;

public class AirTrafDetail {
    private Long detailId;

    private Long airTrafId;

    private Integer sort;

    private String title;

    private String content;

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public Long getAirTrafId() {
        return airTrafId;
    }

    public void setAirTrafId(Long airTrafId) {
        this.airTrafId = airTrafId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}