package com.synchrony.UserVerification.Dto;

public class MessageQueueDto {
	
	private Integer code;
	
	private String msg;
	
	private String description;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public MessageQueueDto() {
	}

	public MessageQueueDto(Integer code, String msg, String description) {
		this.code = code;
		this.msg = msg;
		this.description = description;
	}

	public MessageQueueDto(String msg) {
		super();
		this.msg = msg;
	}
	
	
}
