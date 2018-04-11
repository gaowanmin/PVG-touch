package com.rtmap.traffic.touch.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rtmap.traffic.touch.dao.BaseMapper;
import com.rtmap.traffic.touch.model.entity.ResearchContent;
@Mapper
public interface ResearchContentMapper extends BaseMapper<ResearchContent> {

	/**
	 * 获取调查问卷的问题
	 * @return 问卷列表
	 */
	List<ResearchContent> selectResearchContent(Long parentContentId);
	/**
	 * 获取根目录下的标题
	 * @return 根目录标题列表
	 */
	List<ResearchContent> selectRootTiltle();

    List<ResearchContent> selectAllChildContent();

}