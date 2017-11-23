package com.yahoo.house.persistence.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.yahoo.house.domain.User;
import com.yahoo.house.persistence.UserDao;

@Repository
public class UserDaoImpl extends BaseDaoAdapter<User, Integer> implements UserDao

{
	@Override
	public User findByUsername(String username) {
		List<User> userList = sessionFactory.getCurrentSession()
				.createQuery("from User as u where u.username=:username",User.class)
				.setParameter("username", username)
				.getResultList();
		return userList.size() == 1 ? userList.get(0) : null;
	}
}
