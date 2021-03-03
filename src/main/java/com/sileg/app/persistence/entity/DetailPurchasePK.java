package com.sileg.app.persistence.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class DetailPurchasePK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "product_id")
	private BigInteger productId;
	
	@Column(name = "buy_id")
	private String buyId;

	public BigInteger getProductId() {
		return productId;
	}

	public void setProductId(BigInteger productId) {
		this.productId = productId;
	}

	public String getBuyId() {
		return buyId;
	}

	public void setBuyId(String buyId) {
		this.buyId = buyId;
	}
	
	
	
}
