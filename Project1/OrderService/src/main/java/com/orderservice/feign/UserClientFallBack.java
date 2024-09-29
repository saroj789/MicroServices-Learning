package com.orderservice.feign;

import org.springframework.stereotype.Component;

@Component
public class UserClientFallBack implements UserClient {

	@Override
	public String getUserInfo(String userId) {
//		return "Fallback user information";
		return "Some error in UserService!!!";
	}

}
