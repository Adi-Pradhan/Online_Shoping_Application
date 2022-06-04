package com.zensar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.bean.CustomerUser;
import com.zensar.repository.CustomerUserRepo;
@Service
public class CustomerUserServices{
	@Autowired
	CustomerUserRepo customerUserRepo;
	
	public CustomerUser addCustomerUser(CustomerUser customerUser) {
		return this.customerUserRepo.save(customerUser);
	}
	public CustomerUser updateCustomerUser(CustomerUser customerUser) {
		return this.customerUserRepo.save(customerUser);
	}
	public boolean removeCustomerUser(CustomerUser customerUser) {
		boolean result=false;
		try {
			this.customerUserRepo.delete(customerUser);
			result=true;
		}
		catch(Exception e) {
			e.printStackTrace();
			result=false;
		}
		return result;
	}
	public CustomerUser viewAdminById(int CustomerUserId) {
		Optional<CustomerUser> result= this.customerUserRepo.findById(CustomerUserId);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}
	
	public List<CustomerUser> viewAllCustomer(){
		return this.customerUserRepo.findAll();
	}
}
