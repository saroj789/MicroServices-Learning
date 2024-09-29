package com.orderservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderservice.services.OrderService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

			
	@GetMapping
	public String getOrders() {
	    String userInfo = orderService.getUserInfo("1");
	    return "All orders: " + userInfo;
	}

	
	
    @GetMapping("/{id}")
    public String getOrder(@PathVariable("id") String orderId) {
    	String userInfo = orderService.getUserInfo(orderId);
        return "For Order details id: " + orderId +"  --- userInfo  : "+ userInfo;
    }
    
    @GetMapping("/rest/{id}")
    public String getOrderUsingRestTemplate(@PathVariable("id") String orderId) {
    	String userInfo = orderService.getUserInfoUsingRestTemp(orderId);
        return "For Order details id: " + orderId +"  --- userInfo  : "+ userInfo;
    }
    
    
    
    @Value("${order-service.message}")
    private String message;

    @GetMapping("/message")
    public String getMessage() {
        return this.message;
    }
    
    
    @GetMapping("/test")
    public String test() {
    	return "test";
    }
}