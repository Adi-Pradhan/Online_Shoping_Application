package com.zensar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.bean.Admin;
import com.zensar.repository.AdminRepo;

@Service
public class AdmiService {
	@Autowired
	AdminRepo adminRepo;
	
	public Admin addAdmin(Admin admin) {
		return this.adminRepo.save(admin);
	}
	public Admin updateAdmin(Admin admin) {
		return this.adminRepo.save(admin);
	}
	public boolean removeAdmin(Admin admin) {
		boolean result=false;
		try {
			this.adminRepo.delete(admin);
			result=true;
		}
		catch(Exception e) {
			e.printStackTrace();
			result=false;
		}
		return result;
	}
	public Admin viewAdminById(int AdminId) {
		Optional<Admin> result= this.adminRepo.findById(AdminId);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}
	
	public List<Admin> viewAllCustomer(){
		return this.adminRepo.findAll();
	}
}
