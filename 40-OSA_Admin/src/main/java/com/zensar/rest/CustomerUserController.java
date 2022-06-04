package com.zensar.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.bean.CustomerUser;
import com.zensar.services.CustomerUserServices;
@RestController
public class CustomerUserController {
	@Autowired
	CustomerUserServices customerUserServices;
	
	@PostMapping("/addCustomerUser")
	public CustomerUser addCustomerUser(@RequestBody  CustomerUser customerUser) {
		
		return  this.customerUserServices.addCustomerUser(customerUser);
		 
	}
	@PutMapping("/updateCustomerUser/")
	public CustomerUser updateCustomerUser(CustomerUser customerUser) {
		return this.customerUserServices.updateCustomerUser(customerUser);
	}
	@DeleteMapping("/removeCustomerUser")
	public boolean removeCustomerUser(@RequestBody CustomerUser customerUser) {
		return this.customerUserServices.removeCustomerUser(customerUser);
	}
	@GetMapping("/viewCustomerUserById/{CustomerUserId}")
	public CustomerUser getCustomerUser(@PathVariable("CustomerUserId") int CustomerUserId) {
		return this.customerUserServices.viewAdminById(CustomerUserId);
	}
	@GetMapping("/viewAllCustomerUser")
	public List<CustomerUser> getAllCustomerUser() {
		return this.customerUserServices.viewAllCustomer();
	}
}
