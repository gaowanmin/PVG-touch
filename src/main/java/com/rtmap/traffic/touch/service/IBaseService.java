package com.rtmap.traffic.touch.service;

/**
 * @author xuhailong
 * @Date 2017/3/14
 */
public interface IBaseService {
    /**
     * 查询 航班 最后同步时间 是否在规定范围内
     *
     * @return boolean
     */
    boolean checkFltUpdateTime();

    /**
     * 查询 热门城市 最后同步时间 是否在规定范围内
     *
     * @return boolean
     */
    boolean checkHotCityUpdateTime();

    /**
     * 查询 交通 最后同步时间 是否在规定范围内
     *
     * @return boolean
     */
    boolean checkTrafficUpdateTime();

    /**
     * 查询 问卷 最后同步时间 是否在规定范围内
     *
     * @return boolean
     */
    boolean checkResearchUpdateTime();
}
