package com.rtmap.traffic.touch.service;

import com.rtmap.traffic.touch.model.entity.PcMonitor;
import com.rtmap.traffic.touch.model.vo.OpRst;

public interface IPcMonitorService {

	/**
	 * 保存监控信息
	 * @param pcMonitor 监控对象
	 * @return 操作对象
	 */
	OpRst<Object> savePcMonitor(PcMonitor pcMonitor);

	/**
	 * 获取所有监控信息
	 * @return 操作对象
	 */
	OpRst<Object> getAllPcMonitorInfo();

}
