package com.rtmap.traffic.touch.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rtmap.traffic.touch.dao.BaseMapper;
import com.rtmap.traffic.touch.model.entity.TaxiCosts;
@Mapper
public interface TaxiCostsMapper extends BaseMapper<TaxiCosts>{

	/**
	 * 上海机场到核心地段打车费用
	 * @return 收费标准集合
	 */
	List<TaxiCosts> selectToCoreLot();
}