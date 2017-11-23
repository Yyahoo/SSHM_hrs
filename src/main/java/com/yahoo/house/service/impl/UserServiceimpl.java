package com.yahoo.house.service.impl;

import java.util.Date;

import javax.jws.soap.SOAPBinding.Use;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yahoo.house.domain.LoginLog;
import com.yahoo.house.domain.User;
import com.yahoo.house.dto.UserLoginDto;
import com.yahoo.house.persistence.LoginLogDao;
import com.yahoo.house.persistence.UserDao;
import com.yahoo.house.service.UserService;



@Service
@Transactional
public class UserServiceimpl implements UserService {
	
    @Autowired
	private UserDao userDao;
    @Autowired
    private LoginLogDao loginLogdao; 
    
	@Override
	public boolean login(UserLoginDto user){
		User temp = userDao.findByUsername(user.getUsername());
		if (temp != null){
			if (temp.getPassword().equals(DigestUtils.md5Hex(user.getPassword()))) {
				user.setRealname(temp.getRealname());
				user.setId(temp.getId());
				LoginLog loginLog=new LoginLog();
				loginLog.setUser(temp);
				loginLog.setIpAddress("10.7.189.145");
				loginLog.setLogdate(new Date());
				loginLogdao.save(loginLog);
				return true;	
			}
		}
		return false;
	}
	
	@Override
	public boolean register(User user) {
		if( !(userDao.findByUsername(user.getUsername())!=null)) {
			user.setPassword(DigestUtils.md5Hex(user.getPassword()));
			user.setAdmin(false);
			userDao.save(user); 
			LoginLog loginLog=new LoginLog();
			loginLog.setUser(user);
			loginLog.setIpAddress("10.7.189.145");
			loginLog.setLogdate(new Date());
			return true;
		}
		return false;
	}
	@Override
	public boolean checkUnique(String username) {
		return userDao.findByUsername(username)==null;
	}

}
