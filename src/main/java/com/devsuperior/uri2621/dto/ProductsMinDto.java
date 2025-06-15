package com.devsuperior.uri2621.dto;

import com.devsuperior.uri2621.projection.ProductMinProjection;

public class ProductsMinDto {
	
	private Integer min;
	private Integer max;
	private String name;

	public ProductsMinDto() {
	}

	public ProductsMinDto(Integer min, Integer max, String name) {
		super();
		this.min = min;
		this.max = max;
		this.name = name;
	}
	
	public ProductsMinDto(ProductMinProjection projection) {
		min = projection.getMin();
		max = projection.getMax();
		name = projection.getName();
	}

	
	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public String toString() {
		return "ProductsMinDto [name=" + name + "]";
	}


}
