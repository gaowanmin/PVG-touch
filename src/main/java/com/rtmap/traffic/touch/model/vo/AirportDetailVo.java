package com.rtmap.traffic.touch.model.vo;

/**
 * 基础机场VO
 * @author xuhailong
 * @Date 2017/3/15
 */
public class AirportDetailVo {

    /**
     * 机场三字码
     */
    private String airportCode;

    /**
     * 机场名称
     */
    private String airportName;

    /**
     * 机场拼音缩写
     */
    private String namePy;

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getNamePy() {
        return namePy;
    }

    public void setNamePy(String namePy) {
        this.namePy = namePy;
    }
}
