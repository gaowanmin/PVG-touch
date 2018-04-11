package com.rtmap.traffic.touch.service;

import com.rtmap.traffic.touch.model.vo.OpRst;

import javax.servlet.http.HttpServletRequest;

/**
 * 航班查询相关接口
 *
 * @author xuhailong
 * @Date 2017/3/14
 */
public interface IFlightService extends IBaseService {

    /**
     * 按航班号查询
     *
     * @param request 请求入参
     * @return 返回结果实体
     */
    OpRst queryByFltNo(HttpServletRequest request);

    /**
     * 按起降地查询
     *
     * @param request 请求入参
     * @return 返回结果实体
     */
    OpRst queryByAirport(HttpServletRequest request);

    /**
     * 通过Id 获取详情
     *
     * @param request 请求入参
     * @return 返回结果实体
     */
    OpRst queryDetailById(HttpServletRequest request);

    /**
     * 获取国内航班基础数据列表
     *
     * @return 返回结果实体
     */
    OpRst queryAirportD();

    /**
     * 获取国际航班基础数据列表
     *
     * @return 返回结果实体
     */
    OpRst queryAirportI();
}
