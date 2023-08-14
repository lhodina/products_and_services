package com.codingdojo.productsandcategories.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.productsandcategories.models.Category;
import com.codingdojo.productsandcategories.models.Product;
import com.codingdojo.productsandcategories.services.CategoryService;
import com.codingdojo.productsandcategories.services.ProductService;

import jakarta.validation.Valid;

@Controller
public class MainController {
    @Autowired
    private ProductService productService;
    
    @Autowired
    private CategoryService categoryService;
    
	@GetMapping("/")
	public String index(Model model) {
		List<Product> allProducts = productService.allProducts();
		List<Category> allCategories = categoryService.allCategories();
		model.addAttribute("allProducts", allProducts);
		model.addAttribute("allCategories", allCategories);
		return "index.jsp";
	}
	
	@GetMapping("/products/new")
	public String newProductForm(@ModelAttribute("product") Product product) {
		return "newProductForm.jsp";
	}
	
	@PostMapping("/products")
	public String addProduct(
		@Valid @ModelAttribute("product") Product product,
		BindingResult result
		) {
		productService.createProduct(product);
		return "redirect:/";
	}
	
	@GetMapping("/categories/new")
	public String newCategoryForm(@ModelAttribute("category") Category category) {
		return "newCategoryForm.jsp";
	}
	
	@PostMapping("/categories")
	public String addCategory(
		@Valid @ModelAttribute("category") Category category,
		BindingResult result
		) {
		categoryService.createCategory(category);
		return "redirect:/";
	}
	
	@GetMapping("/products/{productId}")
	public String showProduct(Model model, @PathVariable("productId") Long productId ) {
		Product product = productService.findProduct(productId);
		model.addAttribute("product", product);
		
		List<Category> productCategories = product.getCategories();
		model.addAttribute("productCategories", productCategories);
		
		List<Category> allCategories = categoryService.allCategories();
		model.addAttribute("allCategories", allCategories);
		
		ArrayList<String> productCategoryNames = new ArrayList<String>();
		for(Category category : productCategories) {
			String categoryName = category.getName();
			productCategoryNames.add(categoryName);
		}
		
		model.addAttribute("productCategoryNames", productCategoryNames);
		
		for(String categoryName : productCategoryNames) {
			System.out.println("categoryName: " + categoryName);
		}
		
		return "showProduct.jsp";
	}
	
	@PostMapping("/products/{productId}/categories")
	public String addProductCategory(
			@RequestParam("categoryId") Long categoryId,
			@PathVariable("productId") Long productId) {
		Product product = productService.findProduct(productId);
		Category category = categoryService.findCategory(categoryId);
		List<Category> productCategories = product.getCategories();
		productCategories.add(category);
		product.setCategories(productCategories);
		productService.updateProduct(product);
		return "redirect:/products/{productId}";
	}
	
	@GetMapping("/categories/{categoryId}")
	public String showCategory(Model model, @PathVariable("categoryId") Long categoryId) {
		Category category = categoryService.findCategory(categoryId);
		model.addAttribute("category", category);
		List<Product> categoryProducts = category.getProducts();
		model.addAttribute("categoryProducts", categoryProducts);
		
		List<Product> allProducts = productService.allProducts();
		model.addAttribute("allProducts", allProducts);
		
		ArrayList<String> categoryProductNames = new ArrayList<String>();
		for(Product product : categoryProducts) {
			String productName = product.getName();
			categoryProductNames.add(productName);
		}
		
		for (String categoryProductName : categoryProductNames) {
			System.out.println("categoryProductName: " + categoryProductName);
		}
		
		model.addAttribute("categoryProductNames", categoryProductNames);
		return "showCategory.jsp";
	}
	
	@PostMapping("/categories/{categoryId}/products")
	public String addCategoryProduct(
			@RequestParam("productId") Long productId,
			@PathVariable("categoryId") Long categoryId) {
		Product product = productService.findProduct(productId);
		Category category = categoryService.findCategory(categoryId);
		
		List<Product> categoryProducts = category.getProducts();
		categoryProducts.add(product);
		category.setProducts(categoryProducts);
		categoryService.updateCategory(category);
		return "redirect:/categories/{categoryId}";
	}
}
