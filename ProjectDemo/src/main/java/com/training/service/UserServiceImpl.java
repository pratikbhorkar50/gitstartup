package com.training.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.beans.Products;
import com.training.beans.User;
import com.training.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	@Autowired
	HttpSession session;
	@Override
	public boolean checkUser(String username, String password) {
		// TODO Auto-generated method stub
		String str=(String) session.getAttribute("username");
		System.out.println("Session String"+str);
		List<User> ulist=userDao.checkUser(username,password);
		for(User u:ulist)
		{
			if(username.equals(u.getUsername()) && password.equals(u.getPassword()))
			{
				return true;
			}
		}
		return false;
		
		
	}
	@Override
	public List<Products> getProductDetails() {
		
		return userDao.getProductDetails();
	}
	@Override
	public int addProductToList(int productid, int categoryid, String productname, int productprice) {
		return userDao.addProductToList(productid,categoryid,productname,productprice);
	}

}
