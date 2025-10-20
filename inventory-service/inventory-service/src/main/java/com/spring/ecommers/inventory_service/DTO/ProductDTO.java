package com.spring.ecommers.inventory_service.DTO;


import lombok.Data;

@Data
public class ProductDTO {
	
	
	private Long id;
	
	private String title;
	private Double price;
	private Integer stock;
	

}
