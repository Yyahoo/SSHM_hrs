package com.yahoo.house.persistence;

import com.yahoo.house.domain.User;

public interface UserDao extends BaseDao<User, Integer>{
	
	User findByUsername(String username);

}
