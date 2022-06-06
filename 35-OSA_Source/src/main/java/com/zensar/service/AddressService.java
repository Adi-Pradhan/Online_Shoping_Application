package com.zensar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.address.bean.Address;

import com.zensar.repository.IAddressRepository;

@Service
public class AddressService {
	@Autowired
	IAddressRepository addressRepository;
	
	public Address addAddress(Address address) {
		return this.addressRepository.save(address);
	}
	public Address updateAddress(Address address) {
		return this.addressRepository.save(address);
	}
	public boolean removeAddress(Address address) {
		boolean result=false;
		try {
			this.addressRepository.delete(address);
			result=true;
		}
		catch(Exception e) {
			e.printStackTrace();
			result=false;
		}
		return result;
	}
	public Address viewAddressById(int AddressId) {
		Optional<Address> result= this.addressRepository.findById(AddressId);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}
	
	public List<Address> viewAllAddress(){
		return this.addressRepository.findAll();
	}
}
