package com.zensar.controller;

import java.util.List;

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

import com.zensar.address.bean.Address;
import com.zensar.service.AddressService;


@RestController
@RequestMapping("/address")
@CrossOrigin(origins = "http://localhost:4200")
public class AddressController {
	@Autowired
	AddressService addressService;
	
	@PostMapping("/addAddress")
	public Address addAddress(@RequestBody  Address address) {
		return this.addressService.addAddress(address);
	}
	@PutMapping("/updateAddress")
	public Address updateAddress(@RequestBody Address address) {
		return this.addressService.updateAddress(address);
	}
	@DeleteMapping("/removeAddress")
	public boolean removeAddress(@RequestBody Address address) {
		return this.addressService.removeAddress(address);
	}
	@GetMapping("/viewAddressById/{addressId}")
	public Address getCustomer(@PathVariable("addressId") int addressId) {
		return this.addressService.viewAddressById(addressId);
	}
	@GetMapping("/viewAllAddress")
	public List<Address> getCustomer() {
		return this.addressService.viewAllAddress();
	}
}
