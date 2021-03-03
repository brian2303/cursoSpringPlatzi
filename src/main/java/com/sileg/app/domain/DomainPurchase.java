package com.sileg.app.domain;

import java.time.LocalDate;
import java.util.List;


public class DomainPurchase {
	
	private String billNumber;
	
	private String supplierId;
	
	private LocalDate purchaseDate;
	
	private Double subtotal;
	
	private Double iva;
	
	private Double total;
	
	private List<DomainDetailPurchase> products;

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public List<DomainDetailPurchase> getProducts() {
		return products;
	}

	public void setProducts(List<DomainDetailPurchase> products) {
		this.products = products;
	}
	
	
	
}
