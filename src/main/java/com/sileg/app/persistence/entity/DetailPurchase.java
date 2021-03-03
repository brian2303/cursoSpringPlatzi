package com.sileg.app.persistence.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "detail_buy")
public class DetailPurchase {

	/*
	 * El embebbedId lo utilizamos cuando tenemos una llave primaria compuesta
	 * que construimos en otra clase en este ejemplo en la clase DetailPurchasePK
	 * Tambien podriamos haber solamente creado una llave primaria simple y asi
	 * nos ahorrariamos el tener que crear otra clase para forma la llave primaria compuesta
	 */
	@EmbeddedId
	private DetailPurchasePK id;

	private Integer quantity;
	
	private Double subtotal;
	
	@ManyToOne(optional = false,fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", referencedColumnName = "code" ,updatable = false, insertable = false)
	private Product product;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	
	@JoinColumn(name = "buy_id", referencedColumnName = "bill_number", updatable = false, insertable = false)
	private Purchase purchase;

	public DetailPurchasePK getId() {
		return id;
	}

	public void setId(DetailPurchasePK id) {
		this.id = id;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}	
}
