package org.jsp.springbootuserapp.repository;

import org.jsp.springbootuserapp.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
