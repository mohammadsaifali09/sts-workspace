package org.jsp.springbootuserapp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.springbootuserapp.dao.ProductDao;
import org.jsp.springbootuserapp.dto.ResponseStructure;
import org.jsp.springbootuserapp.dto.User;
import org.jsp.springbootuserapp.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductDao dao;

	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
		ResponseStructure<Product> structure = new ResponseStructure<>();
		structure.setMessage("product added succesfully");
		structure.setBody(dao.saveProduct(product));
		structure.setCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product prodct) {
		ResponseStructure<Product> structure = new ResponseStructure<>();
		structure.setMessage("product updated succesfully");
		structure.setBody(dao.saveProduct(prodct));
		structure.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Product>> findProduct(int id) {
		ResponseStructure<Product> structure = new ResponseStructure<>();
		Optional<Product> recProduct = dao.findProduct(id);
		if (recProduct.isPresent()) {
			structure.setMessage("product found");
			structure.setBody(recProduct.get());
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.OK);
		}
		structure.setMessage("product not found");
		structure.setBody(null);
		structure.setCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<List<Product>>> findAllProduct() {
		ResponseStructure<List<Product>> structure = new ResponseStructure<>();
		structure.setMessage("All products are displayed");
		structure.setBody(dao.findAllProduct());
		structure.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteProduct(int id) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<Product> recProduct = dao.findProduct(id);
		if (recProduct.isPresent()) {
			dao.deleteProduct(id);
			structure.setMessage("product found");
			structure.setBody("product deleted");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);
		}
		structure.setMessage("product not found");
		structure.setBody("product not deleted");
		structure.setCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
}
