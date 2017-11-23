package com.yahoo.house.service;

import java.util.List;

import com.yahoo.house.domain.City;
import com.yahoo.house.domain.District;
import com.yahoo.house.domain.Province;

public interface LocationService {
	
	List<Province> listAllProvinces();
	List<City> listAllCitiesByProvince(Province province);
	
	List<District> listAllDisTrictsByCity(City city);

}
