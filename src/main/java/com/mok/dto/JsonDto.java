package com.mok.dto;


public class JsonDto<entityType> {
	
	private String resultCode;
	private String resultMessage;
	private entityType data;
	
	
	
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String reslutCode) {
		this.resultCode = reslutCode;
	}
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String reslutMessage) {
		this.resultMessage = reslutMessage;
	}
	public entityType getData() {
		return data;
	}
	public void setData(entityType data) {
		this.data = data;
	}
	
	
}


