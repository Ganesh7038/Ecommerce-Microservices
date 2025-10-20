package com.spring.ecommers.inventory_service.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.spring.ecommers.inventory_service.DTO.ProductDTO;
import com.spring.ecommers.inventory_service.Repository.ProductRepository;
import com.spring.ecommers.inventory_service.entities.Product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository productRepository;
	private final ModelMapper modelMapper;
	
	public List<ProductDTO> getAllProducts()
	{
		log.info("Fetching all inventory items");
		List<Product> inventoriesList = productRepository.findAll();
		return inventoriesList.stream().map(product -> modelMapper.map(product, ProductDTO.class)).toList();
		
	}
	
	public ProductDTO getProductById(Long id)
	{
		log.info("Fetching Product with ID:" +id );
		Product product = productRepository.findById(id).orElseThrow();
		return modelMapper.map(product, ProductDTO.class);
	}

	public void addProducts(List<Product> products) {
		
		for(Product product:products)
		{
			productRepository.save(product);
		}
		
	}

}
