package com.rtmap.traffic.touch.util;

/**
 * 航班状态
 *
 * @author xuhailong
 * @Date 2017/3/14
 */
public enum FlightStatusEnum {

    //2017-3-27 修改
    PLA("计划"),
    TAK("起飞"),
    ARR("到达"),
    DLY("延误"),
    CNL("取消"),
    LC("催促登机"),
    GO("正在登机"),
    AXOT("等待起飞"),
    GC("登机结束"),
    DV("备降"),
    GJ("改降"),

//    FOR("FOR"),
//
//    SH("SH"),
//    ADF("ADF"),
//    NO("NO"),
//    CSF("CSF"),
//    NOP("NOP"),
//
//
//    REG("正常"),
//    DEL("延误有预计时间"),
//    DFI("延误无预计时间"),
//    CAN("航班取消"),
//    ADV("航班提前"),
//    MER("合并航班"),
//    RET("返航"),
//    CHG("改降"),
//    ALT("备降")
    ;

    public String value;

    FlightStatusEnum(String value) {
        this.value = value;
    }

}
