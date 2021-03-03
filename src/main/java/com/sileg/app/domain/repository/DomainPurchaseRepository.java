package com.sileg.app.domain.repository;

import java.util.List;
import java.util.Optional;

import com.sileg.app.domain.DomainPurchase;

public interface DomainPurchaseRepository {
	List<DomainPurchase> getAll();
	Optional<DomainPurchase> getById(String billNumber);
	DomainPurchase create(DomainPurchase domainPurchase);
}
