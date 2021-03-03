package com.sileg.app.domain;

import java.math.BigInteger;




public class DomainProduct {
	
	private BigInteger code;
	private String name;
	private DomainCategory category;
	private Integer stock;
	private Double salePrice;
	private Integer categoryId;
	
	
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public BigInteger getCode() {
		return code;
	}
	public void setCode(BigInteger code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DomainCategory getCategory() {
		return category;
	}
	public void setCategory(DomainCategory category) {
		this.category = category;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}
	
	
	
}
