package com.yahoo.house.service;

import com.yahoo.house.domain.User;
import com.yahoo.house.dto.UserLoginDto;

public interface UserService {
	
	boolean login (UserLoginDto user);
	boolean register(User user);
	
	/**
	 * 检查用户的唯一性
	 * @param username
	 * @return
	 */
	boolean checkUnique(String username);

}
