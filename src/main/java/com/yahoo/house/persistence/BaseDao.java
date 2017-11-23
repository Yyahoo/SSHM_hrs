package com.yahoo.house.persistence;

import java.io.Serializable;
import java.util.List;

/**
 * 通用增删改查底层接口
 * @author 义亚宏
 * 创建时间:2017年10月17日下午3:17:19
 * @param <E>
 * @param <K>
 */
public interface BaseDao <E,K extends Serializable> {
	
	K save(E entity);
	
	boolean deleteById(K id);
	
	void  update(E entity);
	
	E findById(K id);

	List<E> findAll();
}
