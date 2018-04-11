package com.rtmap.traffic.touch.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rtmap.traffic.touch.dao.BaseMapper;
import com.rtmap.traffic.touch.model.entity.BairTrafInfo;
@Mapper
public interface BairTrafInfoMapper extends BaseMapper<BairTrafInfo>{

	/**
	 * 获取机场交通方式
	 * @return 交通方式集合
	 */
	List<BairTrafInfo> selectTrafInfoByAirport();
    
}