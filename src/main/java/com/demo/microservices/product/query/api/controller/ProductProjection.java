package com.demo.microservices.product.query.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.microservices.product.query.api.data.Product;
import com.demo.microservices.product.query.api.data.ProductDto;
import com.demo.microservices.product.query.api.data.ProductRepository;
import com.demo.microservices.product.query.api.query.GetProductsQuery;

@Component
public class ProductProjection {
	@Autowired
	private ProductRepository productRepository;
	
	@QueryHandler
	public List<ProductDto> handle(GetProductsQuery getProductsQuery) {
		List<Product> products = productRepository.findAll();
		
		List<ProductDto> productsDto = 
				products.stream().map(product -> ProductDto.builder()
						.name(product.getName())
						.price(product.getPrice())
						.quantity(product.getQuantity())
						.build())
				.collect(Collectors.toList());
		
		return productsDto;
	}
}
