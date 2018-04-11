package com.rtmap.traffic.touch.model.dto;

import com.rtmap.traffic.touch.model.entity.AirGeneralServiceInfo;

/**
 * @author xuhailong
 * @Date 2017/12/22
 */
public class ServiceInfoDTO extends AirGeneralServiceInfo {

    private int serviceMenuId;

    public int getServiceMenuId() {
        return serviceMenuId;
    }

    public void setServiceMenuId(int serviceMenuId) {
        this.serviceMenuId = serviceMenuId;
    }
}
