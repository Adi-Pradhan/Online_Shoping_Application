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


import com.zensar.bean.Admin;
import com.zensar.services.AdmiService;

@RestController
public class AdminController {
	@Autowired
	AdmiService admiService;
	
	
	@PostMapping("/addAdmin")
	public Admin addAdmin(@RequestBody  Admin admin) {
		
		return  this.admiService.addAdmin(admin);
		 
	}
	@PutMapping("/updateAdmin/")
	public Admin updateAdmin(Admin admin) {
		return this.admiService.updateAdmin(admin);
	}
	@DeleteMapping("/removeAdmin")
	public boolean removeAdmin(@RequestBody Admin admin) {
		return this.admiService.removeAdmin(admin);
	}
	@GetMapping("/viewAdminById/{AdminId}")
	public Admin getAdmin(@PathVariable("AdminId") int AdminId) {
		return this.admiService.viewAdminById(AdminId);
	}
	@GetMapping("/viewAllAdmin")
	public List<Admin> getAdmin() {
		return this.admiService.viewAllCustomer();
	}
}
