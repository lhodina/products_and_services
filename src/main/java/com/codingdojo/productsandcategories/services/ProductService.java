package com.codingdojo.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.productsandcategories.models.Category;
import com.codingdojo.productsandcategories.models.Product;
import com.codingdojo.productsandcategories.repositories.CategoryRepository;
import com.codingdojo.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	public List<Product> allProducts() {
		return productRepo.findAll();
	}
	
	public Product createProduct(Product product) {
		return productRepo.save(product);
	}
	
	public Product updateProduct(Product product) {
		return productRepo.save(product);
	}
		
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}
	
	public Product addCategoryToProduct(Long productId, Long categoryId) {
		Optional<Product> thisProduct = productRepo.findById(productId);
		Optional<Category> thisCategory = categoryRepo.findById(categoryId);
		Product product = thisProduct.get();
		Category category = thisCategory.get();
		product.getCategories().add(category);
		productRepo.save(product);
		return product;
	}
}
