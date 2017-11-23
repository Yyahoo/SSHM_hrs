package com.yahoo.house.persistence.impl;

import org.springframework.stereotype.Repository;

import com.yahoo.house.domain.HouseType;
import com.yahoo.house.persistence.HouseTyepDao;


@Repository
public class HouseTypeDaoImpl extends BaseDaoAdapter<HouseType, Integer>
implements HouseTyepDao{

}
