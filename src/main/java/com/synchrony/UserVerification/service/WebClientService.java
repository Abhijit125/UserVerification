package com.synchrony.UserVerification.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class WebClientService {

	@Scheduled(fixedRate = 5000)
	public String webClientServiceForUploadImage(MultipartFile image, String uploadUrl, String secretKey) {
		WebClient webClient = WebClient.create(uploadUrl);
		String response = webClient.post().header("Authorization", "Client-ID " + secretKey).retrieve()
				.bodyToMono(String.class).block();

		if ("[]".equals(response)) {
			response = "[{\"status\":404,\"statusMessage\":\"PV_ERROR\",\"description\":\"Not able to Upload Image\"}]";
		}
		return response;
	}

	public void getImgUsingWebClientService(String url, String destination, String fileName) throws IOException {
		WebClient webClient = WebClient.create();
		Mono<byte[]> monoContents = webClient.get().uri(url).retrieve().bodyToMono(byte[].class);
		Path path = Paths.get(destination + File.separator + fileName);
		Files.write(path, Objects.requireNonNull(monoContents.share().block()), StandardOpenOption.CREATE);
	}

	
	
	public String deleteImgWebClientService(String url, String deleteHash, String secretKey) {
		WebClient webClient = WebClient.create(url + "/" + deleteHash);
		return webClient.delete().header("Authorization", "Client-ID " + secretKey).retrieve().bodyToMono(String.class)
				.block();
	}
}
