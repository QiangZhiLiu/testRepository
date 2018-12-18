package com.shop.customer;

import java.util.Arrays;
import java.util.List;

import com.shop.domain.Product;
import com.shop.domain.User;

public class CustomBean {
	private User user;
	@Override
	public String toString() {
		return "CustomBean [user=" + user + ", ids=" + Arrays.toString(ids) + ", products=" + products + "]";
	}

	private Integer[] ids;

	// list 传递参数
	
	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
