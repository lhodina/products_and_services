package com.codingdojo.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.productsandcategories.models.Category;
import com.codingdojo.productsandcategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepo;
	
	public List<Category> allCategories() {
		return categoryRepo.findAll();
	}
	
	public Category createCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	public Category updateCategory(Category category) {
		return categoryRepo.save(category);
	}
		
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}
}
