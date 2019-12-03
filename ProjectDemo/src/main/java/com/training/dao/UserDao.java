package com.training.dao;

import java.util.List;

import com.training.beans.Products;
import com.training.beans.User;

public interface UserDao {


	List<User> checkUser(String username, String password);

	List<Products> getProductDetails();

	int addProductToList(int productid, int categoryid, String productname, int productprice);

}
