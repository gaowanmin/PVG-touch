package com.rtmap.traffic.touch.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rtmap.traffic.touch.dao.mapper.PcMonitorMapper;
import com.rtmap.traffic.touch.model.entity.PcMonitor;
import com.rtmap.traffic.touch.model.vo.OpRst;
import com.rtmap.traffic.touch.service.IPcMonitorService;
@Service
public class PcMonitorServiceImpl implements IPcMonitorService {

	@Autowired
	private PcMonitorMapper pcMonitorMapper;
	
	public OpRst<Object> savePcMonitor(PcMonitor pcMonitor) {
		PcMonitor pcMonitorOld = pcMonitorMapper.selectMonitorByPcId(pcMonitor.getPcId());
		int row;
		if(pcMonitorOld != null){
			pcMonitorOld.setHeartBeat(new Date());
			row = pcMonitorMapper.updateByPrimaryKeySelective(pcMonitorOld);
		}else{
			pcMonitor.setHeartBeat(new Date());
			row = pcMonitorMapper.insertSelective(pcMonitor);
		}
		return row > 0 ? new OpRst<Object>(0,"success") : new OpRst<Object>(-1,"failed");
	}

	public OpRst<Object> getAllPcMonitorInfo() {
		List<PcMonitor> list = pcMonitorMapper.selectAllMonitorInfo();
		return new OpRst<Object>(0,list);
	}

}
