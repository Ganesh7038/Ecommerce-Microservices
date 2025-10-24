package com.spring.ecommers.inventory_service.DTO;

import com.spring.ecommers.inventory_service.Enums.OrderStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDTO {
	
	private Long id;
	private List<OrderRequestItemDTO> orderItems;
	private Double total_Price;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

}
