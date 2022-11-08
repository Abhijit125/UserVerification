package com.synchrony.UserVerification.Dto;

import java.util.List;

public class UserHashDto {
	
	private String userName;
	
	private List<String> imgNames;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<String> getImgNames() {
		return imgNames;
	}

	public void setImgNames(List<String> imgNames) {
		this.imgNames = imgNames;
	}
	
}
