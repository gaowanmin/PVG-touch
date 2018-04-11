package com.rtmap.traffic.touch.dao.mapper;

import com.rtmap.traffic.touch.dao.BaseMapper;
import com.rtmap.traffic.touch.model.entity.ServiceMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ServiceMenuMapper extends BaseMapper<ServiceMenu> {


    List<ServiceMenu> selectMenuList();

}