package com.rtmap.traffic.touch.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rtmap.traffic.touch.dao.BaseMapper;
import com.rtmap.traffic.touch.model.entity.AirTrafDetail;
@Mapper
public interface AirTrafDetailMapper extends BaseMapper<AirTrafDetail>{

	/**
	 * 根据机场交通ID获取交通详情
	 * @param airTrafId 机场交通ID
	 * @return 交通详情集合
	 */
	List<AirTrafDetail> selectByAirTrafId(Long airTrafId);

}