package com.zensar.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.zensar.bean.Admin;
import com.zensar.bean.CustomerUser;

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
		List<CustomerUser> allCustomers;
		String url = "http://localhost:5007/viewAllCustomerUser" ;
		allCustomers= (List<CustomerUser>) restTemplate.getForObject(url, CustomerUser.class);
	
	for (CustomerUser customer : allCustomers) {
		int A = Integer.parseInt(credentials[0]);	
	if(customer.getUserName()==A) {
	if(customer.getPassword().equalsIgnoreCase(credentials[1]))
	return true;
	}
  }
	}
	else
	return false;

	return false;
	}
}
