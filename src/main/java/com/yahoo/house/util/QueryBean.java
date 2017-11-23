package com.yahoo.house.util;

import java.util.List;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;


/**
 * 查询对象接口（把查询条件排序条件封装到一个对象中）
 * @author 义亚宏
 * 创建时间:2017年10月25日上午10:55:29
 */
public interface QueryBean {
	
	
	
	QueryBean addOrderBy(boolean flag,String keyword,boolean asc);
	
	/**
	 * java8之后就能实现默认实现
	 * @param keyword
	 * @param asc
	 * @return
	 */
	default QueryBean addOrderBy(String keyword,boolean asc) {
		return addOrderBy(true, keyword, asc);
	}
	
	default QueryBean addOrderBy(String keyword) {
		return addOrderBy(true, keyword, true);
	}
	
	/**
	 * 添加查询条件
	 * @param flag
	 * @param condition
	 * @param value
	 * @return
	 */
	QueryBean addCondition(boolean flag,String condition,Object value);
	
	default QueryBean addCondition(String condition,Object value) {
		return addCondition(true, condition, value);
	}
	/**
	 * 获得查询语句
	 * @return
	 */
	String getQueryString();
	/**
	 * 获得查询记录数的语句
	 * @return
	 */
	String getCountString();
	
	/**
	 * 查询条件所对应的参数
	 * @return
	 */
	List<Object> getParameters();

}
