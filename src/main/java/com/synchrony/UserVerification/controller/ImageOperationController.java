package com.synchrony.UserVerification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.synchrony.UserVerification.Dto.ResponseDto;
import com.synchrony.UserVerification.Dto.UserHashDto;
import com.synchrony.UserVerification.service.ImageHandlerService;



@RestController
public class ImageOperationController {

	@Autowired
	ImageHandlerService imageService;

	@PostMapping("/uploadImage")
	public ResponseDto uploadImage(@PathVariable String userName, @RequestParam("image") MultipartFile image) {
		ResponseDto response = null;

		try {
			imageService.uploadImage(image, userName);
			response = new ResponseDto(200, "Success", "Successfully added Images");

		} catch (Exception e) {
			response = new ResponseDto(400, "error", "Failed during uploading image..");
		}
		return response;
	}

	@GetMapping("/viewImage")
	public void getImage(@PathVariable String name) {
		try {
			imageService.getImgs(name);
		} catch (Exception e) {

		}
	}

	@PostMapping("/deleteImage")
	public ResponseDto deleteImage(@RequestBody UserHashDto userHash) {
		ResponseDto response = null;
		try {
			imageService.deleteImgs(userHash);
			response = new ResponseDto(200, "Success", "Deleted images successfully");
		} catch (Exception e) {
			response = new ResponseDto(400, "error", "Some issue occured while deleting Images");
		}
		return response;
	}

}
