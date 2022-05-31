package com.zensar.rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zensar.bean.Cart;
import com.zensar.bean.Customer;
import com.zensar.bean.Order;
import com.zensar.bean.OrderRequest;
import com.zensar.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService service;
	
	@PostMapping("/addOrder")
	public Order addOrder(@RequestBody OrderRequest request) throws NullPointerException{		
		Order order = new Order();
		order.setOrderId(request.getOrderId());
		order.setOrderDate(request.getOrderDate());
		order.setOrderStatus(request.getOrderStatus());
		

		String customerId = request.getCustomerId();

		RestTemplate restTemplate = new RestTemplate();
		try {
		Customer customer;
		String url = "http://localhost:9052/getCustomerById/" + customerId;
		
		customer = restTemplate.getForObject(url, Customer.class);
		if(customer!=null) {
		order.setCustomer(customer);
		order.setAddress(customer.getAddress());
		}
		
		
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		try {	
		int cartId = request.getCartId();
		Cart cart;
		String url = "http://localhost:9052/getCartById/" + cartId;
		cart = restTemplate.getForObject(url, Cart.class);
		if(cart!=null) {
		order.setProduct(cart.getProduct());
		}
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		return order;
	}
	
	@PutMapping("/updateOrder/{orderid}")
	public Order updateOrder(@RequestBody OrderRequest request,@PathVariable(name="orderid")int orderId) {
		Order order = this.service.viewAllOrderByOrderId(orderId);
	
		order.setOrderId(request.getOrderId());
		order.setOrderDate(request.getOrderDate());
		order.setOrderStatus(request.getOrderStatus());

		String customerId = request.getCustomerId();

		RestTemplate restTemplate = new RestTemplate();
		try {
		Customer customer;
		String url = "http://localhost:9052/getCustomerById/" + customerId;
		
		customer = restTemplate.getForObject(url, Customer.class);
		if(customer!=null) {
		order.setCustomer(customer);
		order.setAddress(customer.getAddress());
		}
		
		
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		
		try {
		int cartId = request.getCartId();
		Cart cart;
		String url = "http://localhost:9052/getCartById/" + cartId;
		cart = restTemplate.getForObject(url, Cart.class);
		if(cart!=null) {
		order.setProduct(cart.getProduct());
		}
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		return order;
	}
	
	@DeleteMapping("/deleteOrder/{orderid}")
	public Order removeOrder(@PathVariable (name="orderid") int orderId) {
		Order order = this.service.viewAllOrderByOrderId(orderId);
		return this.service.removeOrder(order);
	}
	
	@GetMapping("/getAllorder")
	public List<Order> getAllOrder(){
		return this.service.getAllOrder();
	}
	
	@GetMapping("/viewOrder/{orderid}")
	public Order viewOrder(@PathVariable (name="orderid") int orderId) {
		Order order = this.service.viewAllOrderByOrderId(orderId);
		return this.service.viewOrder(order);
	}
	
	@GetMapping("/viewOrderByDate/{ldate}")
	public List<Order> viewAllOrders(@PathVariable(name="ldate") LocalDate date){
		return this.service.viewAllOrders(date);
	}
	
	@GetMapping("/viewOrderByLocation/{location}")
	public List<Order> viewOrdersByLocation(@PathVariable(name="location") String loc){
		return this.service.viewAllOrdersByLocation(loc);
	}
	
	@GetMapping("/viewOrderByUserId/{userid}")
	public List<Order> viewOrdersByUserId(@PathVariable(name="userid") int userId){
		return this.service.viewAllOrdersByUserId(userId);
	}
	
	
	
	
}
