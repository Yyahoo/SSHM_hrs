package com.yahoo.house.dto;

import java.util.List;
/**
 * 分页器
 * @author 义亚宏
 * 创建时间:2017年9月22日上午11:48:01
 * @param <T> 
 */
public class PageBean<T> {
	//处理得到的数据
	private List<T> dataModel;
	//最大页码
	private int totalPage;
	private int currentPage;
	private int pageSize;
	
	
	public PageBean(List<T> dataModel, int totalPage, int currentPage, int pageSize) {
		super();
		this.dataModel = dataModel;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}
	public List<T> getDataModel() {
		return dataModel;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	
	

}
