package com.sileg.app.domain;

import java.math.BigInteger;

public class DomainDetailPurchase {
	
	private BigInteger productId;
	
	private Integer quantity;
	
	private Double subtotal;

	public BigInteger getProductId() {
		return productId;
	}

	public void setProductId(BigInteger productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	
	

}
