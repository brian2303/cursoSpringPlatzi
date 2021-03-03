package com.sileg.app.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sileg.app.domain.DomainPurchase;
import com.sileg.app.domain.repository.DomainPurchaseRepository;

@Service
public class DomainPurchaseService {
	
	@Autowired
	DomainPurchaseRepository domainPurchaseRepository;
	
	public List<DomainPurchase> getAll(){
		return domainPurchaseRepository.getAll();
	}
	
	public Optional<DomainPurchase> getById(String billNumber){
		return domainPurchaseRepository.getById(billNumber);
	}
	
	public DomainPurchase create(DomainPurchase domainPurchase) {
		return domainPurchaseRepository.create(domainPurchase);
	}
}
