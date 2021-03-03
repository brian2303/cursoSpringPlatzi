package com.sileg.app.domain.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sileg.app.domain.DomainProduct;
import com.sileg.app.domain.repository.DomainProductRepository;

@Service
public class DomainProductService {
	
	@Autowired
	private DomainProductRepository domainProductRepository;
	
	public List<DomainProduct> getAll(){
		return domainProductRepository.getAll();
	}
	
	public Optional<DomainProduct> getById(BigInteger code){
		return domainProductRepository.getById(code);
	}
	
	public DomainProduct update(DomainProduct updateProduct) {
		return getById(updateProduct.getCode()).map(product -> {
			save(updateProduct);
			return updateProduct;
		}).orElse(new DomainProduct());
	}
	
	public Optional<List<DomainProduct>> getByCategory(int id){
		return domainProductRepository.getByCategory(id);
	}
	
	public DomainProduct save(DomainProduct product) {
		return domainProductRepository.save(product);
	}
	
	public boolean delete(BigInteger code) {
		return getById(code).map(product -> {
			domainProductRepository.delete(code);
			return true;
		}).orElse(false);
	}
	
	
}
