package com.rtmap.traffic.touch.service;

import com.rtmap.traffic.touch.model.entity.log.LogAction;

/**
 * @author xuhailong
 * @Date 2017/3/13
 */
public interface IPvgLogService {

    /**
     * 添加服务调用日志
     */
    void addLogAction(LogAction entity);

    /**
     * 添加错误日志
     */
    void addErrorLog(String reason, String rmk);
}
