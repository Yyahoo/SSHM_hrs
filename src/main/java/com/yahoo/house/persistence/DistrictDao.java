package com.yahoo.house.persistence;

import java.util.List;

import com.yahoo.house.domain.City;
import com.yahoo.house.domain.District;

public interface DistrictDao extends BaseDao<District, Integer>{

	
	List<District> findAllByCity(City city);
}
