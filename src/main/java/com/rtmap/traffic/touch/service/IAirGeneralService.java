package com.rtmap.traffic.touch.service;

import com.rtmap.traffic.touch.model.vo.OpRst;

public interface IAirGeneralService {

	/**
	 * 获取机场服务列表
	 * @return 操作对象
	 */
	OpRst<Object> getAirGeneralServiceInfo();

    /**
     * 获取服务页面下的菜单列表
     * @return
     */
    OpRst<Object> getServiceMenu();
}
