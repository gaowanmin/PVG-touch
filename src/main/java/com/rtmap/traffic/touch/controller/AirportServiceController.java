package com.rtmap.traffic.touch.controller;

import com.rtmap.traffic.touch.model.vo.OpRst;
import com.rtmap.traffic.touch.service.IAirGeneralService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value ="/airportService")
public class AirportServiceController {

	@Resource
	private IAirGeneralService airGeneralService;

    @GetMapping(value = "getServiceMenu")
    public OpRst<Object> getServiceMenu(){
        return airGeneralService.getServiceMenu();
    }

    /**
     * 获取机场基础服务信息
     *
     * @return 操作对象
     */
    @GetMapping(value = "getAirprotService")
    public OpRst<Object> getAirprotService() {
        return airGeneralService.getAirGeneralServiceInfo();
    }
}
