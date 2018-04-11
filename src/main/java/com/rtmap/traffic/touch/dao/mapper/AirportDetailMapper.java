package com.rtmap.traffic.touch.dao.mapper;

import com.rtmap.traffic.touch.dao.BaseMapper;
import com.rtmap.traffic.touch.model.entity.AirportDetail;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AirportDetailMapper extends BaseMapper<AirportDetail> {

    /**查询国内机场列表*/
    List<AirportDetail> selectByDM();

    /**查询国际机场列表*/
    List<AirportDetail> selectByIR();

}