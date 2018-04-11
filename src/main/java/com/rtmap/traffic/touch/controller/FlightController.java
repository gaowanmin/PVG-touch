package com.rtmap.traffic.touch.controller;

import com.rtmap.traffic.touch.model.vo.OpRst;
import com.rtmap.traffic.touch.service.IFlightService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 航班查询
 *
 * @author xuhailong
 * @Date 2017/3/13
 */
@RestController
@RequestMapping(value = "flt")
public class FlightController {

    @Resource
    private IFlightService flightService;

    /**
     * 按航班号查询
     *
     * @param request 请求入参
     * @return 返回结果实体
     */
    @GetMapping(value = "queryByFltNo")
    public OpRst queryByFltNo(HttpServletRequest request) {
        return flightService.queryByFltNo(request);
    }

    /**
     * 按起降地查询
     *
     * @param request 请求入参
     * @return 返回结果实体
     */
    @GetMapping(value = "queryByAirport")
    public OpRst queryByAirport(HttpServletRequest request) {
        return flightService.queryByAirport(request);
    }

    /**
     * 通过Id 获取详情
     *
     * @param request 请求入参
     * @return 返回结果实体
     */
    @GetMapping(value = "queryDetailById")
    public OpRst queryDetailById(HttpServletRequest request) {
        return flightService.queryDetailById(request);
    }

    /**
     * 获取国内航班基础数据列表
     *
     * @return 返回结果实体
     */
    @GetMapping(value = "queryAirportD")
    public OpRst queryAirportD() {
        return flightService.queryAirportD();
    }

    /**
     * 获取国际航班基础数据列表
     *
     * @return 返回结果实体
     */
    @GetMapping(value = "queryAirportI")
    public OpRst queryAirportI() {
        return flightService.queryAirportI();
    }

}
