package com.spring.ecommers.inventory_service.Clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "order-service", path="/orders")
public interface OrdersFeingClient {
	
	@GetMapping("/core/{id}")
	public Object getOrderById(@PathVariable Long id);

}
