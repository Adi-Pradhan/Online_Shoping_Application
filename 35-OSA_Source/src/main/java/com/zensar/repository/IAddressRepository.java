package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.address.bean.Address;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Integer>{
										
}
