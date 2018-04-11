package com.rtmap.traffic.touch.service;

import com.rtmap.traffic.touch.model.vo.OpRst;

public interface IBairTrafInfoService {

	public OpRst<Object> getTrafficInfo();

	public OpRst<Object> getTaxi();
}
