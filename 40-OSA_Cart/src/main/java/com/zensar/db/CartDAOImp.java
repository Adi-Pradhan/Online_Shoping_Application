package com.zensar.db;

import java.util.ArrayList;
import java.util.List;

import com.zensar.bean.Cart;

public abstract class CartDAOImp implements CartDAO {

	public List<Cart> findCartByCustomerId(Cart cart,int customerId){
		List<Cart> cartList=new ArrayList<>();
		
		return cartList;
	}
}
