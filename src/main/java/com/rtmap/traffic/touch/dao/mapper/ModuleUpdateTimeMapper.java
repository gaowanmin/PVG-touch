package com.rtmap.traffic.touch.dao.mapper;

import com.rtmap.traffic.touch.dao.BaseMapper;
import com.rtmap.traffic.touch.model.entity.ModuleUpdateTime;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ModuleUpdateTimeMapper extends BaseMapper<ModuleUpdateTime> {

    @Select({
         "select * from pvg_module_updatetime where module_name = #{moduleName, jdbcType=VARCHAR} limit 1"
    })
    ModuleUpdateTime selectByModuleName(@Param(value = "moduleName") String moduleName);
}