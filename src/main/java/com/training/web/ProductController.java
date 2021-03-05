package com.training.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.domain.Product;
import com.training.service.ProductService;

@RestController
public class ProductController {
	
	int instanceId = (int) (Math.random() * 100);

	@Autowired
	ProductService service;
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return service.findAll();
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id")int pid){
		
		System.out.println("<<<<<<<<<<<<<<<<<<< ProductService instance id: "+instanceId+" >>>>>>>>>>>>>>>>>>>>>");
		
		Product p = service.findById(pid);
		if(p != null) {
			return new ResponseEntity<Product>(p, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product toBeAdded){
		
		try {
			int id = service.addProduct(toBeAdded);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create("/products/"+id));
			return new ResponseEntity<Product>(toBeAdded, headers, HttpStatus.CREATED);
		}catch(IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
