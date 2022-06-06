package com.zensar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.zensar.DAO.CategoryDAO;
import com.zensar.model.Category;


@Service
public class CategoryService {
	@Autowired
	CategoryDAO dao;
	
	public Category addCategory(Category category) {
		return dao.save(category);
	}
	public List<Category> getAllCategories(){
		return this.dao.findAll();
	}
	public Category findCategoryById(String id) {
		Optional<Category> optional=this.dao.findById(id);
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}

}
