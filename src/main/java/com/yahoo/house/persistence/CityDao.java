package com.yahoo.house.persistence;

import java.util.List;

import com.yahoo.house.domain.City;
import com.yahoo.house.domain.Province;

public interface CityDao extends BaseDao<City, Integer>{
	
	List<City> findAllByProvince(Province province);
}
