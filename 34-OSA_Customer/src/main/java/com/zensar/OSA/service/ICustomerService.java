package com.zensar.OSA.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.OSA.bean.Customer;
import com.zensar.OSA.repository.ICustomerRepository;
@Service
public class ICustomerService {

	@Autowired
	ICustomerRepository iCustomerRepository;
	
	public Customer addCustomer(Customer customer) {
		return this.iCustomerRepository.save(customer);
	}
	public Customer updateCustomer(Customer customer) {
		return this.iCustomerRepository.save(customer);
	}
	public boolean removeCustomer(Customer customer) {
		boolean result=false;
		try {
			this.iCustomerRepository.delete(customer);
			result=true;
		}
		catch(Exception e) {
			e.printStackTrace();
			result=false;
		}
		return result;
	}
	public Customer viewCustomerById(int customerId) {
		Optional<Customer> result= this.iCustomerRepository.findById(customerId);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}
	
	public List<Customer> viewAllCustomer(){
		return this.iCustomerRepository.findAll();
	}
}
