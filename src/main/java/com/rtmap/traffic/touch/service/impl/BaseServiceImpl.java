package com.rtmap.traffic.touch.service.impl;

import com.rtmap.traffic.touch.dao.mapper.ErrorLogMapper;
import com.rtmap.traffic.touch.dao.mapper.ModuleUpdateTimeMapper;
import com.rtmap.traffic.touch.model.entity.ModuleUpdateTime;
import com.rtmap.traffic.touch.model.entity.log.ErrorLog;
import com.rtmap.traffic.touch.service.IBaseService;
import com.rtmap.traffic.touch.util.DateUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 检查数据同步状态接口实现类
 *
 * @author xuhailong
 * @Date 2017/3/14
 */
@Service
public class BaseServiceImpl implements IBaseService {

    private static final String MODULE_KEY_FLT = "PVG_FLIGHT_DYN_MODULE";
    private static final String MODULE_KEY_HOT_CITY = "HOT_CITY";
    private static final String MODULE_KEY_TRAFFIC = "TRAFFIC";
    private static final String MODULE_KEY_RESEARCH_CONTENT = "RESEARCH_CONTENT";
    private static final String MODULE_KEY_SERVICE = "SERVICE";

    @Value("${module.updateTime.flt}")
    private String fltUpdateTime;

    @Value("${module.updateTime.hotCity}")
    private String hotCityUpdateTime;

    @Value("${module.updateTime.traffic}")
    private String trafficUpdateTime;

    @Value("${module.updateTime.research}")
    private String researchUpdateTime;

    @Value("${module.updateTime.service}")
    private String serviceUpdateTime;

    @Resource
    private ModuleUpdateTimeMapper moduleUpdateTimeMapper;

    @Resource
    private ErrorLogMapper errorLogMapper;
    /**
     * 查询 航班 最后同步时间 是否在规定范围内
     *
     * @return boolean
     */
    public boolean checkFltUpdateTime() {
        boolean result = false;
        ModuleUpdateTime module = moduleUpdateTimeMapper.selectByModuleName(MODULE_KEY_FLT);
        if (module != null) {
            //最后更新间是否在20分钟的有效时间内
            if (DateUtil.betweenDateForCurrent(module.getUpdateTime(), DateUtil.addSecond(module.getUpdateTime(), Integer.parseInt(fltUpdateTime) * 60))) {
                result = true;
            }
        }

        if (!result) {
            //记录错误日志
            insertErrorLog(String.format("最后更新间未在%s分钟的有效时间内",fltUpdateTime),module == null ? "没有最同步状态记录" : "");
        }

        return result;
    }

    /**
     * 查询 热门城市 最后同步时间 是否在规定范围内
     *
     * @return boolean
     */
    public boolean checkHotCityUpdateTime() {
        return false;
    }

    /**
     * 查询 交通 最后同步时间 是否在规定范围内
     *
     * @return boolean
     */
    public boolean checkTrafficUpdateTime() {
        return false;
    }

    /**
     * 查询 问卷 最后同步时间 是否在规定范围内
     *
     * @return boolean
     */
    public boolean checkResearchUpdateTime() {
        return false;
    }


    /**
     * 记录错误日志
     *
     * @param reason 原因
     * @param rmk    备注
     */
    private void insertErrorLog(String reason, String rmk) {
        ErrorLog errorLog = new ErrorLog();
        errorLog.setHappenedTime(new Date());
        errorLog.setReason(reason);
        errorLog.setRemark(rmk);
        errorLogMapper.insertSelective(errorLog);
    }
}
