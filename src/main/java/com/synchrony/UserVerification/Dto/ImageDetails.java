package com.synchrony.UserVerification.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageDetails {
	private String id;

	private String deletehash;
	
	@JsonProperty("account_id")
	private String accountId;
	
	@JsonProperty("account_url")
	private String accountUrl;
	
	private String link;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeletehash() {
		return deletehash;
	}

	public void setDeletehash(String deletehash) {
		this.deletehash = deletehash;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountUrl() {
		return accountUrl;
	}

	public void setAccountUrl(String accountUrl) {
		this.accountUrl = accountUrl;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	
}
