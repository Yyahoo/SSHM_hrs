package com.yahoo.house.persistence;

import com.yahoo.house.domain.House;
import com.yahoo.house.dto.PageBean;
import com.yahoo.house.util.QueryBean;

public interface HouseDao extends BaseDao<House, Integer>{
	
	
	PageBean<House> findByPage(int page,int size);
	
	//PageBean<House> findByQueryAndPage(QueryBean queryBean,int page,int size);

}
