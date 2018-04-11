package com.rtmap.traffic.touch.model.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rtmap.traffic.touch.util.DateUtil;
import org.springframework.util.StringUtils;

public class FlightDynInfoTemp {
    private Long flightId;

    private String flightNo;

    private String flightDate;

    private String airportCode;

    private String adid;

    private String company;

    private String oriAirport;

    private String desAirport;

    private String oriCity;

    private String desCity;

    private String flightStatus;

    private String totalMileage;

    private String ontimePercent;

    private Integer hasFlyTime;

    private Integer lastFlyTime;

    @JsonFormat(pattern = DateUtil.FORMAT_DATE_TIME, timezone="GMT+8")
    private Date planTakeoffTime;

    @JsonFormat(pattern = DateUtil.FORMAT_DATE_TIME, timezone="GMT+8")
    private Date planLandTime;

    @JsonFormat(pattern = DateUtil.FORMAT_DATE_TIME, timezone="GMT+8")
    private Date wheelsUpTime;

    @JsonFormat(pattern = DateUtil.FORMAT_DATE_TIME, timezone="GMT+8")
    private Date wheelsDownTime;

    @JsonFormat(pattern = DateUtil.FORMAT_DATE_TIME, timezone="GMT+8")
    private Date estDepTime;

    @JsonFormat(pattern = DateUtil.FORMAT_DATE_TIME, timezone="GMT+8")
    private Date estArrTime;

    private String checkinDeskRange;

    private String oriTerminal;

    private String desTerminal;

    private String flightSectorCode;

    private String gn;

    private String baggageCarousel;

    private String linkedFlightIdentity;

    private String preFlightStatusDesc;

    private Date updateTime;

    private String oriCityTime;

    private String desCityTime;

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAdid() {
        return adid;
    }

    public void setAdid(String adid) {
        this.adid = adid;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getOriAirport() {
        return oriAirport;
    }

    public void setOriAirport(String oriAirport) {
        this.oriAirport = oriAirport;
    }

    public String getDesAirport() {
        return desAirport;
    }

    public void setDesAirport(String desAirport) {
        this.desAirport = desAirport;
    }

    public String getOriCity() {
        return oriCity;
    }

    public void setOriCity(String oriCity) {
        this.oriCity = oriCity;
    }

    public String getDesCity() {
        return desCity;
    }

    public void setDesCity(String desCity) {
        this.desCity = desCity;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    public String getTotalMileage() {
        return totalMileage;
    }

    public void setTotalMileage(String totalMileage) {
        this.totalMileage = totalMileage;
    }

    public String getOntimePercent() {
        return ontimePercent;
    }

    public void setOntimePercent(String ontimePercent) {
        this.ontimePercent = ontimePercent;
    }

    public Integer getHasFlyTime() {
        return hasFlyTime;
    }

    public void setHasFlyTime(Integer hasFlyTime) {
        this.hasFlyTime = hasFlyTime;
    }

    public Integer getLastFlyTime() {
        return lastFlyTime;
    }

    public void setLastFlyTime(Integer lastFlyTime) {
        this.lastFlyTime = lastFlyTime;
    }

    public Date getPlanTakeoffTime() {
        return planTakeoffTime;
    }

    public void setPlanTakeoffTime(Date planTakeoffTime) {
        this.planTakeoffTime = planTakeoffTime;
    }

    public Date getPlanLandTime() {
        return planLandTime;
    }

    public void setPlanLandTime(Date planLandTime) {
        this.planLandTime = planLandTime;
    }

    public Date getWheelsUpTime() {
        return wheelsUpTime;
    }

    public void setWheelsUpTime(Date wheelsUpTime) {
        this.wheelsUpTime = wheelsUpTime;
    }

    public Date getWheelsDownTime() {
        return wheelsDownTime;
    }

    public void setWheelsDownTime(Date wheelsDownTime) {
        this.wheelsDownTime = wheelsDownTime;
    }

    public Date getEstDepTime() {
        return estDepTime;
    }

    public void setEstDepTime(Date estDepTime) {
        this.estDepTime = estDepTime;
    }

    public Date getEstArrTime() {
        return estArrTime;
    }

    public void setEstArrTime(Date estArrTime) {
        this.estArrTime = estArrTime;
    }

    public String getCheckinDeskRange() {
        return checkinDeskRange;
    }

    public void setCheckinDeskRange(String checkinDeskRange) {
        this.checkinDeskRange = checkinDeskRange;
    }

    public String getOriTerminal() {
        return oriTerminal;
    }

    public void setOriTerminal(String oriTerminal) {
        this.oriTerminal = oriTerminal;
    }

    public String getDesTerminal() {
        return desTerminal;
    }

    public void setDesTerminal(String desTerminal) {
        this.desTerminal = desTerminal;
    }

    public String getFlightSectorCode() {
        return flightSectorCode;
    }

    public void setFlightSectorCode(String flightSectorCode) {
        this.flightSectorCode = flightSectorCode;
    }

    public String getGn() {
        return gn;
    }

    public void setGn(String gn) {
        this.gn = gn;
    }

    public String getBaggageCarousel() {
        return baggageCarousel;
    }

    public void setBaggageCarousel(String baggageCarousel) {
        this.baggageCarousel = baggageCarousel;
    }

    public String getLinkedFlightIdentity() {
        return linkedFlightIdentity;
    }

    public void setLinkedFlightIdentity(String linkedFlightIdentity) {
        this.linkedFlightIdentity = linkedFlightIdentity;
    }

    public String getPreFlightStatusDesc() {
        return preFlightStatusDesc;
    }

    public void setPreFlightStatusDesc(String preFlightStatusDesc) {
        this.preFlightStatusDesc = preFlightStatusDesc;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOriCityTime() {
        return StringUtils.isEmpty(oriCityTime) ? "GMT+8" : oriCityTime;
    }

    public void setOriCityTime(String oriCityTime) {
        this.oriCityTime = oriCityTime;
    }

    public String getDesCityTime() {
        return StringUtils.isEmpty(desCityTime) ? "GMT+8" : desCityTime;
    }

    public void setDesCityTime(String desCityTime) {
        this.desCityTime = desCityTime;
    }
}