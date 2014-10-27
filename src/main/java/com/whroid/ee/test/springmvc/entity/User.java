package com.whroid.ee.test.springmvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.whroid.ee.test.springmvc.entity.base.AbstractEntity;


@Entity
@Table(name = "c_user" )
public class User extends AbstractEntity{

	@Column
	private String name;
	
	@Column 
	private String password;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
