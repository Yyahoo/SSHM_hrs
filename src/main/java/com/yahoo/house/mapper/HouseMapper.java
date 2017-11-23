package com.yahoo.house.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yahoo.house.domain.House;
import com.yahoo.house.dto.SearchHousePargram;

public interface HouseMapper {
	
	List<House> findBySearchParam(@Param("houseInfo") SearchHousePargram param,@Param("offset") int offset,@Param("size") int size);
	
	int countBySearchParam(@Param("houseInfo") SearchHousePargram param);

}
