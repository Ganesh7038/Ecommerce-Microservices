package com.spring.ecommers.order_service.Clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service", path = "/inventory")
public interface InventoryOpenFeignClient {
	
	@GetMapping("/products/{id}")
	public Object getProductById(@PathVariable Long id);

}
