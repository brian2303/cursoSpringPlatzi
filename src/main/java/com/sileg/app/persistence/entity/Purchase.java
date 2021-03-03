package com.sileg.app.persistence.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "buy")
public class Purchase {
	
	@Id
	@Column(name = "bill_number")
	private String billNumber;
	
	private Double subtotal;
	
	private Double iva;
	
	private Double total;
	
	@Column(name = "buy_date")
	private LocalDate purchaseDate;
	
	@Column(name = "supplier_id")
	private String supplierId;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "supplier_id", referencedColumnName = "nit", updatable = false, insertable = false)
	private Supplier supplier;
	
	/**
	 * Debemos crear la lista con la Clase DetailPurchase por que esta es la clase que respalda la relacion
	 * ente la compra y los productos atravez de su atributo purchase.
	 * Por eso colocamos mappedBy= "purchase"
	 */
	@OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL)
	private List<DetailPurchase> products;

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
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

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<DetailPurchase> getProducts() {
		return products;
	}

	public void setProducts(List<DetailPurchase> products) {
		this.products = products;
	}
	
	
	
}
