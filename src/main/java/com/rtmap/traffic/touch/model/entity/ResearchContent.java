package com.rtmap.traffic.touch.model.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rtmap.traffic.touch.util.DateUtil;

public class ResearchContent {
    private Long contentId;

    private String content;

    private Long parentContentId;

    @JsonFormat(pattern=DateUtil.FORMAT_DATE_TIME, timezone="GMT+8")
    private Date createTime;
    
    @JsonFormat(pattern=DateUtil.FORMAT_DATE_TIME, timezone="GMT+8")
    private Date updateTime;

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Long getParentContentId() {
        return parentContentId;
    }

    public void setParentContentId(Long parentContentId) {
        this.parentContentId = parentContentId;
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