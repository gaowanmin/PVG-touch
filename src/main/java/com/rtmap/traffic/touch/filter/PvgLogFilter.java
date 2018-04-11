package com.rtmap.traffic.touch.filter;

import com.alibaba.fastjson.JSON;
import com.rtmap.traffic.touch.model.entity.log.LogAction;
import com.rtmap.traffic.touch.model.vo.OpRst;
import com.rtmap.traffic.touch.service.IPvgLogService;
import com.rtmap.traffic.touch.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * 拦截器 记录所有请求日志和错误日志
 * 排除 monitor 相关
 *
 * @author xuhailong
 * @Date 2017/3/13
 */
public class PvgLogFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private LogAction pvgLog;

    private IPvgLogService pvgLogService;

    public void init(FilterConfig filterConfig) throws ServletException {
        logger.debug(" ==> PvgLogFilter init ");
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
        pvgLogService = webApplicationContext.getBean(IPvgLogService.class);
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.debug(" ==> PvgLogFilter doFilter ");
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
            initAction(httpRequest);
            filterChain.doFilter(servletRequest, servletResponse);

        } catch (Exception e) {
            e.printStackTrace();
            //记录错误日志
            pvgLogService.addErrorLog(((HttpServletRequest) servletRequest).getServletPath(),e.getMessage());
            //向浏览器写出错误
            writeOutError((HttpServletResponse) servletResponse);
        } finally {
            pvgLog.setResponseTime(new Date());
            if (pvgLogService != null
                    && !"/".equals(pvgLog.getModule())
                    && !"monitor".equals(pvgLog.getModule())) {
                pvgLogService.addLogAction(pvgLog);
            }
        }
    }

    /**
     * 向浏览器写出错误
     *
     * @param servletResponse response
     * @throws IOException
     */
    private void writeOutError(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("application/json; charset=utf-8");
        PrintWriter writer = servletResponse.getWriter();

        // 系统异常
        OpRst opRst = new OpRst();
        opRst.setCode(-1);
        opRst.setMsg("系统发生未处理异常，请稍后再试...");

        writer.print(JSON.toJSONString(opRst));
        writer.flush();
        writer.close();
    }

    public void destroy() {
        logger.debug(" ==> PvgLogFilter destroy ");
    }

    /**
     * 根据http请求对象初始化动作日志
     *
     * @param httpRequest http请求对象
     */
    private void initAction(HttpServletRequest httpRequest) {
        pvgLog = new LogAction();

        String virtualUser = httpRequest.getParameter("virtualUser");
        if (!StringUtils.isEmpty(virtualUser)) {
            pvgLog.setVirtualUser(virtualUser);
        }

        String currentAirport = httpRequest.getParameter("currentAirport");
        if (StringUtils.isEmpty(currentAirport)) currentAirport = "PVG";
        pvgLog.setCurrentAirport(currentAirport);

        pvgLog.setTouchId(httpRequest.getParameter("touchId"));

        String servletPath = httpRequest.getServletPath();// /api/bas/currentDateTime
        if (!StringUtils.isEmpty(servletPath)) {
            String[] array = servletPath.split("/");
            String module;
            if (array.length >= 2) {
                module = array[1];
            } else if (array.length == 0) {
                module = "/";
            } else {
                module = array[1];
            }
            pvgLog.setModule(module);
        }

        pvgLog.setAction(servletPath);

        String requestTime = httpRequest.getParameter("requestTime");
        if (!StringUtils.isEmpty(requestTime)) {
            pvgLog.setRequestTime(DateUtil.parseDate(Long.valueOf(requestTime)));
        }

        pvgLog.setReceivedTime(new Date());

        String requestParams = JSON.toJSONString(httpRequest.getParameterMap());
        pvgLog.setRequestParams(requestParams);

        String debug = httpRequest.getParameter("debug");
        if (!StringUtils.isEmpty(debug) && !debug.trim().equals("0")) {
            pvgLog.setRmk("test");
        }
    }

}
