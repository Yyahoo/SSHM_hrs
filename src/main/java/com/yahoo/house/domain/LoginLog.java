package com.yahoo.house.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_login_log")
public class LoginLog implements Serializable{
	@Id
	@Column(name="loginid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;    
	@JoinColumn(name="user_id")
	@ManyToOne
	private User user;  
	@Column(name="ipaddr")
	private String ipAddress;  
	private Date logdate;  
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public Date getLogdate() {
		return logdate;
	}
	public void setLogdate(Date logdate) {
		this.logdate = logdate;
	}
	
	
	
	
	

}
