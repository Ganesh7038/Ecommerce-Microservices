package com.spring.ecommers.order_service.Clients;

import com.spring.ecommers.order_service.DTO.OrderRequestDTO;
import com.spring.ecommers.order_service.DTO.OrderRequestItemDTO;
import com.spring.ecommers.order_service.DTO.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PatchExchange;

@FeignClient(name = "inventory-service", path = "/inventory")
public interface InventoryOpenFeignClient {
	
	@GetMapping("/products/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id);

    @PutMapping("/products/updateProductStock")
    public ResponseEntity<Double> updateProductStock(@RequestBody OrderRequestDTO orderRequestDTO);

}
