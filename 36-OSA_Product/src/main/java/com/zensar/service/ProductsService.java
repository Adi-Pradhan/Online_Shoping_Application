package com.zensar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.DAO.ProductsDAo;

import com.zensar.model.Products;


@Service
public class ProductsService {
	@Autowired
	ProductsDAo dao;
	

	public Products addProducts(Products product) {
		return dao.save(product);
	}
	
	public List<Products> getAllProducts(){
		return this.dao.findAll();
	}
	public Products findProductById(int id) {
		Optional<Products> optional=this.dao.findById(id);
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}
	public Products findProductByName(String productName) {
		Products product=this.dao.findByProductName(productName);
	    return product;
	}
	public Products updateProduct(Products product) {
		return this.dao.save(product);
	}
	public boolean deleteProduct(int id) {
		 this.dao.deleteById(id);
		 return true;
	}
	public Products findProductByCategoryId(String categoryId) {
		Products product=this.dao.findByCategoryId(categoryId);
	    return product;
	}



}
