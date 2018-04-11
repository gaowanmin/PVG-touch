package com.rtmap.traffic.touch.model.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rtmap.traffic.touch.util.DateUtil;

public class PcMonitor {
    private Integer id;

    private String pcId;

    @JsonFormat(pattern = DateUtil.FORMAT_DATE_TIME,timezone ="GMT+8")
    private Date heartBeat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPcId() {
        return pcId;
    }

    public void setPcId(String pcId) {
        this.pcId = pcId == null ? null : pcId.trim();
    }

    public Date getHeartBeat() {
        return heartBeat;
    }

    public void setHeartBeat(Date heartBeat) {
        this.heartBeat = heartBeat;
    }
}