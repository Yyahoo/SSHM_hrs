package com.yahoo.house.persistence.impl;

import java.util.List;

import javax.persistence.Query;

import org.dom4j.swing.LeafTreeNode;
import org.springframework.stereotype.Repository;

import com.yahoo.house.domain.House;
import com.yahoo.house.domain.HouseType;
import com.yahoo.house.dto.PageBean;
import com.yahoo.house.persistence.HouseDao;
import com.yahoo.house.persistence.HouseTyepDao;
import com.yahoo.house.util.QueryBean;


@Repository
public class HouseDaoImpl extends BaseDaoAdapter<House, Integer>
implements HouseDao{


	@Override
	public PageBean<House> findByPage(int page, int size) {
		List<House> dataModel=sessionFactory.getCurrentSession()
				.createQuery("from House as h left join fetch h.houseType "
						+" left join fetch h.district "
						+ " order by h.pubDate desc " ,House.class)
				.setFirstResult((page-1)*size)
				.setMaxResults(size)
				.getResultList();
		
		int count=sessionFactory.getCurrentSession()
				.createQuery("select count(h) from House as h",Long.class)
				.getSingleResult().intValue();
		int totalPage=(count-1)/size+1;
		return new PageBean<>(dataModel, totalPage, page, size);
		
	}


//	@Override
//	public PageBean<House> findByQueryAndPage(QueryBean queryBean, int page, int size) {
//		String hql=queryBean.getQueryString();
//		Query query=sessionFactory.getCurrentSession().createQuery(hql,House.class);
//		for(int i=0;i<queryBean.getParameters().size();++i) {
//			query.setParameter(i, queryBean.getParameters().get(i));
//		}
//		
//		return null;
//	}
//	@Override
//	public PageBean<House> findByQueryAndPage(QueryBean queryBean, int page, int size) {
//		Query query = sessionFactory.getCurrentSession().createQuery(queryBean.getQueryString());
//		List<Object> paramValues = queryBean.getParameters();
//		for (int i = 0; i < paramValues.size(); ++i) {
//			query.setParameter(i, paramValues.get(i));
//		}
//		List<House> dataModel = query.setFirstResult((page - 1) * size).setMaxResults(size).getResultList();
//		query = sessionFactory.getCurrentSession().createQuery(queryBean.getCountString());
//		for (int i = 0; i < paramValues.size(); ++i) {
//			query.setParameter(i, paramValues.get(i));
//		}
//		int total = ((Long) (query.getSingleResult())).intValue();
//		int totalPage = (total - 1) / size + 1;
//		return new PageBean<>(dataModel, totalPage, page, size);
//	}

}
