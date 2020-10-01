package com.capg.go.cms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/****************************************************************************************************************************
- File Name        : Cart.java 
- Author           : Srinidhi 
- Creation Date    : 21/09/2020
- Description      : Cart Bean class
****************************************************************************************************************************/


@Entity
@Table(name = "cart_tbl1")
public class Cart {

	@Id
	@GeneratedValue(generator = "seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq", sequenceName = "product_cart_seq", allocationSize = 1)
	@Column(name = "cart_id")
	private int cartId;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "total_price")
	private double totalPrice;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	public Cart() {
		super();
	}

	public Cart(int cartId, int quantity, double totalPrice) {
		super();
		this.cartId = cartId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {

		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {

		this.totalPrice = totalPrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", quantity=" + quantity + ", totalPrice=" + totalPrice + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cartId;
		result = prime * result + quantity;
		long temp;
		temp = Double.doubleToLongBits(totalPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (cartId != other.cartId)
			return false;
		if (quantity != other.quantity)
			return false;
		if (Double.doubleToLongBits(totalPrice) != Double.doubleToLongBits(other.totalPrice))
			return false;
		return true;
	}

}
