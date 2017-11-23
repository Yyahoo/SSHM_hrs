package com.yahoo.house.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yahoo.house.domain.City;
import com.yahoo.house.domain.Province;
import com.yahoo.house.persistence.CityDao;


@Repository
public class CityDaoImpl extends BaseDaoAdapter<City , Integer>
implements CityDao
{   
	@Override
	public List<City> findAllByProvince(Province province) {
		return sessionFactory.getCurrentSession()
				.createQuery("from City as c where c.province=:province",City.class)
				.setParameter("province", province)
				.getResultList();
	}

}
