package com.demo.microservices.product.query.api.controller;

import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.microservices.product.query.api.data.ProductDto;
import com.demo.microservices.product.query.api.query.GetProductsQuery;

@RestController
@RequestMapping("/products")
public class ProductQueryController {

	@Autowired
	private QueryGateway queryGateway;
	
	@GetMapping
	public List<ProductDto> getAllProduct() {
		GetProductsQuery getProductsQuery = new GetProductsQuery();
		
		List<ProductDto> productsDto = 
				queryGateway.query(getProductsQuery, ResponseTypes.multipleInstancesOf(ProductDto.class))
					.join();
		
		return productsDto;
	}
}
