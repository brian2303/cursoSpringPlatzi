package com.sileg.app.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.sileg.app.domain.DomainPurchase;
import com.sileg.app.persistence.entity.Purchase;

@Mapper(componentModel = "spring", uses = { DetailPurchaseMapper.class })
public interface PurchaseMapper {
	
	@Mappings({
		@Mapping(source = "billNumber", target = "billNumber"),
		@Mapping(source = "subtotal", target = "subtotal"),
		@Mapping(source = "iva", target = "iva"),
		@Mapping(source = "total", target = "total"),
		@Mapping(source = "supplierId", target = "supplierId"),
		@Mapping(source = "purchaseDate", target = "purchaseDate"),
		@Mapping(source = "products", target = "products"),
	})
	DomainPurchase toDomainPurchase(Purchase purchase);
	List<DomainPurchase> toDomainPurchases(List<Purchase> purchases);
	
	/**
	 * Siempre en la clase de destino (Purchase) debemos tener todos los mapeos
	 * si no tiene todos los mapeos debemos ignorarlo explicitamente
	 */
	@InheritInverseConfiguration
	@Mapping(target = "supplier", ignore = true)
	Purchase toPurchase(DomainPurchase domainPurchase);
	
}
