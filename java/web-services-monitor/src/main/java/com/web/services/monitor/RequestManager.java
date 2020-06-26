package com.web.services.monitor;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RequestManager {
	
	RequestManager(){}
	
	ResponseEntity<String> SendGetRequest(String url) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> webResponse = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
		return webResponse;
	}
	
	ResponseEntity<String> SendPostRequest(String url, String payload, String mediaType) {
		// Set up HTTP request
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders header = new HttpHeaders();
		if (mediaType.equals("JSON")) {
			header.setContentType(MediaType.APPLICATION_JSON);
		}
		HttpEntity<String> requestBody = new HttpEntity<String>(payload, header);
		// Send request
		ResponseEntity<String> webResponse = restTemplate.exchange(url, HttpMethod.POST, requestBody, String.class);
		return webResponse;
	}
	
	boolean CheckResponseStatus(ResponseEntity<String> response, HttpStatus target) {
		return response.getStatusCode() == target;
	}
	
	boolean CheckResponseBody(ResponseEntity<String> response, String bodyContents) {
		return response.getBody().contains(bodyContents);
	}
}
