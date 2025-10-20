package com.spring.ecommers.order_service.Controller;

import java.util.List;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import com.spring.ecommers.order_service.DTO.OrderRequestDTO;
import com.spring.ecommers.order_service.Service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
	
	private final OrderService orderService;
	private final DiscoveryClient discoveryClient;
	private final RestClient restClient;
	
	@GetMapping
	public ResponseEntity<List<OrderRequestDTO>> getAllOrders()
	{
		return orderService.getAllOrders();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderRequestDTO> getOrderByid(@PathVariable Long id )
	{
		return orderService.getOrderById(id);
	}
	
	//Fetching product from inventory-service using Discovery Client
	
	@GetMapping("/products/{id}")
	public String getProductsById(@PathVariable Long id)
	{
		ServiceInstance serviceInstance = discoveryClient.getInstances("inventory-service").get(0);
		
		System.out.println(serviceInstance.getUri());
		Object data = restClient.get().uri(serviceInstance.getUri()+"/api/v1/products/{id}",id)
		.retrieve()
		.body(Object.class);
		
		return data.toString();
		
	}

}
