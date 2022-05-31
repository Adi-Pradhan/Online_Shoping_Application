package com.zensar.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.model.Products;
@Repository
public interface ProductsDAo extends JpaRepository<Products, Integer>{

	

	Products findByProductName(String productName);

	Products findByCategoryId(String categoryId);

}
