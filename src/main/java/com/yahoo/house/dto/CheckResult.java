package com.yahoo.house.dto;

public class CheckResult {
	//是否有效
	private String username;
	private boolean valid;
	private String message; //对应的提示信息
	private String picture;  //正确的样式
	
	
	
	public CheckResult() {
		super();
	}
	public CheckResult(String username, boolean valid, String message, String picture) {
		super();
		this.username = username;
		this.valid = valid;
		this.message = message;
		this.picture = picture;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	

}
