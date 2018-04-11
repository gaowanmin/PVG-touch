package com.rtmap.traffic.touch.model.entity;

import java.util.Date;

public class ModuleUpdateTime {
    private String moduleName;

    private Date updateTime;

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}