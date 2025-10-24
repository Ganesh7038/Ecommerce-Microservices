package com.spring.ecommers.inventory_service.Controllers;

import java.util.List;

import com.spring.ecommers.inventory_service.DTO.OrderRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.ecommers.inventory_service.DTO.ProductDTO;
import com.spring.ecommers.inventory_service.Service.ProductService;
import com.spring.ecommers.inventory_service.entities.Product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/products")
@Slf4j
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<ProductDTO>> getAllProducts()
	{
		List<ProductDTO> inventories = productService.getAllProducts();
		return ResponseEntity.ok(inventories);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> getProductById( @PathVariable Long id)
	{
		return ResponseEntity.ok(productService.getProductById(id));
	}
	
	@PostMapping("/addProducts")
	public void addProducts(@RequestBody List<Product> products)
	{
		productService.addProducts(products);
	}
	
	@GetMapping("/orders/{id}")
	public String getOrdersById(@PathVariable Long id)
	{
		return productService.getOrdersById(id).toString();
	}

    @PutMapping("/updateProductStock")
    public ResponseEntity<Double> updateProductStock(@RequestBody OrderRequestDTO orderRequestDTO)
    {
        return ResponseEntity.ok(productService.updateProductStock(orderRequestDTO));
    }

}
