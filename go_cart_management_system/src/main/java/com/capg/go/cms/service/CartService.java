package com.capg.go.cms.service;

import java.util.List;

import com.capg.go.cms.exception.CartException;
import com.capg.go.cms.model.Cart;
import com.capg.go.cms.model.Product;

/****************************************************************************************************************************
- File Name        : CartService.java 
- Author           : Srinidhi 
- Creation Date    : 21/09/2020
- Modified Date    : 22/09/2020
****************************************************************************************************************************/

public interface CartService {

	public List<Cart> viewAllCarts() throws CartException;

	public Cart findCartByCartId(int cartId) throws CartException;

	public Cart addProductToCart(Cart cart) throws CartException;

	public Cart deleteCartByCartId(int cartId) throws CartException;

	public Cart updateCart(Cart cart) throws CartException;
	
	public Product findProductById(int productId) throws CartException;
	
	public List <Product> viewAllProducts() throws CartException;


}
