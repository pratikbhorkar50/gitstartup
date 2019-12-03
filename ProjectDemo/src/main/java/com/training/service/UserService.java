package com.training.service;

import java.util.List;

import com.training.beans.Products;

public interface UserService {

	boolean checkUser(String username, String password);

	List<Products> getProductDetails();

	int addProductToList(int productid, int categoryid, String productname, int productprice);

}
