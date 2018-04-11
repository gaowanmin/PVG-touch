package com.rtmap.traffic.touch.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.rtmap.traffic.touch.dao.BaseMapper;
import com.rtmap.traffic.touch.model.entity.ResearchResult;
@Mapper
public interface ResearchResultMapper extends BaseMapper<ResearchResult>{

	void batchInsert(@Param("list") List<ResearchResult> list);
}