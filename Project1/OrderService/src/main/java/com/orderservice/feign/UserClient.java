package com.orderservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service" , fallback = UserClientFallBack.class, url = "http://localhost:8081")
public interface UserClient {
	
	@GetMapping("users/{userId}")
	String getUserInfo(@PathVariable("userId") String userId); 
}
