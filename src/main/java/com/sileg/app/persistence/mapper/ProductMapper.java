package com.sileg.app.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.sileg.app.domain.DomainProduct;
import com.sileg.app.persistence.entity.Product;

/*
 * Indicandole que uses CategoryMapper.class el ya sabe que cuando vaya a
 * convertir de el atributo category del entity a el del DomainProduct
 * debe utilizar el mapper de CategoryMapper
 */
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
	
	@Mappings({
		@Mapping(source = "code", target = "code"),
		@Mapping(source = "name", target = "name"),
		@Mapping(source = "category", target = "category"),
		@Mapping(source = "salePrice", target = "salePrice"),
		@Mapping(source = "categoryId", target = "categoryId"),
	})
	DomainProduct toDomainProduct(Product product);
	/*
	 * Para este metodo no tenemos que volver a definir nuevamente
	 * los mappings por que ya MapStruct sabe como convertir de un entity de 
	 * Product a DomainProduct
	 */
	List<DomainProduct> toDomainProducts(List<Product> products);
	
	
	@InheritInverseConfiguration
	@Mapping(target = "lastPriceBuy", ignore = true)
	Product toProduct(DomainProduct domainProduct);
	
}
