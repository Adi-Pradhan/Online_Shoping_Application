package com.zensar.test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zensar.DAO.ProductsDAo;
import com.zensar.model.Products;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class MiniProjectApplicationTests {
	@Autowired
	ProductsDAo dao;

	@Test
	@Order(1)
	public void testCreate() {
		Products product = new Products();
		product.setProductId(1); 
		product.setProductName("Mobile"); 
		product.setPrice(25000.00);
		product.setColor("Black"); 
		product.setDimensions("one by four"); 
		product.setSpecification("1 TB ram"); 
		product.setManufacturer("Samsung"); 
		product.setCategoryId("1"); 

		dao.save(product);
		assertNotNull(dao.findById(1).get());
	}
	
	@Test
	@Order(2)
	public void testReadAll() {
		List<Products> list=dao.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	
	@Test
	@Order(3)
	public void testSingleProduct() {
		Products products= dao.findById(1).get();
		assertEquals(25000.00,products.getPrice());
	}
	
	@Test
	@Order(4)
	public void testUpdate() {
		Products products= dao.findById(1).get();
		products.setPrice(15000.00);
		dao.save(products);
		assertNotEquals(25000.00,dao.findById(1).get().getPrice());
		assertEquals(15000.00,dao.findById(1).get().getPrice());
	}
	
	@Test
	@Order(5)
	public void testSingleProductByName() {
		Products products= dao.findByProductName("Mobile");
		assertEquals("Mobile",products.getProductName());
	}
	
	
	@Test
	@Order(6)
	public void testDelete() {
		dao.deleteById(1);
		assertThat(dao.existsById(1)).isFalse();
	}
}
