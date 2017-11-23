package com.yahoo.house.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yahoo.house.domain.House;
import com.yahoo.house.domain.HouseType;
import com.yahoo.house.dto.PageBean;
import com.yahoo.house.dto.SearchHousePargram;
import com.yahoo.house.mapper.HouseMapper;
import com.yahoo.house.persistence.HouseDao;
import com.yahoo.house.persistence.HouseTyepDao;
import com.yahoo.house.service.HouseService;
import com.yahoo.house.util.HqlQueryBean;
import com.yahoo.house.util.QueryBean;


@Service
public class HouseServiceImpl implements HouseService{
    @Autowired
    private HouseTyepDao houseTypeDao;
    
    @Autowired
    private HouseDao houseDao;
    
    @Autowired
    private HouseMapper HouseMapper;
    
    @Transactional(readOnly=true)
	@Override
	public List<HouseType> listAllHouseTypes() {
		// TODO Auto-generated method stub
		return houseTypeDao.findAll();
	}
    @Transactional
	@Override
	public boolean publishNewHouse(House house) {
		return houseDao.save(house)!=null;
	}
    @Transactional(readOnly=true)
	@Override
	public PageBean<House> listHousesByPage(int page, int size) {
		return houseDao.findByPage(page, size);
	}
//	@Override
//	public PageBean<House> searchHouseswithParamByPage(SearchHousePargram pargram, int page, int size) {
//		// TODO Auto-generated method stub
//		QueryBean queryBean=new HqlQueryBean(House.class);
//		queryBean.addCondition("title like ?","%"+pargram.getTitle()+"%")
//		.addCondition("houseType=?", pargram.getHouseType())
//		.addCondition("area>=?", pargram.getMinArea())
//		.addCondition("area<=", pargram.getMaxArea())
//		.addCondition("price>=", pargram.getMinPrice())
//		.addCondition("price<=",pargram.getMaxPrice())
//		.addOrderBy("pubDate", false);
//		return houseDao.findByQueryAndPage(queryBean, page, size);
//	}
//	
	@Override
	public PageBean<House> searchHouseswithParamByPage(SearchHousePargram pargram, int page, int size) {
		
		List<House> listhouse=HouseMapper.findBySearchParam(pargram, (page-1)*size, size);
		int total=HouseMapper.countBySearchParam(pargram);
		int totalPage=(total-1)/size+1;
		return new PageBean<>(listhouse, totalPage, page,size);
		
		
	}
	

}
