package com.zensar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zensar.bean.Cart;
import com.zensar.bean.Customer;
import com.zensar.db.CartDAO;

@Service
public class CartService {
	
		@Autowired
		CartDAO dao; 

		public Cart addProductToCart(Cart cart) {
			return this.dao.save(cart);
		}
		
		public boolean removeProductFromCart(int productId) {
			boolean result = false;
			Optional<Cart> cart= this.dao.findById(productId);
			try {
				this.dao.deleteById(productId);
				result = true;
			} catch (Exception e) {
				e.printStackTrace();
				result = false;
			}
			return result;
		}
		
		public Cart updateProductQuantity(Cart cart) {
			return this.dao.save(cart);
		}
		
		public boolean removeAllProducts() {
			boolean result = false;
			try {
				this.dao.deleteAll();
				result = true;
			} catch (Exception e) {
				e.printStackTrace();
				result = false;
			}
			return result;
		}

		public List<Cart> getAllCartProducts(Cart cart) {
			return this.dao.findAll();
		}
		
		public Cart viewCartById(int customerId) {
			Optional<Cart> result= this.dao.findById(customerId);
			if(result.isPresent()) {
			return result.get();
			}
			return null;
			}

}
