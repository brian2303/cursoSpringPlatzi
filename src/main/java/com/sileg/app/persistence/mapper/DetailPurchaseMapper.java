package com.sileg.app.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.sileg.app.domain.DomainDetailPurchase;
import com.sileg.app.persistence.entity.DetailPurchase;

@Mapper(componentModel = "spring", uses = {ProductMapper.class, PurchaseMapper.class})
public interface DetailPurchaseMapper {
	
	
	@Mappings({
		@Mapping(source = "id.productId", target = "productId"),
		@Mapping(source = "quantity", target = "quantity"),
		@Mapping(source = "subtotal", target = "subtotal"),
	})
	DomainDetailPurchase toDomainDetailPurchase(DetailPurchase detailPurchase);
	
	List<DomainDetailPurchase> toDomainDetailPurchases(List<DetailPurchase> detailsPurchase);
	
	@InheritInverseConfiguration
	@Mappings({
		@Mapping(target = "purchase", ignore = true),
		@Mapping(target = "product", ignore = true),
		@Mapping(target = "id.buyId", ignore = true),
	})
	DetailPurchase toDetailPurchase(DomainDetailPurchase domainDetailPurchase);
	
}
