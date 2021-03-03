package com.sileg.app.webcontroller;

import java.math.BigInteger;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sileg.app.domain.DomainProduct;
import com.sileg.app.domain.service.DomainProductService;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("products")
public class ProductController {
	
	@Autowired
	private DomainProductService domainProductService;
	
	@GetMapping
	public ResponseEntity<List<DomainProduct>> getAll(){
		return new ResponseEntity<>(domainProductService.getAll(),HttpStatus.OK);
	}
	
	/*
	 * Tenemos dos formas de enlazar un parametro que venga por el path
	 * 1. Podemos solamente poner en el atributo que recibe GetMapping el mismo nombre
	 * 	  del parametro del metodo que en este caso seria code
	 * 2. Podemos ser mas explicitos y decirle en el PathVariable el mismo nombre que indicamos
	 *    en GetMapping en este caso id en ambas partes
	 */
	@GetMapping("/{id}")
	public ResponseEntity<DomainProduct> getProduct(@PathVariable("id") BigInteger code){
		return domainProductService.getById(code)
				.map(product -> new ResponseEntity<>(product,HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/category/{id}")
	public ResponseEntity<List<DomainProduct>> getByCategory(@PathVariable int id){
		
		return domainProductService.getByCategory(id)
				.filter(Predicate.not(List::isEmpty))
				.map(products -> new ResponseEntity<>(products,HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	/*
	 * Aca estamos utilizando la segunda forma del comentario que deje en el 
	 * metodo de getProduct.
	 */
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{code}")
	public ResponseEntity deleteProduct(@PathVariable BigInteger code) {
		if(domainProductService.delete(code)) {
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<DomainProduct> save(@RequestBody DomainProduct product) {
		return new ResponseEntity<>(domainProductService.save(product),HttpStatus.CREATED);
	}
	
	@PutMapping
	public DomainProduct update(@RequestBody DomainProduct updateProduct) {
		return domainProductService.update(updateProduct);
	}
	
}
