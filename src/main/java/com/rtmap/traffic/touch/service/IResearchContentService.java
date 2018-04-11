package com.rtmap.traffic.touch.service;

import java.util.List;

import com.rtmap.traffic.touch.model.entity.ResearchResult;
import com.rtmap.traffic.touch.model.vo.OpRst;

public interface IResearchContentService {
	/**
	 * 获取调查问卷的问题
	 * @return 返回操作对象
	 */
	OpRst<Object> getResearchQuestion();
	
	/**
	 * 添加调查结果
	 * @param researchResult 调查结果对象
	 * @return 返回操作对象
	 */
	OpRst<Object> addSearchResult(ResearchResult researchResult);

    /**
     * 批量添加调查结果
     *
     * @param list 调查结果集合
     * @return OpRst<Object>
     */
    OpRst<Object> batchSaveSearchResult(List<ResearchResult> list, String touchId, String virtualUser);

	
}
