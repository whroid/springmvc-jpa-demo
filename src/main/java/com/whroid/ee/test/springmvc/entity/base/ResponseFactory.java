package com.whroid.ee.test.springmvc.entity.base;

import org.springframework.http.HttpStatus;
import com.whroid.ee.base.util.StringUtil;

public class ResponseFactory<T> {
	
	private String requestId;
	private String message;
	private T payload;
	private boolean isError = true;
	
	public ResponseFactory(String requestId) {
		this.requestId = requestId;
	}
	
	public void setError(String msg) {
		isError = true;
		this.message = msg;
	}
	public void setNotFoundError() {
		this.setError("未找到指定对象");
	}
	
	public void setNotFoundError(String name) {
		this.setError(String.format("未找到指定%s", name));
	}
	
	public void setMissFieldError(String...fields) {
		StringBuffer sb = new StringBuffer();
		sb.append("缺少以下字段中至少一个：");
		for (int i = 0 ; i < fields.length ; i ++) {
			sb.append(fields[i]);
			sb.append(',');
		}
		sb.setCharAt(sb.length()-1, '.');
		this.setError(sb.toString());
	}
	
	public void setPayload(T payload) {
		isError = false;
		this.payload = payload;
	}
	
	public ResponseEntity<T> getResponse() {
		ResponseEntity<T> response = null;
		if (isError) {
			if (StringUtil.isEmpty(message)) {
				message = "未知错误，请检查服务器日志";
			}
			Payload<T> p = new Payload<T>(requestId);
			p.setMsg(message);
			response = new ResponseEntity<T>(p, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			response = new ResponseEntity<T>(new Payload<T>(requestId, payload), HttpStatus.OK);
		}
		return response;
	}

}
