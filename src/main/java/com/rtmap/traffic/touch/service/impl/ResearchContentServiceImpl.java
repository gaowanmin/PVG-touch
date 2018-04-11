package com.rtmap.traffic.touch.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rtmap.traffic.touch.dao.mapper.ResearchContentMapper;
import com.rtmap.traffic.touch.dao.mapper.ResearchResultMapper;
import com.rtmap.traffic.touch.model.entity.ResearchContent;
import com.rtmap.traffic.touch.model.entity.ResearchResult;
import com.rtmap.traffic.touch.model.vo.OpRst;
import com.rtmap.traffic.touch.service.IResearchContentService;
@Service
public class ResearchContentServiceImpl implements IResearchContentService {

	@Autowired
	private ResearchContentMapper researchContentMapper;
	@Autowired
	private ResearchResultMapper researchResultMapper;
	
	public OpRst<Object> getResearchQuestion() {
		Map<String,Object> result = new HashMap<String,Object>();

		//获取所有题目 modify 2017-10-11
        List<ResearchContent> list = researchContentMapper.selectAllChildContent();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","all");
        map.put("question", list);
        result.put("0", map);
		return new OpRst<>(0, result);
	}

	public OpRst<Object> addSearchResult(ResearchResult researchResult) {
		researchResult.setCreateTime(new Date());
		researchResult.setUpdateTime(new Date());
		int row = researchResultMapper.insertSelective(researchResult);
		if(row > 0){
			return new OpRst<Object>(0,"success");
		}else{
			return new OpRst<Object>(-1,"提交失败，请稍后再试！");
		}
	}

    public OpRst<Object> batchSaveSearchResult(List<ResearchResult> list, String touchId, String virtualUser) {
        if (list != null && list.size() > 0) {
            for (ResearchResult researchResult : list) {
                researchResult.setTouchId(touchId);
                researchResult.setVirtualUser(virtualUser);
                researchResult.setCreateTime(new Date());
                researchResult.setUpdateTime(new Date());
            }
            researchResultMapper.batchInsert(list);
            return new OpRst<Object>(0, "success");
        } else {
            return new OpRst<Object>(-1, "至少保存一条数据");
        }
    }

}
