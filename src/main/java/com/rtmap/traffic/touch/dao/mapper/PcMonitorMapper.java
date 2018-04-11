package com.rtmap.traffic.touch.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rtmap.traffic.touch.dao.BaseMapper;
import com.rtmap.traffic.touch.model.entity.PcMonitor;
@Mapper
public interface PcMonitorMapper extends BaseMapper<PcMonitor>{
	
	/**
	 * 查询所有监控信息
	 * @return 监控列表
	 */
	List<PcMonitor> selectAllMonitorInfo();

	/**
	 * 根据pcId查询监控对象
	 * @param pcId 机器标识
	 * @return 监控对象
	 */
	PcMonitor selectMonitorByPcId(String pcId);
}