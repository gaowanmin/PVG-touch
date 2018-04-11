package com.rtmap.traffic.touch.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rtmap.traffic.touch.model.entity.ResearchResult;
import com.rtmap.traffic.touch.model.vo.OpRst;
import com.rtmap.traffic.touch.service.IResearchContentService;

@RestController
@RequestMapping("question")
public class QuestionController {

	@Resource
	private IResearchContentService researchContentService;
	
	/**
	 * 获取调查问卷的问题
	 * @return 操作对象
	 */
	@GetMapping(value = "getResearchQuestion")
	public OpRst<Object> getResearchQuestion(){
		
		return researchContentService.getResearchQuestion();
	}
	
	/**
	 * 添加调查问卷结果
	 * @return 操作对象
	 */
	@PostMapping(value = "saveSearchResult",produces = "application/json")
	public OpRst<Object> saveSearchResult(@RequestBody ResearchResult researchResult,HttpServletRequest request,HttpServletResponse response){
		
		return researchContentService.addSearchResult(researchResult);
	}
	
	/**
	 * 批量添加调查问卷结果
	 * @return 操作对象
	 */
	@PostMapping(value = "batchSaveSearchResult",produces = "application/json")
	public OpRst<Object> batchSaveSearchResult(HttpServletRequest request,HttpServletResponse response,@RequestBody JSONObject jsonObject){
		JSONArray result = jsonObject.getJSONArray("list");
        String touchId = request.getParameter("touchId");
        String virtualUser = request.getParameter("virtualUser");
        List<ResearchResult> list = JSONObject.parseArray(JSONObject.toJSONString(result), ResearchResult.class);
//		List<ResearchResult> list = CollectionUtils.arrayToList(result.toArray());
        return researchContentService.batchSaveSearchResult(list, touchId, virtualUser);
    }
}
