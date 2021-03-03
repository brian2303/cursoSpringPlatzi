package com.sileg.app.domain.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.sileg.app.domain.DomainProduct;

public interface DomainProductRepository {
	
	List<DomainProduct> getAll();
	
	Optional<DomainProduct> getById(BigInteger code);
	
	void delete(BigInteger code);
	
	Optional<List<DomainProduct>> getByCategory(int id);
	
	Optional<List<DomainProduct>> getLowStock(int quantity);
	
	DomainProduct save(DomainProduct product);
}
