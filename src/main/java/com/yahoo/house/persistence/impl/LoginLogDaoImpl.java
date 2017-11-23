package com.yahoo.house.persistence.impl;

import org.springframework.stereotype.Repository;

import com.yahoo.house.domain.LoginLog;
import com.yahoo.house.persistence.LoginLogDao;


@Repository
public class LoginLogDaoImpl  extends BaseDaoAdapter<LoginLog, Integer> 
  implements  LoginLogDao
{
  
}
