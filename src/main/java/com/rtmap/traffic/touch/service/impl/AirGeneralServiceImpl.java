package com.rtmap.traffic.touch.service.impl;

import com.rtmap.traffic.touch.dao.mapper.AirGeneralServiceInfoDetailMapper;
import com.rtmap.traffic.touch.dao.mapper.AirGeneralServiceInfoMapper;
import com.rtmap.traffic.touch.dao.mapper.ServiceMenuMapper;
import com.rtmap.traffic.touch.model.dto.ServiceInfoDTO;
import com.rtmap.traffic.touch.model.entity.AirGeneralServiceInfo;
import com.rtmap.traffic.touch.model.entity.AirGeneralServiceInfoDetail;
import com.rtmap.traffic.touch.model.vo.OpRst;
import com.rtmap.traffic.touch.service.IAirGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AirGeneralServiceImpl implements IAirGeneralService {

	@Autowired
	private AirGeneralServiceInfoMapper airGeneralServiceInfoMapper;
	@Autowired
	private AirGeneralServiceInfoDetailMapper airGeneralServiceInfoDetailMapper;

    @Autowired
    private ServiceMenuMapper serviceMenuMapper;

    public OpRst<Object> getAirGeneralServiceInfo() {
        List<ServiceInfoDTO> serviceInfoList = airGeneralServiceInfoMapper.selectAllGeneralServiceInfo();
        if (serviceInfoList != null && serviceInfoList.size() > 0) {
            Map<Integer, List<ServiceInfoDTO>> listMap = serviceInfoList.stream()
                    .filter(serviceInfoDTO -> serviceInfoDTO.getServiceMenuId() > 0)
                    .collect(Collectors.groupingBy(ServiceInfoDTO::getServiceMenuId));
            Map<Integer, Object> result = new HashMap<>(listMap.size());
            for (Map.Entry<Integer, List<ServiceInfoDTO>> serviceMenuInfo : listMap.entrySet()) {
                List<ServiceInfoDTO> list = serviceMenuInfo.getValue();
                Map<String,Object> serviceListMap = new HashMap<>();
                for (AirGeneralServiceInfo airGeneralServiceInfo : list) {
                    Map<String, Object> detailMap = new HashMap<>();
                    detailMap.put("title", airGeneralServiceInfo.getTitle());
                    List<AirGeneralServiceInfoDetail> detailList = airGeneralServiceInfoDetailMapper.getDetailInfoByAirServiceId(airGeneralServiceInfo.getAirServiceId());
                    detailMap.put("detailList", detailList);
                    serviceListMap.put(airGeneralServiceInfo.getServiceCode(), detailMap);
                }
                result.put(serviceMenuInfo.getKey(), serviceListMap);
            }
            return new OpRst<Object>(0, result);
        } else {
            return new OpRst<Object>(-1, "当前服务不可用，请稍后再试！");
        }
    }

    /**
     * 获取服务页面下的菜单列表
     * @return
     */
    @Override
    public OpRst<Object> getServiceMenu() {
        return new OpRst<>(0,"success",serviceMenuMapper.selectMenuList());
    }

}
