package com.spring.ecommers.order_service.DTO;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class OrderRequestDTO {
	
	private Long id;
	private List<OrderRequestItemDTO> items;
	private BigDecimal totalPrice;
	

}
