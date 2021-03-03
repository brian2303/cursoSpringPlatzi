package com.sileg.app.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sileg.app.domain.DomainPurchase;
import com.sileg.app.domain.repository.DomainPurchaseRepository;
import com.sileg.app.persistence.crud.PurchaseCrudRepository;
import com.sileg.app.persistence.entity.Purchase;
import com.sileg.app.persistence.mapper.PurchaseMapper;

@Repository
public class PurchaseRepository implements DomainPurchaseRepository {

	@Autowired
	private PurchaseCrudRepository purchaseCrudRepository;
	
	@Autowired
	private PurchaseMapper mapper;
	
	@Override
	public List<DomainPurchase> getAll() {
		return mapper.toDomainPurchases((List<Purchase>)  purchaseCrudRepository.findAll());
	}

	@Override
	public Optional<DomainPurchase> getById(String billNumber) {
		return purchaseCrudRepository.findById(billNumber).map(purchase -> mapper.toDomainPurchase(purchase));
	}

	@Override
	public DomainPurchase create(DomainPurchase domainPurchase) {
		Purchase purchase = mapper.toPurchase(domainPurchase);
		purchase.getProducts().forEach(product -> product.getId().setBuyId(purchase.getBillNumber()));
		return mapper.toDomainPurchase(purchaseCrudRepository.save(purchase));
	}

}
