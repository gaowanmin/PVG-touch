package com.rtmap.traffic.touch.service.impl.log;

import com.rtmap.traffic.touch.dao.mapper.ErrorLogMapper;
import com.rtmap.traffic.touch.dao.mapper.LogActionMapper;
import com.rtmap.traffic.touch.model.entity.log.ErrorLog;
import com.rtmap.traffic.touch.model.entity.log.LogAction;
import com.rtmap.traffic.touch.service.IPvgLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 日志接口实现类
 *
 * @author xuhailong
 * @Date 2017/3/13
 */
@Service
public class PvgLogServiceImpl implements IPvgLogService {

    @Resource
    private LogActionMapper logActionMapper;

    @Resource
    private ErrorLogMapper errorLogMapper;

    /**
     * 添加服务调用日志
     */
    public void addLogAction(LogAction entity) {
        entity.setCreateTime(new Date());
        logActionMapper.insertSelective(entity);
    }

    /**
     * 记录错误日志
     *
     * @param reason 原因
     * @param rmk    备注
     */
    public void addErrorLog(String reason, String rmk) {
        reason = reason.length() <= 100 ? reason : reason.substring(0,99);
        rmk = rmk.length() <= 200 ? rmk : rmk.substring(0,200);
        ErrorLog errorLog = new ErrorLog();
        errorLog.setHappenedTime(new Date());
        errorLog.setReason(reason);
        errorLog.setRemark(rmk);
        errorLogMapper.insertSelective(errorLog);
    }
}
