package com.synchrony.UserVerification.Dto;

import java.util.List;

public class UploadImageResponse {

	private String link;
	
	private Integer status;
	
	private String success;
	
	private List<ImageDetails> data;

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public List<ImageDetails> getData() {
		return data;
	}

	public void setData(List<ImageDetails> data) {
		this.data = data;
	}
	
}
