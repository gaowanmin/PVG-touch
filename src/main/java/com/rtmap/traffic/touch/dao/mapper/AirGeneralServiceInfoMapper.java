package com.rtmap.traffic.touch.dao.mapper;

import java.util.List;

import com.rtmap.traffic.touch.model.dto.ServiceInfoDTO;
import org.apache.ibatis.annotations.Mapper;
import com.rtmap.traffic.touch.dao.BaseMapper;
import com.rtmap.traffic.touch.model.entity.AirGeneralServiceInfo;
@Mapper
public interface AirGeneralServiceInfoMapper extends BaseMapper<AirGeneralServiceInfo> {

	/**
	 * 获取机场所有基础服务列表
	 * @return 基础服务列表集合
	 */
	List<ServiceInfoDTO> selectAllGeneralServiceInfo();
}