package com.zensar.OSA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.OSA.bean.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer>{

	
}
