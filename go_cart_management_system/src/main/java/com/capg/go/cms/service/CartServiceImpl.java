package com.capg.go.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.go.cms.dao.CartDao;
import com.capg.go.cms.exception.CartException;
import com.capg.go.cms.model.Cart;
import com.capg.go.cms.model.Product;

/****************************************************************************************************************************
- File Name        : CartServiceImpl.java 
- Author           : Srinidhi 
- Creation Date    : 21/09/2020
- Modified Date    : 24/08/2020
****************************************************************************************************************************/

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartDao cartDao;
	
	/****************************************************************************************************************************
	  - Method Name         : viewAllCarts
	  - Author              : Srinidhi 
	  - Creation Date       : 21/09/2020
	  - Description         : Method to get List of all Carts
	 ****************************************************************************************************************************/
	
	@Override
	public List<Cart> viewAllCarts() throws CartException {
		List<Cart> cartList = cartDao.viewAllCarts();
		if (cartList.isEmpty()) {
			throw new CartException("No Records Found");
		}

		return cartList;
	}

	/****************************************************************************************************************************
	  - Method Name         : addProductToCart
	  - Author              : Srinidhi
	  - Creation Date       : 21/09/2020
	  - Description         : Method to add Product to cart
	 ****************************************************************************************************************************/
	
	@Override
	public Cart addProductToCart(Cart cart) throws CartException {

		Product product = cartDao.findProductById(cart.getProduct().getProductId());
		if (product == null) {
			throw new CartException("Product Does not Exist");
		}

		return cartDao.addProductToCart(cart);
	}


	/****************************************************************************************************************************
	  - Method Name         : findCartByCartId
	  - Author              : Srinidhi 
	  - Creation Date       : 21/09/2020
	  - Description         : Method to get cart details
	 ****************************************************************************************************************************/

	@Override
	public Cart findCartByCartId(int cartId) throws CartException {

		return cartDao.findCartByCartId(cartId);
	}
	
	/****************************************************************************************************************************
	  - Method Name         : deleteCartByCartId
	  - Author              : Srinidhi 
	  - Creation Date       : 21/09/2020
	  - Description         : Method to delete cart
	 ****************************************************************************************************************************/
	
	@Override
	public Cart deleteCartByCartId(int cartId) throws CartException {
		Cart cart = cartDao.findCartByCartId(cartId);

		if (cart == null) {
			throw new CartException("No Cart Found");
		}

		return cartDao.deleteCartByCartId(cartId);
	}

	/****************************************************************************************************************************
	  - Method Name         : updateCart
	  - Author              : Srinidhi 
	  - Creation Date       : 21/09/2020
	  - Description         : Method to Update Cart
	 ****************************************************************************************************************************/
	
	@Override
	public Cart updateCart(Cart cart) throws CartException {

		if (cartDao.findCartByCartId(cart.getCartId()) != null) {
			Product product = cartDao.findProductById(cart.getProduct().getProductId());
			cart.setProduct(product);

			cartDao.updateCart(cart);
		} else {
			throw new CartException("Product does not exist");
		}
		return cart;

	}

	/****************************************************************************************************************************
	  - Method Name         : viewAllProducts
	  - Author              : Srinidhi 
	  - Creation Date       : 21/09/2020
	  - Description         : Method to get List of all Products
	 ****************************************************************************************************************************/
	
	@Override
	public List<Product> viewAllProducts() throws CartException {
		List<Product> listOfAllProducts = cartDao.viewAllProducts();
		if (listOfAllProducts.isEmpty()) {
			throw new CartException("No Records Found");
		}

		return listOfAllProducts;

	}
	/****************************************************************************************************************************
	  - Method Name         : findProductById
	  - Author              : Srinidhi 
	  - Creation Date       : 21/09/2020
	  - Description         : Method to get product details
	 ****************************************************************************************************************************/
	
	@Override
	public Product findProductById(int productId) throws CartException {
		Product product = cartDao.findProductById(productId);
		if (product == null) {
			throw new CartException("No Product found with id " + productId);
		}
		return cartDao.findProductById(productId);
	}

}
