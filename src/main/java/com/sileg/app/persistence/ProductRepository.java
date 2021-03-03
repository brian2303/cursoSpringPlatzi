package com.sileg.app.persistence;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sileg.app.domain.DomainProduct;
import com.sileg.app.domain.repository.DomainProductRepository;
import com.sileg.app.persistence.crud.ProductCrudRepository;
import com.sileg.app.persistence.entity.Product;
import com.sileg.app.persistence.mapper.ProductMapper;

@Repository
public class ProductRepository implements DomainProductRepository {
	
	@Autowired
	private ProductCrudRepository productCrudRepository;
	
	@Autowired
	private ProductMapper mapper;
	
	@Override
	public List<DomainProduct> getAll(){
		List<Product> products = (List<Product>) productCrudRepository.findAll();
		return mapper.toDomainProducts(products);
	}
	
	
	@Override
	public Optional<DomainProduct> getById(BigInteger code) {
		// este metodo map recibe un Optional y retorna un nuevo optional con la funcion que le apliquemos
		// pero es importante tener en cuenta que el parametro product se recibe limpio es decir como
		// si le quitaremos el Optional para hacer la transformacion y luego de nuevo devolvemos un optional
		return productCrudRepository.findById(code).map(product -> mapper.toDomainProduct(product));
	}
	
	@Override
	public void delete(BigInteger code) {
		productCrudRepository.deleteById(code);
	}
	
	@Override
	public Optional<List<DomainProduct>> getByCategory(int id){
		List<Product> products = productCrudRepository.findByCategoryIdOrderByNameAsc(id);
		return Optional.of(mapper.toDomainProducts(products));
	}
	
	
	@Override
	public Optional<List<DomainProduct>> getLowStock(int quantity){
		Optional<List<Product>> products = productCrudRepository.findByStockLessThan(quantity);
		// Este metodo map es de la clase Optional que recibe un optional y devuelve otro optional.
		return products.map(product -> mapper.toDomainProducts(product));
	}
	
	@Override
	public DomainProduct save(DomainProduct product) {
		return mapper.toDomainProduct(productCrudRepository.save(mapper.toProduct(product)));
	}

	

	
}
