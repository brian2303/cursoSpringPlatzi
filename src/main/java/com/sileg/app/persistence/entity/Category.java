package com.sileg.app.persistence.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	/*
	 * Para crear esta relacion previamente debimos haber configurado la verdadera relacion
	 * En el atributo mappedBy ponemos el nombre del atributo que esta respaldando esta relacion
	 * en este ejemplo estamos poniendo category por que asi se llama el atributo en nuesta clase Product
	 * que es donde se forma la relacion
	 * (Una categoria puede contener uno o muchos productos)
	*/
	@OneToMany(mappedBy = "category")
	private List<Product> products;
	
	

	public Category() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
}
