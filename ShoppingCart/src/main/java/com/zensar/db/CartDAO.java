package com.zensar.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zensar.bean.Cart;
import com.zensar.bean.Customer;
import com.zensar.bean.Product;

@Repository
public interface CartDAO extends JpaRepository<Cart, Integer> {

	public List<Cart> findCartByCustomer(Customer customer);
	
	public  Cart findByCustomer(Customer customer);
}
