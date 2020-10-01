package com.capg.go.cms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capg.go.cms.exception.CartException;
import com.capg.go.cms.model.Cart;
import com.capg.go.cms.model.Product;

/****************************************************************************************************************************
- File Name        : CartDaoImpl.java 
- Author           : Srinidhi
- Creation Date    : 21/09/2020
- Description      : CartDaoImpl class is responsible for accessing the data through database
****************************************************************************************************************************/

@Repository
@Transactional
public class CartDaoImpl implements CartDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Cart> viewAllCarts() throws CartException {
		String qry = "select c from Cart c";
		TypedQuery<Cart> query = entityManager.createQuery(qry, Cart.class);

		return query.getResultList();
	}

	@Override
	public Cart addProductToCart(Cart cart) throws CartException {

		double amt = cart.getQuantity() * cart.getProduct().getPrice();

		cart.setTotalPrice(amt);

		entityManager.persist(cart);

		return cart;
	}

	@Override
	public Cart findCartByCartId(int cartId) throws CartException {
		Cart cart = entityManager.find(Cart.class, cartId);
		if (cart == null) {
			throw new CartException("No Cart Found");
		}

		return cart;
	}

	@Override
	public Cart deleteCartByCartId(int cartId) throws CartException {

		Cart cart = entityManager.find(Cart.class, cartId);
		if (cart != null) {
			entityManager.remove(cart);
		}
		return cart;
	}

	@Override
	public Cart updateCart(Cart cart) throws CartException {

		double amt = cart.getQuantity() * cart.getProduct().getPrice();

		cart.setTotalPrice(amt);
		cart = entityManager.merge(cart);

		return cart;
	}

	@Override
	public List<Product> viewAllProducts() throws CartException {
		String qry = "select p from Product p";
		TypedQuery<Product> query = entityManager.createQuery(qry, Product.class);
		query.getResultList();

		return query.getResultList();

	}

	@Override
	public Product findProductById(int productId) throws CartException {

		return entityManager.find(Product.class, productId);
	}
	
	

}
