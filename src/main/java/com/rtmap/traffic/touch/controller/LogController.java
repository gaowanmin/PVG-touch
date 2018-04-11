package com.rtmap.traffic.touch.controller;

import com.rtmap.traffic.touch.model.entity.log.LogAction;
import com.rtmap.traffic.touch.model.vo.OpRst;
import com.rtmap.traffic.touch.service.IPvgLogService;
import com.rtmap.traffic.touch.util.DateUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 记录日志
 *
 * @author xuhailong
 * @Date 2017/4/5
 */
@RestController
@RequestMapping( value = "log")
public class LogController {

    @Resource private IPvgLogService pvgLogService;

    /**
     * 收集日志 前端主动调用
     * @param request
     * @return
     */
    @GetMapping(value = "addLog")
    public OpRst addLog(HttpServletRequest request) {
        LogAction pvgLog = new LogAction();
        String virtualUser = request.getParameter("virtualUser");
        if (!StringUtils.isEmpty(virtualUser)) {
            pvgLog.setVirtualUser(virtualUser);
        }

        pvgLog.setCurrentAirport("PVG");
        pvgLog.setTouchId(request.getParameter("touchId"));
        pvgLog.setModule(request.getParameter("module"));
        pvgLog.setAction(request.getParameter("action"));
        String requestTime = request.getParameter("requestTime");
        if (!StringUtils.isEmpty(requestTime)) {
            pvgLog.setRequestTime(DateUtil.parseDate(Long.valueOf(requestTime)));
        }
        pvgLog.setReceivedTime(new Date());
        String debug = request.getParameter("debug");
        if (!StringUtils.isEmpty(debug) && !debug.trim().equals("0")) {
            pvgLog.setRmk("test");
        }
        pvgLogService.addLogAction(pvgLog);

        return new OpRst(0, "success");
    }

}
