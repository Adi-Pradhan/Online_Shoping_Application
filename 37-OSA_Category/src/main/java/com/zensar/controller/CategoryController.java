package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.model.Category;

import com.zensar.service.CategoryService;
@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	CategoryService service;
	@PostMapping("/add")
	public Category addProduct(@RequestBody Category category) {
		return service.addCategory(category);
	}
	@GetMapping("/categoriesList")
	public List<Category> getCategoriesList() {
		return this.service.getAllCategories();
	}
	@GetMapping("/findByCategoryId/{cid}")
	public Category find(@PathVariable(name="cid") String id) {
		return this.service.findCategoryById(id);
	}

}
