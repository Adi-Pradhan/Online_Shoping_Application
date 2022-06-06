package com.zensar.rest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.ast.Or;
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

import com.zensar.bean.Address;
import com.zensar.bean.Cart;
import com.zensar.bean.Customer;
import com.zensar.bean.Order;
import com.zensar.bean.OrderRequest;
import com.zensar.bean.Product;
import com.zensar.service.OrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

	@Autowired
	OrderService service;

	@PostMapping("/addOrder")
	public Order addOrder(@RequestBody OrderRequest request) throws NullPointerException {
		Order order = new Order();

		order.setOrderDate(request.getOrderDate());
		order.setOrderStatus(request.getOrderStatus());

		int customerId = request.getCustomerId();

		RestTemplate restTemplate = new RestTemplate();
		try {
			Customer customer;
			String url = "http://localhost:5001/customer/viewCustomerById/" + customerId;

			customer = restTemplate.getForObject(url, Customer.class);
			if (customer != null) {
				order.setCustomer(customer);
			}
			customer.setAddressId(request.getAddressId());
			int addressId = request.getAddressId();
			try {
				Address address;
				String url1 = "http://localhost:5002/address/viewAddressById/" + addressId;

				address = restTemplate.getForObject(url1, Address.class);
				if (address != null) {
					order.setAddress(address);
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
			}

		} catch (NullPointerException e) {
			e.printStackTrace();
		}

//		try {
//			int cartId = request.getCartId();
//			Cart cart;
//			String url = "http://localhost:5005/cart/" + cartId;
//			cart = restTemplate.getForObject(url, Cart.class);
//			if (cart != null) {
//				order.setProduct(cart.getProduct());
//			}
//		} catch (NullPointerException e) {
//			e.printStackTrace();
//		}
		int productId = request.getProductId();
		try {
			Product product = null;
			String url1 = "http://localhost:5003/product/findByProductsId/" + productId;

			product = restTemplate.getForObject(url1, Product.class);
			if (product != null) {
				order.setProduct(product);
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		this.service.addOrder(order);
		return order;
	}

	@PutMapping("/updateOrder/{orderid}")
	public Order updateOrder(@RequestBody OrderRequest request,@PathVariable(name="orderid")int orderId) {
		Order order = this.service.viewAllOrderByOrderId(orderId);
	
		
		order.setOrderDate(request.getOrderDate()); 
		order.setOrderStatus(request.getOrderStatus());

		int customerId = request.getCustomerId();

		RestTemplate restTemplate = new RestTemplate();
		
		Customer customer;
		String url = "http://localhost:5001/customer/viewCustomerById/" + customerId;
		
		customer = restTemplate.getForObject(url, Customer.class);
		if(customer!=null) {
	//	order.setCustomer(customer);
		}
		int addressId =1;
				
		Address address;
		String url1 = "http://localhost:5002/address/viewAddressById/" + addressId;
				
		address = restTemplate.getForObject(url1, Address.class);
		if(address!=null) {
		order.setAddress(address);
		}

		
		try {
			int productId = request.getProductId();

	            Product product=null;

	            String url2 = "http://localhost:5003/product/findByProductsId/" + productId;
	            product = restTemplate.getForObject(url2, Product.class);

	            if (product != null) {
	            	System.out.println(product);
	                order.setProduct(product);

	            }

	        } catch (NullPointerException e) {

	        e.printStackTrace();

	        }

	       

	         this.service.addOrder(order);

	         return order;
		
	}

	@DeleteMapping("/deleteOrder/{orderid}")
	public Order removeOrder(@PathVariable(name = "orderid") int orderId) {
		Order order = this.service.viewAllOrderByOrderId(orderId);
		return this.service.removeOrder(order);
	}

	@GetMapping("/getAllorder")
	public List<Order> getAllOrders() {
		return this.service.getAllOrder();
	}

	@GetMapping("/viewOrder/{orderid}")
	public Order viewOrder(@PathVariable(name = "orderid") int orderId) {
		Order order = this.service.viewAllOrderByOrderId(orderId);
		return this.service.viewOrder(order);
	}

	@GetMapping("/viewOrderByDate/{ldate}")
	public List<Order> viewAllOrders(@PathVariable(name = "ldate") LocalDate date) {
		return this.service.viewAllOrders(date);
	}

	@GetMapping("/viewOrderByLocation/{location}")
	public List<Order> viewOrdersByLocation(@PathVariable(name = "location") String loc) {
		return this.service.viewAllOrdersByLocation(loc);
	}

	@GetMapping("/viewOrderByCustomerId/{customerid}")
	public List<Order> viewOrdersByUserId(@PathVariable(name = "customerid") int customerid) {

		Order order = new Order();
		List<Order> orders = this.service.getAllOrder();
		List<Order> newOrder = new ArrayList<>();
		RestTemplate restTemplate = new RestTemplate();

		Customer customer;
		String url = "http://localhost:5001/customer/viewCustomerById/" + customerid;
		customer = restTemplate.getForObject(url, Customer.class);

		for (Order order2 : orders) {

			order2.setOrderId(order2.getOrderId());
			order2.setOrderDate(order2.getOrderDate());
			order2.setOrderStatus(order2.getOrderStatus());
			try {
				Address address;
				int addressId = order2.getAddress().getAddressId();
				String url1 = "http://localhost:5002/address/viewAddressById/" + addressId;

				address = restTemplate.getForObject(url1, Address.class);
				if (address != null) {
					order2.setAddress(address);
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
			}

			try {
				Product product;
				int productId = order2.getProduct().getProductId();
				String url1 = "http://localhost:5003/product/findByProductsId/" + productId;

				product = restTemplate.getForObject(url1, Product.class);
				if (product != null) {
					order2.setProduct(product);
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
			}

			if (order2.getCustomer().getCustomerId() == customerid) {
				order2.setCustomer(customer);

				newOrder.add(order2);

			}
		}

		return this.service.viewAllOrdersByCustomerId(newOrder);
	}

}
