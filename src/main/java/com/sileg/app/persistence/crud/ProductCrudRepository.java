package com.sileg.app.persistence.crud;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sileg.app.persistence.entity.Product;

public interface ProductCrudRepository extends CrudRepository<Product,BigInteger> {
	
	List<Product> findByCategoryIdOrderByNameAsc(int id);
	
	Optional<List<Product>> findByStockLessThan(int quantity);
	
}
