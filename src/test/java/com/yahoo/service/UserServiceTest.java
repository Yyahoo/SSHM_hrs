package com.yahoo.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yahoo.house.domain.User;
import com.yahoo.house.dto.UserLoginDto;
import com.yahoo.house.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app.xml")
public class UserServiceTest {
	@Autowired
	private UserService userService;
	@Test
	public void testLogin() {
		UserLoginDto user=new UserLoginDto();
		user.setUsername("yao");
		user.setPassword("23123");
		Assert.assertTrue(userService.login(user));
	}
	@Test
	public void testRegister() {
		User user=new User();
		user.setUsername("yao11");
		user.setPassword("123123");
		user.setRealname("高峰");
		user.setTel("15325615234");
		Assert.assertTrue(userService.register(user));
		
	}
}
