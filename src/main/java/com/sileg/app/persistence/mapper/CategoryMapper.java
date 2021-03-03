package com.sileg.app.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.sileg.app.domain.DomainCategory;
import com.sileg.app.persistence.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
	
	/*
	 * Aca lo que estamos logrando es mapear desde un entity Category
	 * a un DomainCategory
	 * 	source : Los atributos de la entity Category
	 * 	target : Los atributos de la clase DomainCategory con los que se va mapear
	 * 	
	 * 	@param category
	 * 	@return DomainCategory
	 */
	@Mappings({
		@Mapping(source = "id" ,target = "id"),
		@Mapping(source = "name", target = "name")
	})
	DomainCategory toDomainCategory(Category category);
	
	
	/**
	 * Aca estamos mapeando de manera inversa desde un
	 * DomainCatetory a un entity Category
	 * Ademas estamos herendando la configuracion anterior
	 * @param domainCategory
	 * @return Category
	 */
	@InheritInverseConfiguration()
	@Mapping(target = "products", ignore = true)
	Category toCategory(DomainCategory domainCategory);
	
}
