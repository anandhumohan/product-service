package com.sci.productservice.controller;

import java.util.List;

import com.sci.productservice.dto.UpdateProductRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.sci.productservice.dto.ProductRequest;
import com.sci.productservice.dto.ProductResponse;
import com.sci.productservice.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService productService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createproduct(@RequestBody ProductRequest productRequest) {
		productService.createProduct(productRequest);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ProductResponse> getAllproducts(){
		return productService.getAllProdcuts();
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void updateproduct(@RequestBody UpdateProductRequest updateProductRequest){
		productService.updateProduct(updateProductRequest);
	}

	@GetMapping("/products/{id}")
	@ResponseStatus
	public ProductResponse getProductById(@PathVariable String id){
		return productService.getProductById(id);
	}

}
