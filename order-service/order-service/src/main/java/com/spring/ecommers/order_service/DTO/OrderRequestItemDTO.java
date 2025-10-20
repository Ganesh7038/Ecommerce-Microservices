package com.spring.ecommers.order_service.DTO;

import lombok.Data;

@Data
public class OrderRequestItemDTO {
	
	private Long id;
	private Long productId;
	private Integer quantity;
	
}
