package com.synchrony.UserVerification.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "user_image_dtls")
public class UserImageDtls {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "user_name", nullable = false)
	private String userName;
	
	@Column(name="image_name", nullable = false)
	private String imgName;
	
	@Column(name="delete_hash", nullable = false)
	private String deleteHash;
	
	@NotEmpty(message="image url should not be null")
	@Column(name = "upload_img_url")
	private String uploadImgLink;

	
	public String getDeleteHash() {
		return deleteHash;
	}


	public void setDeleteHash(String deleteHash) {
		this.deleteHash = deleteHash;
	}


	public String getImgName() {
		return imgName;
	}


	public void setImgName(String imgName) {
		this.imgName = imgName;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUploadImgLink() {
		return uploadImgLink;
	}


	public void setUploadImgLink(String uploadImgLink) {
		this.uploadImgLink = uploadImgLink;
	}
	
}
