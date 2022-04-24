package com.demo.microservices.product.query.api.data;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ProductDto {
	private String name;
	private BigDecimal price;
	private Integer quantity;
	
	@Builder
	public ProductDto(String name, BigDecimal price, Integer quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
}
