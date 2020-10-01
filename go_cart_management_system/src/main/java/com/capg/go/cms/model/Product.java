package com.capg.go.cms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/****************************************************************************************************************************
- File Name        : Product.java 
- Author           : Srinidhi 
- Creation Date    : 21/09/2020
- Description      : Product Bean class
****************************************************************************************************************************/

@Entity
@Table(name = "product_tbl1")
public class Product {
	
	@Id
	@GeneratedValue(generator = "seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq", sequenceName = "product_seq", allocationSize = 1)
	@Column(name = "product_id")
	private int productId;

	@Column(name = "product_name", length = 60)
	private String productName;

	@Column(name = "product_price")
	private double price;

	@Column(name = "product_color", length = 15)
	private String productColor;

	@Column(name = "product_category")
	private int productCategory;

	@Column(name = "product_specification", length = 100)

	private String productSpecification;

	@Column(name = "product_dimension")
	private String productDimension;

	@Column(name = "product_manufacturer", length = 40)
	private String productManufacturer;

	@OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Cart> cart = new ArrayList<Cart>();

	public Product() {
		super();
	}

	public Product(int productId, String productName, double price, String productColor, int productCategory,
			String productSpecification, String productDimension, String productManufacturer) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.productColor = productColor;
		this.productCategory = productCategory;
		this.productSpecification = productSpecification;
		this.productDimension = productDimension;
		this.productManufacturer = productManufacturer;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProductColor() {
		return productColor;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}

	public int getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(int productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductSpecification() {
		return productSpecification;
	}

	public void setProductSpecification(String productSpecification) {
		this.productSpecification = productSpecification;
	}

	public String getProductDimension() {
		return productDimension;
	}

	public void setProductDimension(String productDimension) {
		this.productDimension = productDimension;
	}

	public String getProductManufacturer() {
		return productManufacturer;
	}

	public void setProductManufacturer(String productManufacturer) {
		this.productManufacturer = productManufacturer;
	}

	public List<Cart> getCart() {
		return cart;
	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + productCategory;
		result = prime * result + ((productColor == null) ? 0 : productColor.hashCode());
		result = prime * result + ((productDimension == null) ? 0 : productDimension.hashCode());
		result = prime * result + productId;
		result = prime * result + ((productManufacturer == null) ? 0 : productManufacturer.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((productSpecification == null) ? 0 : productSpecification.hashCode());
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
		Product other = (Product) obj;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (productCategory != other.productCategory)
			return false;
		if (productColor == null) {
			if (other.productColor != null)
				return false;
		} else if (!productColor.equals(other.productColor))
			return false;
		if (productDimension == null) {
			if (other.productDimension != null)
				return false;
		} else if (!productDimension.equals(other.productDimension))
			return false;
		if (productId != other.productId)
			return false;
		if (productManufacturer == null) {
			if (other.productManufacturer != null)
				return false;
		} else if (!productManufacturer.equals(other.productManufacturer))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productSpecification == null) {
			if (other.productSpecification != null)
				return false;
		} else if (!productSpecification.equals(other.productSpecification))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", productColor=" + productColor + ", productCategory=" + productCategory + ", productSpecification="
				+ productSpecification + ", productDimension=" + productDimension + ", productManufacturer="
				+ productManufacturer + "]";
	}

}