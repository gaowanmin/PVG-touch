package com.rtmap.traffic.touch.model.vo;

import java.util.Date;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rtmap.traffic.touch.util.DateUtil;
import com.rtmap.traffic.touch.util.FlightStatusEnum;

/**
 * 航班查询返回基类
 *
 * @author xuhailong
 * @Date 2017/3/14
 */
public class FlightQueryVo {

    /**
     * id
     */
    private Long flightId;

    /**
     * 计划起飞时间
     */
    @JsonFormat(pattern = DateUtil.FORMAT_DATE_TIME, timezone="GMT+8")
    private Date planTakeoffTime;

    /**
     * 起飞城市
     */
    private String oriCity;

    /**
     * 航空公司
     */
    private String company;

    /**
     * 航班号
     */
    private String flightNo;

    /**
     * 计划降落时间
     */
    @JsonFormat(pattern = DateUtil.FORMAT_DATE_TIME, timezone="GMT+8")
    private Date planLandTime;

    /**
     * 降落城市
     */
    private String desCity;

    /**
     * 航班状态
     */
    private String flightStatus;

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Date getPlanTakeoffTime() {
        return planTakeoffTime;
    }

    public void setPlanTakeoffTime(Date planTakeoffTime) {
        this.planTakeoffTime = planTakeoffTime;
    }

    public String getOriCity() {
        return oriCity;
    }

    public void setOriCity(String oriCity) {
        this.oriCity = oriCity;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public Date getPlanLandTime() {
        return planLandTime;
    }

    public void setPlanLandTime(Date planLandTime) {
        this.planLandTime = planLandTime;
    }

    public String getDesCity() {
        return desCity;
    }

    public void setDesCity(String desCity) {
        this.desCity = desCity;
    }

    public String getFlightStatus() {
        if (!StringUtils.isEmpty(flightStatus)) {
            return FlightStatusEnum.valueOf(flightStatus).value;
        }
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }
}

