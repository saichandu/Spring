package com.ecommerceapp.apis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerceapp.entities.Product;
import com.ecommerceapp.entities.ProductCategory;
import com.ecommerceapp.repos.ProductCategoryRepository;
import com.ecommerceapp.repos.ProductRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ECommerceController {
	
	@Autowired
	ProductRepository prodRepo;
	
	@Autowired
	ProductCategoryRepository prodCatRepo;
	
	@GetMapping(path = {"/products","/search"})
	public List<Product> getProducts() {
		return prodRepo.findAll();
	}
	
	@GetMapping("/product-category")
	public List<ProductCategory> getProductCategories() {
		return prodCatRepo.findAll();
	}
	
	@GetMapping("/products/{id}")
	public Product getProductDetailsById(@PathVariable(name="id") Long productId) {
		if (prodRepo.findById(productId).isPresent()) {
			return prodRepo.findById(productId).get();
		}
		return null;
	}
	
	@GetMapping("/product-category/{categoryid}/products")
	public List<Product> getProductsByCategory(@PathVariable(name="categoryid") Long categoryId) {
		if (prodCatRepo.findById(categoryId).isPresent()) {
			return prodCatRepo.findById(categoryId).get().getProducts();
		}
		return new ArrayList<>();
	}
	
	@GetMapping("/search/{searchkey}")
	public List<Product> getProductsByCategory(@PathVariable(name="searchkey") String searchKey) {
		return prodRepo.findByNameContainingIgnoreCase(searchKey);
	}


}
