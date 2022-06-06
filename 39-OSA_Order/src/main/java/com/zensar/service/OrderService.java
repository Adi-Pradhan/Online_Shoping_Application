package com.zensar.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.bean.Order;
import com.zensar.db.OrderDAO;

@Service
public class OrderService {

	@Autowired
	OrderDAO dao;

	public Order addOrder(Order order) {
		return this.dao.save(order);
	}

	public Order updateOrder(Order order) {
		return this.dao.save(order);
	}

	public Order removeOrder(Order order) {
		try {
			this.dao.delete(order);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return order;
	}

	public Order viewOrder(Order order) {
		int id = order.getOrderId();
		String oId=Integer.toString(id);
		Optional<Order> optional = this.dao.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	
	public List<Order> getAllOrder() {
		return this.dao.findAll();
	}
	
	public List<Order> viewAllOrders(LocalDate date){
		List<Order> orders = this.getAllOrder();
		List<Order> orderBydate = new ArrayList<>();
		for (Order order : orders) {
			if(order.getOrderDate().equals(date)) {
				orderBydate.add(order);
			}
		}
		
		return orderBydate;
	}
	
	public List<Order> viewAllOrdersByLocation(String loc){
		List<Order> orders = this.getAllOrder();
		List<Order> orderBylocation = new ArrayList<>();
		for (Order order : orders) {
			if(order.getAddress().getCity().equals(loc)) {
				orderBylocation.add(order);
			}
		}
		
		return orderBylocation;
	}
	
	public List<Order> viewAllOrdersByCustomerId(List<Order> order){
		return order;
	}
	
	public Order viewAllOrderByOrderId(int orderid){
		List<Order> orders = this.getAllOrder();
		for (Order order : orders) {
			if(order.getOrderId()==(orderid)) {
				return order;
			}
		}
		return null;
	}
	

}
