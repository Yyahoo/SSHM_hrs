package com.yahoo.house.persistence.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yahoo.house.persistence.BaseDao;

public abstract class BaseDaoAdapter<E,K extends Serializable>
   implements  BaseDao<E,K>
   {
	@Autowired
	protected SessionFactory sessionFactory; //自动注入sessionFactory
    private Class<E> entityType;
    private String   entityname;
    
    
    protected  BaseDaoAdapter() {
    	ParameterizedType pType=(ParameterizedType) this.getClass().getGenericSuperclass();
	    entityType=(Class<E>) pType.getActualTypeArguments()[0];
	    entityname=entityType.getSimpleName();	
	}
	@Override
	public K save(E entity) {
		return (K) sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public boolean deleteById(Serializable id) {
		return sessionFactory.getCurrentSession()
				.createQuery("delete from "+entityname+" as e where e.id=:id")
				.setParameter("id", id)
				.executeUpdate()==1;
	}

	@Override
	public void update(E entity) {
		sessionFactory.getCurrentSession().merge(entity);
	}

	@Override
	public E findById(Serializable id) {
		return sessionFactory.getCurrentSession().get(entityType, id);
	}

	@Override
	public List<E> findAll() {
		return sessionFactory.getCurrentSession()
				.createQuery("from " +entityname,entityType)
				.getResultList();
		
	}

	
}
