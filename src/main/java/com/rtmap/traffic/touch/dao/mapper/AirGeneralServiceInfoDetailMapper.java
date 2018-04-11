package com.rtmap.traffic.touch.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.rtmap.traffic.touch.dao.BaseMapper;
import com.rtmap.traffic.touch.model.entity.AirGeneralServiceInfoDetail;
@Mapper
public interface AirGeneralServiceInfoDetailMapper extends BaseMapper<AirGeneralServiceInfoDetail>{
	
	/**
	 * 根据服务类型id查询详情信息
	 * @param airServiceId 服务类型id
	 * @return 详情列表
	 */
	List<AirGeneralServiceInfoDetail> getDetailInfoByAirServiceId(Long airServiceId);
}