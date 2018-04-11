package com.rtmap.traffic.touch.service.impl;

import com.rtmap.traffic.touch.dao.mapper.AirportDetailMapper;
import com.rtmap.traffic.touch.dao.mapper.FlightDynInfoTempMapper;
import com.rtmap.traffic.touch.model.entity.AirportDetail;
import com.rtmap.traffic.touch.model.entity.FlightDynInfoTemp;
import com.rtmap.traffic.touch.model.vo.AirportDetailVo;
import com.rtmap.traffic.touch.model.vo.FlightQueryVo;
import com.rtmap.traffic.touch.model.vo.OpRst;
import com.rtmap.traffic.touch.service.IFlightService;
import com.rtmap.traffic.touch.util.FlightStatusEnum;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 航班查询接口实现类 测试
 *
 * @author xuhailong
 * @Date 2017/3/14
 */
@Service
public class FlightServiceImpl extends BaseServiceImpl implements IFlightService  {

    @Resource
    private FlightDynInfoTempMapper flightDynInfoTempMapper;

    @Resource
    private AirportDetailMapper airportDetailMapper;
    /**
     * 按航班号查询
     *
     * @param request 请求入参
     * @return 返回结果实体
     */
    public OpRst queryByFltNo(HttpServletRequest request) {
        //查询时间
        String queryTime = request.getParameter("queryTime");
        if (StringUtils.isEmpty(queryTime)) {
            return new OpRst(-1,"请输入查询时间");
        }
        //航班号
        String fltNo = request.getParameter("fltNo");
        if (StringUtils.isEmpty(fltNo)) {
            return new OpRst(-1,"请输入航班号");
        }

        //检证航班数据是否最新 不是则记录
        checkFltUpdateTime();

        Map<String,Object> param = new HashMap<String, Object>();
        param.put("queryTime", queryTime);
        param.put("fltNo",fltNo);

        //查询
        List<FlightQueryVo> list = flightDynInfoTempMapper.selectByParamMap(param);

        return new OpRst<>(0,"success",list);
    }

    /**
     * 按起降地查询
     *
     * @param request 请求入参
     * @return 返回结果实体
     */
    @Override
    public OpRst queryByAirport(HttpServletRequest request) {
        //查询时间
        String queryTime = request.getParameter("queryTime");
        if (StringUtils.isEmpty(queryTime)) {
            return new OpRst(-1,"请输入查询时间");
        }
        //出发机场
        String oriAirport = request.getParameter("oriAirport");
        if (StringUtils.isEmpty(oriAirport) || oriAirport.length() > 3) {
            return new OpRst(-1,"请选择出发机场");
        }
        //到达机场
        String desAirport = request.getParameter("desAirport");
        if (StringUtils.isEmpty(desAirport) || desAirport.length() > 3) {
            return new OpRst(-1,"请选择到达机场");
        }

        //检证航班数据是否最新 不是则记录
        checkFltUpdateTime();

        Map<String,Object> param = new HashMap<String, Object>();
        param.put("queryTime", queryTime);
        param.put("oriAirport",oriAirport);
        param.put("desAirport",desAirport);

        //查询
        List<FlightQueryVo> list = flightDynInfoTempMapper.selectByParamMap(param);
        return new OpRst<>(0,"success",list);

    }

    /**
     * 通过Id 获取详情
     *
     * @param request 请求入参
     * @return 返回结果实体
     */
    @Override
    public OpRst queryDetailById(HttpServletRequest request) {
        String flightId = request.getParameter("flightId");
        if (StringUtils.isEmpty(flightId)) {
            return new OpRst(-1,"请指定航班ID");
        }

        //查询
        FlightDynInfoTemp flight = flightDynInfoTempMapper.selectByPrimaryKey(Long.parseLong(flightId));
        if (!StringUtils.isEmpty(flight.getFlightStatus())) {
            flight.setFlightStatus(FlightStatusEnum.valueOf(flight.getFlightStatus()).value);
        }
        return new OpRst<>(0,"success",flight);
    }

    /**
     * 获取国内航班基础数据列表
     *
     * @return 返回结果实体
     */
    @Override
    public OpRst queryAirportD() {
        //获取国内机场列表
        List<AirportDetail> dm_list = airportDetailMapper.selectByDM();
        //处理列表 分成热门列表 和 按普通列表 并按字母编排
        Map<String, Object> airportMap = splitAirportList(dm_list);

        return new OpRst<>(0,"success",airportMap);
    }

    /**
     * 获取国际航班基础数据列表
     *
     * @return 返回结果实体
     */
    @Override
    public OpRst queryAirportI() {
        List<AirportDetail> ir_list = airportDetailMapper.selectByIR();
        //处理列表 分成热门列表 和 按普通列表 并按字母编排
        Map<String, Object> airportMap = splitAirportList(ir_list);

        return new OpRst<>(0,"success",airportMap);
    }

    /**
     * 分成热门列表 和 按普通列表 并按字母编排
     *
     * @param airportList 数据列表
     * @return map
     */
    private Map<String, Object> splitAirportList(List<AirportDetail> airportList) {
        if (airportList == null) return null;

        List<String> firstLetter = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"
                , "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");

        Map<String,Object> map = new HashMap<>();
        List<AirportDetailVo> hotList = new ArrayList<>();

        Map<String, List<AirportDetailVo>> defaultAirport = airportList.stream()
                .map(detail -> {
                    AirportDetailVo vo = new AirportDetailVo();
                    vo.setAirportCode(detail.getAirportCode());
                    vo.setAirportName(detail.getAirportName());

                    if (detail.getIshot() && !"SHA".equals(detail.getAirportCode())) {
                        hotList.add(vo);
                    }

                    String namePy = StringUtils.isEmpty(detail.getNamePy()) ? "#" : detail.getNamePy().substring(0, 1).toUpperCase();
                    if (firstLetter.contains(namePy)) {
                        vo.setNamePy(namePy);
                    } else {
                        vo.setNamePy("#");
                    }
                    return vo;
                }).collect(Collectors.groupingBy(AirportDetailVo::getNamePy));

        if (hotList.size() > 0) {
            map.put("hotAirport",hotList);
        }

        map.put("defaultAirport",defaultAirport);

        return map;
    }
}
