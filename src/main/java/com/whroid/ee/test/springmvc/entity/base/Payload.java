package com.whroid.ee.test.springmvc.entity.base;

public class Payload<T> {
	
	private String requestId = new String();
	private String msg = new String();
	private T payload;
	
	public Payload(String requestId) {
		this.requestId = requestId;
	}
	
	public Payload(String requestId, T payload) {
		this.requestId = requestId;
		this.payload = payload;
	}

	/**
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the payload
	 */
	public T getPayload() {
		return payload;
	}

}
