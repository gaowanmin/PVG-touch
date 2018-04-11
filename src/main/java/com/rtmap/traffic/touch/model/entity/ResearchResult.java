package com.rtmap.traffic.touch.model.entity;

import java.util.Date;

public class ResearchResult {
    private Long id;

    private String touchId;

    private String virtualUser;

    private String detailId;

    private String satisfyLevel;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTouchId() {
        return touchId;
    }

    public void setTouchId(String touchId) {
        this.touchId = touchId;
    }

    public String getVirtualUser() {
        return virtualUser;
    }

    public void setVirtualUser(String virtualUser) {
        this.virtualUser = virtualUser;
    }

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId == null ? null : detailId.trim();
    }

    public String getSatisfyLevel() {
        return satisfyLevel;
    }

    public void setSatisfyLevel(String satisfyLevel) {
        this.satisfyLevel = satisfyLevel == null ? null : satisfyLevel.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}