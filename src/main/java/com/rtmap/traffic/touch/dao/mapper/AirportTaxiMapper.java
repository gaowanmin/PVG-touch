package com.rtmap.traffic.touch.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rtmap.traffic.touch.dao.BaseMapper;
import com.rtmap.traffic.touch.model.entity.AirportTaxi;
@Mapper
public interface AirportTaxiMapper extends BaseMapper<AirportTaxi> {

	/**
	 * 获取出租车地址
	 * @return 地址集合
	 */
	List<AirportTaxi> selectByTaxiAddress();

}