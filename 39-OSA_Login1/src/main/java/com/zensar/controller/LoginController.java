package com.zensar.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.zensar.bean.Admin;
import com.zensar.bean.Customer;

@RestController
public class LoginController {

	RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping("/validate/{id}/{key}")
	public boolean validateRole(@PathVariable(name="id")int id,@PathVariable(name="key")String name) {

	String [] credentials=name.split("&");
	
	
	if(id==1) {
		List<Admin> allAdmins;
		String url = "http://localhost:5001/viewAllAdmin" ;
		allAdmins= (List<Admin>) restTemplate.getForObject(url, Admin.class);
		System.out.println(allAdmins);
	for (Admin admin : allAdmins) {
	if(admin.getUserName().equalsIgnoreCase(credentials[0])) {
	if(admin.getPassword().equalsIgnoreCase(credentials[1]))
	return true;
	}

	}

	}
	else if(id==2) {
		List<Customer> allCustomers;
		String url = "http://localhost:5001/viewAllAdmin" ;
		allCustomers= (List<Customer>) restTemplate.getForObject(url, Customer.class);
	
	for (Customer customer : allCustomers) {
		int A = Integer.parseInt(credentials[0]);	
	if(customer.getCustomerId()==A) {
	if(customer.getFirstName().equalsIgnoreCase(credentials[1]))
	return true;
	}
  }
	}
	else
	return false;

	return false;
	}
}
