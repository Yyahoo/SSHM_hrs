package com.yahoo.house.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yahoo.house.domain.City;
import com.yahoo.house.domain.District;
import com.yahoo.house.domain.Province;
import com.yahoo.house.persistence.CityDao;
import com.yahoo.house.persistence.DistrictDao;
import com.yahoo.house.persistence.ProvinceDao;
import com.yahoo.house.service.LocationService;


@Service
@Transactional(readOnly=true)
public class LocationServiceImpl implements LocationService {
    
	@Autowired
	private ProvinceDao provinceDao;
	@Autowired
	private CityDao cityDao;
	@Autowired
	private DistrictDao districtDao;
	
	
	@Override
	public List<Province> listAllProvinces() {
		// TODO Auto-generated method stub
		return provinceDao.findAll();
	}

	@Override
	public List<City> listAllCitiesByProvince(Province province) {
		// TODO Auto-generated method stub
		return cityDao.findAllByProvince(province);
	}

	@Override
	public List<District> listAllDisTrictsByCity(City city) {
		// TODO Auto-generated method stub
		return districtDao.findAllByCity(city);
	}

}
