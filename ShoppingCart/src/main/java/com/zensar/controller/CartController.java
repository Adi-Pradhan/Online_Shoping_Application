package com.zensar.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zensar.bean.Cart;
import com.zensar.bean.CartRequest;
import com.zensar.bean.Customer;
import com.zensar.bean.Product;
import com.zensar.service.CartService;



@RestController
@RequestMapping("/cart")
public class CartController{

	@Autowired
	CartService service;
	
	@PostMapping("/addToCart")
	public Cart addToCart(@RequestBody CartRequest request) throws NullPointerException{
		Cart cart = new Cart();
		cart.setCartId(request.getId());
	
	String customerId = request.getCustomerId();
	
	RestTemplate restTemplate = new RestTemplate();
	Customer customer;
	try {
	String url = "http://localhost:5001/viewCustomerById/" + customerId;

	customer = restTemplate.getForObject(url, Customer.class);
	if(customer!=null) {
		cart.setCustomer(customer);
	}

	}catch(NullPointerException e) {
	e.printStackTrace();
	}

	String productId = request.getProductId();

	try {
	Product product=null;
	String url = "http://localhost:5003/findByProductsId/" + productId;
	product = restTemplate.getForObject(url, Product.class);
	if(cart!=null) {
	    cart.setProduct(product);
	}
	}catch(NullPointerException e) {
	e.printStackTrace();
	}
	return cart;
	}

	@DeleteMapping("/cart/remove/{pid}")
	public boolean removeProductFromCart(@PathVariable(name="pid") int id) {
		return this.service.removeProductFromCart(id);
	}

	@PutMapping("/cart/updateCart/{id}/{quantity}")
	public Cart updateOrder(@PathVariable(name="id")int id,@PathVariable(name="quantity")int quantity) {
	Cart cart = new Cart();
	cart = this.service.viewCartById(id);
	cart.setQuantity(quantity);
	return cart;
	}
	
	@DeleteMapping("/cart/removeAll")
	public boolean removeAllProducts() {
		return this.service.removeAllProducts();
	}
	
	@GetMapping(value="/cart")
	public List<Cart> getAllCartProducts(Customer customer){
		return this.service.getAllCartProducts(customer);
	}

}
