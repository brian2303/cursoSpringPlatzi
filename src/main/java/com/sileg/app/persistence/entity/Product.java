package com.sileg.app.persistence.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "product")
public class Product {
	
	@Id
	private BigInteger code;
	
	
	private String name;
	
	/*
	 * (Muchos productos pueden pertenecer a una unica categoria)
	 * ACA ES DONDE SE FORMA LA RELACION QUE TENEMOS EN NUESTRA BD
	 * category_id equivale a el nombre de la columna foranea de nuestra tabla product en la BD
	 * id equivale al campo primario de la tabla category de la BD
	 */
	@JoinColumn(name = "category_id",insertable = false ,updatable = false,referencedColumnName = "id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Category category;
	
	private Integer stock;
	
	@Column(name = "last_price_buy")
	private Double lastPriceBuy;
	
	@Column(name = "sales_price")
	private Double salePrice;
	
	@Column(name = "category_id")
	private Integer categoryId;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Product() {
		super();
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Double getLastPriceBuy() {
		return lastPriceBuy;
	}

	public void setLastPriceBuy(Double lastPriceBuy) {
		this.lastPriceBuy = lastPriceBuy;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}
	
	
	
}
