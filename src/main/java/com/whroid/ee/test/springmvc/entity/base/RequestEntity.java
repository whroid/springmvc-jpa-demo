package com.whroid.ee.test.springmvc.entity.base;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestEntity<T> {
	
	private String requestId;
	private String user;
	private T payload;
	
	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * @return the requestKey
	 */
	public String getRequestId() {
		return requestId;
	}
	/**
	 * @param requestKey the requestKey to set
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	/**
	 * @return the fields
	 */
	public T getPayload() {
		return payload;
	}
	/**
	 * @param fields the fields to set
	 */
	public void setPayload(T payload) {
		this.payload = payload;
	}
}
