package com.rtmap.traffic.touch.dao.mapper;


import com.rtmap.traffic.touch.dao.BaseMapper;
import com.rtmap.traffic.touch.model.entity.FlightDynInfoTemp;
import com.rtmap.traffic.touch.model.vo.FlightQueryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FlightDynInfoTempMapper extends BaseMapper<FlightDynInfoTemp> {

    //查询航班
    List<FlightQueryVo> selectByParamMap(Map<String, Object> param);

}