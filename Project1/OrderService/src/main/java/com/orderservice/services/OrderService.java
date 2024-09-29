package com.orderservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.orderservice.feign.UserClient;

@Service
public class OrderService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UserClient userClient;
	
	
	//using FeignClient
	public String getUserInfo(String userId) {
		String userInfo = userClient.getUserInfo(userId);
		return userInfo;
	}

	//calling user service using restTemplate
	public String getUserInfoUsingRestTemp(String userId) {
		String url = "http://localhost:8081/users/" + userId;;
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		return responseEntity.getBody();
	}
	
	

}
