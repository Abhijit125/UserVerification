package com.synchrony.UserVerification.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.synchrony.UserVerification.Dto.ImageDetails;
import com.synchrony.UserVerification.Dto.UploadImageResponse;
import com.synchrony.UserVerification.Dto.UserHashDto;
import com.synchrony.UserVerification.entities.UserImageDtls;
import com.synchrony.UserVerification.repository.ImageOptRepo;


@Service
public class ImageHandlerService {

	@Value("${imgur.upload-uri}")
	private String uploadUrl;

	@Value("${synchrony.clinet-id}")
	private String secretKey;

	@Value("${image.destination-path}")
	private String destination;

	@Value("${image.delete-uri}")
	private String deleteUri;

	@Autowired
	ImageOptRepo imgOptRepo;

	@Autowired
	WebClientService webClient;

	public void uploadImage(MultipartFile image, String userName) throws JsonMappingException, JsonProcessingException {

		String response = webClient.webClientServiceForUploadImage(image, uploadUrl, secretKey);

		ObjectMapper mapper = new ObjectMapper();

		UploadImageResponse uploadImageResponseObj = mapper.readValue(response, UploadImageResponse.class);

		for (ImageDetails imageDtls : uploadImageResponseObj.getData()) {
			UserImageDtls userDtlsPbj = new UserImageDtls();
			userDtlsPbj.setUserName(userName);
			userDtlsPbj.setImgName(imageDtls.getId() + ".png");
			userDtlsPbj.setDeleteHash(imageDtls.getDeletehash());
			userDtlsPbj.setUploadImgLink(imageDtls.getLink());
			imgOptRepo.insertURLForImg(userDtlsPbj);
		}
	}

	public void getImgs(String userName) throws IOException {
		List<String[]> listOfUrl = imgOptRepo.getImageUrl(userName);

		for (String[] url : listOfUrl) {
			webClient.getImgUsingWebClientService(url[0], destination, url[1]);

		}

	}

	public void deleteImgs(UserHashDto userHash) {

		for (String img : userHash.getImgNames()) {
			List<String> listOfDeletedHash = imgOptRepo.getDeleteHash(userHash.getUserName(), img);
			if (!listOfDeletedHash.isEmpty()) {
				webClient.deleteImgWebClientService(deleteUri, listOfDeletedHash.get(0), secretKey);
			}
		}
	}

}
