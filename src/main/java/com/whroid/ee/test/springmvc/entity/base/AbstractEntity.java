/**
 * Package: com.inmovation.lightoa.entity
 *
 * File: AbstractEntity.java 
 *
 * Author: jeff.cui   Date: 2014-7-3
 *
 * Copyright @ 2014 Inmovation Information Technology (Shanghai) Limited
 * 
 */
package com.whroid.ee.test.springmvc.entity.base;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractEntity {
	
	@Id
	@GenericGenerator(name = "uuid_gen", strategy = "uuid")
	@GeneratedValue(generator = "uuid_gen")
	@Column(length = 32)
	private String id;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/* 
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (this.id == null || obj == null || !(this.getClass().equals(obj.getClass()))) {
			return false;
		}

		AbstractEntity that = (AbstractEntity) obj;

		return this.id.equals(that.getId());
	}

	/* 
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}
}
