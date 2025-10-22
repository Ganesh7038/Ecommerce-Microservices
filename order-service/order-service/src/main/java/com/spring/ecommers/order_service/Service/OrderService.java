package com.spring.ecommers.order_service.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.ecommers.order_service.Clients.InventoryOpenFeignClient;
import com.spring.ecommers.order_service.DTO.OrderRequestDTO;
import com.spring.ecommers.order_service.Entity.Orders;
import com.spring.ecommers.order_service.Repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
	
	private final OrderRepository orderRepository;
	private final ModelMapper modelMapper;
	private final InventoryOpenFeignClient inventoryOpenFeignClient;
	
	public ResponseEntity<List<OrderRequestDTO>> getAllOrders()
	{
		List<Orders> orders = orderRepository.findAll();
		
		return ResponseEntity.ok(
				
				orders.
				stream().
				map( r -> modelMapper.map(r, OrderRequestDTO.class))
				.toList()
	
				);
 	}
	
	public ResponseEntity<OrderRequestDTO> getOrderById(Long id)
	{
		Orders order = orderRepository.findById(id).orElseThrow();
		return ResponseEntity.ok( modelMapper.map(order,OrderRequestDTO.class));
	}

	public String getProductsById(Long id) {
		
		return inventoryOpenFeignClient.getProductById(id).toString();
		
	}


}
