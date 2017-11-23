package com.yahoo.house.service;

import java.util.List;

import com.yahoo.house.domain.House;
import com.yahoo.house.domain.HouseType;
import com.yahoo.house.dto.PageBean;
import com.yahoo.house.dto.SearchHousePargram;

/**
 * 房子类型的接口
 * @author 义亚宏
 * 创建时间:2017年10月23日上午10:08:26
 */
public interface HouseService {
	
	List<HouseType> listAllHouseTypes();
	
	PageBean<House> listHousesByPage(int page,int size);
   
	PageBean<House> searchHouseswithParamByPage(SearchHousePargram pargram,int page,int size);

	boolean publishNewHouse(House house);
}
