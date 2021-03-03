package com.sileg.app.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.sileg.app.persistence.entity.Purchase;

public interface PurchaseCrudRepository extends CrudRepository<Purchase,String> {

}
