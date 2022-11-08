package com.synchrony.UserVerification.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.synchrony.UserVerification.entities.UserImageDtls;


@Repository
@SuppressWarnings("unchecked")
public class ImageOptRepo {
	
	@Autowired
	EntityManager em;

	public void insertURLForImg(UserImageDtls UserImageDtlsObj) {
		em.persist(UserImageDtlsObj);
	}

	public List<String[]> getImageUrl(String name) {
		Session session = em.unwrap(Session.class);
		Query<?> query = session.createNativeQuery("Select upload_img_url,image_name from user_image_dtls where user_name =: userName");
		query.setParameter("userName", name);

		return (List<String[]>) query.getResultList();
	}
	
	public List<String> getDeleteHash(String userName, String imgName) {
		
		Session session = em.unwrap(Session.class);
		Query<?> query = session.createNativeQuery("Select delete_hash from user_image_dtls where user_name =: userName and image_name =:imgName");
		query.setParameter("userName", userName);
		query.setParameter("image_name", imgName);
		
		return (List<String>) query.getResultList();
	}
	
	
	
	
}
