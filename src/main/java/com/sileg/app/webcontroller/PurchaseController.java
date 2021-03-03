package com.sileg.app.webcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sileg.app.domain.DomainPurchase;
import com.sileg.app.domain.service.DomainPurchaseService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("purchases")
public class PurchaseController {
	
	@Autowired
	private DomainPurchaseService domainPurchaseService;
	
	@GetMapping
	public ResponseEntity<List<DomainPurchase>> getAll(){
		return new ResponseEntity<>(domainPurchaseService.getAll(),HttpStatus.OK); 
	}
	
	@GetMapping("/purchase/{id}")
	public ResponseEntity<DomainPurchase> getById(@PathVariable("id") String billNumber){
		return new ResponseEntity<>(domainPurchaseService.getById(billNumber).get(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<DomainPurchase> save(@RequestBody DomainPurchase domainPurchase){
		return new ResponseEntity<>(domainPurchaseService.create(domainPurchase),HttpStatus.CREATED);
	}
	
}
