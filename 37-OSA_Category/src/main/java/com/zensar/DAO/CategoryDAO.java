package com.zensar.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.model.Category;
@Repository
public interface CategoryDAO extends JpaRepository<Category, String> {

	

}
