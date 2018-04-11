package com.rtmap.traffic.touch.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rtmap.traffic.touch.model.entity.PcMonitor;
import com.rtmap.traffic.touch.model.vo.OpRst;
import com.rtmap.traffic.touch.service.IPcMonitorService;

@RestController
@RequestMapping(value = "monitor")
public class PcMonitorController {

	@Resource
	private IPcMonitorService pcMonitorService;
	
	@PostMapping(value = "savePcMonitor", produces = "application/json")
	public OpRst<Object> savePcMonitor(@RequestBody PcMonitor pcMonitor){
		return pcMonitorService.savePcMonitor(pcMonitor);
	}
	
	@GetMapping(value = "getAllPcMonitorInfo")
	public OpRst<Object> getAllPcMonitorInfo(){
		return pcMonitorService.getAllPcMonitorInfo();
	}
}
