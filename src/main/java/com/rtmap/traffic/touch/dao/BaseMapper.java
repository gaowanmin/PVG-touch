package com.rtmap.traffic.touch.dao;

/**
 * @author xuhailong
 * @Date 2017/3/10
 */
public interface BaseMapper<T> {

    int insertSelective(T record);

    T selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(T record);


}
