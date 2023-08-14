package com.codingdojo.productsandcategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.productsandcategories.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();
	Optional<Product> findById(Long id);
}
