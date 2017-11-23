package com.yahoo.house.util;

import java.util.ArrayList;
import java.util.List;

public class HqlQueryBean implements QueryBean {
	
	private String fromClouse;
	private String whereClouse;
	private String orderbyClouse;
	private List<Object> paramValues= new ArrayList<>();
	
	
	public HqlQueryBean(Class<?> entityType) {
		fromClouse="from"+entityType.getSimpleName()+"as o";
	}
	

	@Override
	public QueryBean addOrderBy(boolean flag, String keyword, boolean asc) {
		if(flag) {
		if(orderbyClouse==null) {
			orderbyClouse="order by o."+keyword+(asc?"asc":"desc");
		}else {
			orderbyClouse=",o."+keyword+(asc?"asc":"sc");
		}
		}
		return this;
	}

	@Override
	public QueryBean addCondition(boolean flag, String condition, Object value) {
		if (flag) {
			
			if (whereClouse == null) {
				whereClouse = "whrer o." + condition;
			} else {
				whereClouse += "and o." + condition;
			} 
			paramValues.add(value);
		}
		return this;
	}

	@Override
	public String getQueryString() {
		// TODO Auto-generated method stub
		return fromClouse+""+whereClouse+""+orderbyClouse;
	}

	@Override
	public String getCountString() {
		return "select count(o)"+fromClouse+""+whereClouse;
	}

	@Override
	public List<Object> getParameters() {
		// TODO Auto-generated method stub
		return paramValues;
	}

}
