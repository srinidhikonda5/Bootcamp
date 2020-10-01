package com.capg.go.cms.model;

import java.util.List;

/****************************************************************************************************************************
- File Name        : ProductList.java 
- Author           : Srinidhi 
- Creation Date    : 21/09/2020
- Description      : ProductList Class with productList Property
****************************************************************************************************************************/

public class ProductList {

	private List<Product> list;

	public ProductList() {
		super();
	}

	public ProductList(List<Product> list) {
		super();
		this.list = list;
	}

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
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
		ProductList other = (ProductList) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductList [list=" + list + "]";
	}

}
