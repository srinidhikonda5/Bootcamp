package com.capg.go.pms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capg.go.pms.exception.ProductException;
import com.capg.go.pms.model.Product;

@Repository
public interface ProductDao {

	public Product findProductById(int productId) throws ProductException;

	public Product createProduct(Product product) throws ProductException;

	public Product updateProduct(Product product) throws ProductException;

	public Product deleteProductById(int productId) throws ProductException;

	public List<Product> listAllProducts() throws ProductException;

	public List<Product> listOfProducts(double low, double high);

	public List<Product> searchProductByName(String productName);

}
