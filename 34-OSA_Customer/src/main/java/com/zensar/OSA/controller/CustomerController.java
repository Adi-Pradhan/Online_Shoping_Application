package com.zensar.OSA.controller;

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

import com.zensar.OSA.bean.Address;
import com.zensar.OSA.bean.Customer;
import com.zensar.OSA.bean.CustomerRequest;
import com.zensar.OSA.service.ICustomerService;



@RestController
public class CustomerController {

	@Autowired
	ICustomerService iLoginService;
	
	RestTemplate restTemplate = new RestTemplate();
	@PostMapping("/addCustomer")
	public Customer addCustomer(@RequestBody  CustomerRequest request) {
		Customer customer=new Customer();
		customer.setFirstName(request.getFirstName());
		customer.setLastName(request.getLastName());
		customer.setMobileNumber(request.getMobileNumber());
		customer.setEmail(request.getEmail());
		customer.setCustomerId(request.getCustomerReqId());
		
		RestTemplate restTemplate = new RestTemplate();
		Address address;
		String url = "http://localhost:5002/viewAddressById/" + request.getCustomerReqId();
		address= restTemplate.getForObject(url, Address.class);
		
		customer.setAddress(address);
		return this.iLoginService.addCustomer(customer);
	}
	@PutMapping("/updateCustomer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return this.iLoginService.updateCustomer(customer);
	}
	@DeleteMapping("/removeCustomer")
	public boolean removeCustomer(@RequestBody Customer customer) {
		return this.iLoginService.removeCustomer(customer);
	}
	@GetMapping("/viewCustomerById/{customerId}")
	public Customer getCustomer(@PathVariable("customerId") int customerId) {
		return this.iLoginService.viewCustomerById(customerId);
	}
	@GetMapping("/viewAllCustomer")
	public List<Customer> getCustomer() {
		return this.iLoginService.viewAllCustomer();
	}
}
