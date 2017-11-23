package com.yahoo.house.persistence.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yahoo.house.domain.City;
import com.yahoo.house.domain.District;
import com.yahoo.house.persistence.DistrictDao;


@Repository
public class DistrictDaoImpl extends BaseDaoAdapter<District, Integer>
implements DistrictDao{
	

	@Override
	public List<District> findAllByCity(City city) {
		return sessionFactory.getCurrentSession()
				.createQuery("from District as d where d.city=:city",District.class)
				.setParameter("city", city)
				.getResultList();
	}

}
