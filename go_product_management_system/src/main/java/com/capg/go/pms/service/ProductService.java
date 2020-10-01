package com.capg.go.pms.service;

import java.util.List;

import com.capg.go.pms.exception.ProductException;
import com.capg.go.pms.model.Product;

public interface ProductService {

	public Product findProductById(int productId) throws ProductException;

	public Product createProduct(Product product) throws ProductException;

	public Product updateProduct(Product product) throws ProductException;

	public Product deleteProductById(int productId) throws ProductException;

	public List<Product> listAllProducts() throws ProductException;

	public List<Product> searchProductByName(String productName);

	public List<Product> listOfProducts(double low, double high);
}
