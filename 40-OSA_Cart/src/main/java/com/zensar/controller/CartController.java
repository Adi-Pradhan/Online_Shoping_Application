package com.zensar.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:4200")
public class CartController{

	@Autowired
	CartService service;
	
	@PostMapping("/addToCart")
	public Cart addToCart(@RequestBody CartRequest request) throws NullPointerException{
		Cart cart = new Cart();
		//cart.setCartId(request.getId());
	int customerId =1;//request.getCustomerId();
	
	RestTemplate restTemplate = new RestTemplate();
	Customer customer;
	try {
	String url = "http://localhost:5001/customer/viewCustomerById/" + customerId;

	customer = restTemplate.getForObject(url, Customer.class);
	if(customer!=null) {
		cart.setCustomer(customer);
	}
	}catch(NullPointerException e) {
	e.printStackTrace();
	}

	int productId =request.getProductId();

	try {
	Product product=null;
	String url = "http://localhost:5003/product/findByProductsId/" + productId;
	product = restTemplate.getForObject(url, Product.class);
	if(cart!=null) {
	    cart.setProduct(product);
	}
	}catch(NullPointerException e) {
	e.printStackTrace();
	}
	cart.setQuantity(1);
	return this.service.addProductToCart(cart);
	}

	@DeleteMapping("/removeProductById/{cid}")
	public boolean removeProductFromCart(@PathVariable(name="cid") int id) {
		System.out.println(id);
		boolean r= this.service.removeProductFromCart(id);
		System.out.println(r);
		return r;
	}

	@PutMapping("/updateCart/{id}")
	public Cart updateOrder(@RequestBody CartRequest request,@PathVariable(name="id")int id) {
		Cart cart = this.service.viewCartById(id);
	   int customerId =1;//request.getCustomerId();
	
	RestTemplate restTemplate = new RestTemplate();
	Customer customer;
	try {
	String url = "http://localhost:5001/customer/viewCustomerById/" + customerId;

	customer = restTemplate.getForObject(url, Customer.class);
	if(customer!=null) {
		cart.setCustomer(customer);
	}
	}catch(NullPointerException e) {
	e.printStackTrace();
	}

	int productId =request.getProductId();

	try {
	Product product=null;
	String url = "http://localhost:5003/product/findByProductsId/" + productId;
	product = restTemplate.getForObject(url, Product.class);
	if(cart!=null) {
	    cart.setProduct(product);
	}
	}catch(NullPointerException e) {
	e.printStackTrace();
	}
	int q=request.getQuantity();
	cart.setQuantity(q);
	 this.service.updateProductQuantity(cart);
	 System.out.println(cart);
	 return cart;
	}
	
	@DeleteMapping("/removeAll")
	public boolean removeAllProducts() {
		return this.service.removeAllProducts();
	}
	
	@GetMapping("/allProducts")
	public List<Cart> getAllCartProducts(Cart cart){
		
		List<Cart> cartList=new ArrayList<>();
		cartList.addAll(this.service.getAllCartProducts(cart)); 
		
		RestTemplate restTemplate = new RestTemplate();
		Customer customer;
		
		for(Cart c : cartList)
		{
		try {
		String url = "http://localhost:5001/customer/viewCustomerById/" + c.getCustomer().getCustomerId();

		customer = restTemplate.getForObject(url, Customer.class);
		if(c!=null) {
			c.setCustomer(customer);
		}
		}catch(NullPointerException e) {
		e.printStackTrace();
		}
		try {
			Product product=null;
			String url = "http://localhost:5003/product/findByProductsId/" + c.getProduct().getProductId();
			product = restTemplate.getForObject(url, Product.class);
			if(c!=null) {
			    c.setProduct(product);
			}
			}catch(NullPointerException e) {
			e.printStackTrace();
			}
		}
		//System.out.println(cartList);
		 this.service.getAllCartProducts(cart);
		 return cartList;
	}

}
