package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.bean.CustomerUser;
@Repository
public interface CustomerUserRepo  extends JpaRepository<CustomerUser, Integer>{

}
