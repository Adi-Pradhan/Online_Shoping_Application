package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.bean.Admin;
@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{

}
