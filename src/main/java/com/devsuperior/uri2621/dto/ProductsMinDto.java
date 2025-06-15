package com.devsuperior.uri2621.dto;

import com.devsuperior.uri2621.projection.ProductMinProjection;

public class ProductsMinDto {
	
	private String name;

	public ProductsMinDto() {
	}

	public ProductsMinDto(String name) {
		this.name = name;
	}
	
	public ProductsMinDto(ProductMinProjection projection) {
		name = projection.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
