package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.zensar.model.Products;
import com.zensar.service.ProductsService;
@RestController
@RequestMapping("/product")
public class ProductsController {
	@Autowired
	ProductsService service;
	
	@PostMapping("/add")
	public Products addProduct(@RequestBody Products product) {
		return service.addProducts(product);
	}
	@GetMapping("/findByProductsId/{pid}")
	public Products find(@PathVariable(name="pid") int id) {
		return this.service.findProductById(id);
	}
	@GetMapping("/products")
	public List<Products> getProductsList() {
		return this.service.getAllProducts();
	}
	@GetMapping("/findProductByName/{productName}")
	public Products findProductByName(@PathVariable(name="productName") String name) {
		return this.service.findProductByName(name);
	}
	@PutMapping(value="/updateProduct")
	public Products f4(@RequestBody Products product) {
		return this.service.updateProduct(product);
		
	}
	@DeleteMapping("/deleteProduct/{productId}")
	public boolean f5(@PathVariable(name="productId") int id) {
		return this.service.deleteProduct(id);
	}
	@GetMapping("/findProductByCategoryId/{categoryId}")
	public Products findProductByCategoryId(@PathVariable(name="categoryId") String id) {
		return this.service.findProductByCategoryId(id);
	}
	

}
