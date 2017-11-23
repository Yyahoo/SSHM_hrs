package com.yahoo.house.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name="tb_city")
public class City implements Serializable{
	@Id
	@Column(name="cityid")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="cityname")
	private String name;
	@ManyToOne()
	@JoinColumn(name="prov_id")
	private Province province;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}

	
}
