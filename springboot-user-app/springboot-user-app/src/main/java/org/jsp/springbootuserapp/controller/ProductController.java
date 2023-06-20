package org.jsp.springbootuserapp.controller;

import java.util.List;

import org.jsp.springbootuserapp.dto.ResponseStructure;
import org.jsp.springbootuserapp.dto.Product;
import org.jsp.springbootuserapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	private ProductService service;

	@PostMapping("/products")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}

	@PutMapping("/products")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<ResponseStructure<Product>> findProduct(@PathVariable int id) {
		return service.findProduct(id);
	}

	@GetMapping("/products")
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProduct() {
		return service.findAllProduct();
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}
}
