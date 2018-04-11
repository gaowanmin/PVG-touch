package com.rtmap.traffic.touch.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.rtmap.traffic.touch.dao.mapper.AirTrafDetailMapper;
import com.rtmap.traffic.touch.dao.mapper.AirportTaxiMapper;
import com.rtmap.traffic.touch.dao.mapper.BairTrafInfoMapper;
import com.rtmap.traffic.touch.dao.mapper.TaxiCostsMapper;
import com.rtmap.traffic.touch.dao.mapper.TaxiFeescaleMapper;
import com.rtmap.traffic.touch.model.entity.AirTrafDetail;
import com.rtmap.traffic.touch.model.entity.AirportTaxi;
import com.rtmap.traffic.touch.model.entity.BairTrafInfo;
import com.rtmap.traffic.touch.model.entity.TaxiCosts;
import com.rtmap.traffic.touch.model.entity.TaxiFeescale;
import com.rtmap.traffic.touch.model.vo.OpRst;
import com.rtmap.traffic.touch.service.IBairTrafInfoService;
@Service
public class BairTrafInfoServiceImpl implements IBairTrafInfoService {

	@Autowired
	private BairTrafInfoMapper bairTrafInfoMapper;
	@Autowired
	private AirTrafDetailMapper airTrafDetailMapper;
	@Autowired
	private AirportTaxiMapper airportTaxiMapper;
	@Autowired
	private TaxiCostsMapper taxiCostsMapper;
	@Autowired
	private TaxiFeescaleMapper taxiFeescaleMapper;
	
	public OpRst<Object> getTrafficInfo() {
		//首先查询监控表，判断当前是否有最新数据更新，如果不是最新数据，记录warnning日志，返回旧数据
		
		//获取基础交通出行方法(排除出租车)
		List<BairTrafInfo> btrafInfoList= bairTrafInfoMapper.selectTrafInfoByAirport();
		Map<String,Object> result = new LinkedHashMap<String,Object>();
		if(btrafInfoList != null && btrafInfoList.size() >0){
			for (BairTrafInfo bairTrafInfo : btrafInfoList) {
				Map<String,Object> map = new LinkedHashMap<String, Object>();
				List<AirTrafDetail>  detailList = airTrafDetailMapper.selectByAirTrafId(bairTrafInfo.getAirTrafId());
				map.put("title",bairTrafInfo.getTitle());
				map.put("detailList", detailList);
				result.put(bairTrafInfo.getServiceCode(), map);
			}
			System.out.println(JSONObject.toJSONString(result));
			return new OpRst<Object>(0,result);
		}else{
			return new OpRst<Object>(-1,"当前服务器异常，无法获取到该服务！");
		}
	}

	public OpRst<Object> getTaxi() {
		Map<String,Object> map = new HashMap<String,Object>();
		//查询坐出租车地点
		List<AirportTaxi> addressList = airportTaxiMapper.selectByTaxiAddress();
		//上海机场到核心地段打车费用
		List<TaxiCosts> coreList = taxiCostsMapper.selectToCoreLot();
		//上海市出租车收费标准查询
		List<TaxiFeescale> chargeList = taxiFeescaleMapper.selectChargeStandard();
		map.put("addressList",addressList);
		map.put("chargeList",chargeList);
		map.put("coreList",coreList);
		return new OpRst<Object>(0,map);
	}

}
