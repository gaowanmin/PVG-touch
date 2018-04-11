package com.rtmap.traffic.touch.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rtmap.traffic.touch.dao.BaseMapper;
import com.rtmap.traffic.touch.model.entity.TaxiFeescale;
@Mapper
public interface TaxiFeescaleMapper extends BaseMapper<TaxiFeescale>{

	/**
	 * 上海市出租车收费标准查询 
	 * @return 核心地段打车费用列表
	 */
	List<TaxiFeescale> selectChargeStandard();
	
}