package com.zensar.db;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.bean.Order;

@Repository
public interface OrderDAO extends JpaRepository<Order, Integer>{


	



	}
