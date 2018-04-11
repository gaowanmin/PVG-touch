package com.rtmap.traffic.touch.model.entity;

public class AirGeneralServiceInfoDetail {
    private Long airServiceDetailId;

    private Long airServiceId;

    private Integer sort;

    private String title;

    private String keyWord;
    
    private String content;

    private String contetnNoHtml;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getContetnNoHtml() {
        return contetnNoHtml;
    }

    public void setContetnNoHtml(String contetnNoHtml) {
        this.contetnNoHtml = contetnNoHtml == null ? null : contetnNoHtml.trim();
    }
    public Long getAirServiceDetailId() {
        return airServiceDetailId;
    }

    public void setAirServiceDetailId(Long airServiceDetailId) {
        this.airServiceDetailId = airServiceDetailId;
    }

    public Long getAirServiceId() {
        return airServiceId;
    }

    public void setAirServiceId(Long airServiceId) {
        this.airServiceId = airServiceId;
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

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord == null ? null : keyWord.trim();
    }
}