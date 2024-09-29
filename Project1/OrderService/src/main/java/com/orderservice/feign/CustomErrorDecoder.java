package com.orderservice.feign;

import org.apache.logging.log4j.util.InternalException;
import org.springframework.stereotype.Component;

import feign.Response;
import feign.codec.ErrorDecoder;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.NotFoundException;

@Component
public class CustomErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {
		switch (response.status()) {
		case 400:
			return new BadRequestException("Bad Request");
		case 404:
			return new NotFoundException("User Not Found");
		case 500:
			return new InternalServerErrorException("Internal error : " + response.body().toString());
		default:
			return new Exception("General error");
		}
	}
}
