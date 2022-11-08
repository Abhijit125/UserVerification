package com.synchrony.UserVerification.Dto;

public class ResponseDto {

	private Integer code;
	
	private String status;
	
	private String description;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public ResponseDto() {}

	public ResponseDto(Integer code, String status, String description) {
		super();
		this.code = code;
		this.status = status;
		this.description = description;
	}
	
}
