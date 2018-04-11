package com.rtmap.traffic.touch.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rtmap.traffic.touch.model.vo.OpRst;
import com.rtmap.traffic.touch.service.IBairTrafInfoService;

@RestController
@RequestMapping("traffic")
public class TrafficController {

	@Resource
	private IBairTrafInfoService bairTrafInfoService;
	
	/**
	 * 获取交通出行的工具（不包括出租车）
	 * @return OpRst操作结果对象
	 */
	@GetMapping(value = "getTrafficInfo")
	public OpRst<Object> getTrafficInfo(){
		
		return bairTrafInfoService.getTrafficInfo();
	}
	
	/**
	 * 查询出租车相关的数据信息
	 * @return OpRst操作结果对象
	 */
	@GetMapping(value = "getTaxi")
	public OpRst<Object> getTaxi(){
		
		return bairTrafInfoService.getTaxi();
	}
}
