package com.training.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.training.beans.Products;
import com.training.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/")
	public String Area()
	{
		return "index";
	}
	
	@RequestMapping("/validateuser")
	public ModelAndView ValidateUserWithDB(@RequestParam("username")String username,@RequestParam("password")String password,HttpSession usernameSession,HttpServletRequest request)
	{
		usernameSession.setAttribute("username",username);	
		boolean ans=userService.checkUser(username,password);
		if(ans)
		{
			return new ModelAndView("redirect:/productdetails");
		}
		else
		{
			System.out.println("Wrong password");
			return new ModelAndView("index","command",new Object());
		}
		
	}
	
	@RequestMapping("/productdetails")
	public ModelAndView productDetails()
	{
		List<Products> plist=userService.getProductDetails();
		return new ModelAndView("welcome","plist",plist);
	}
	
	@RequestMapping("/addproduct")
	public ModelAndView addProduct()
	{
		return new ModelAndView("addproduct","command",new Object());
	}
	
	@RequestMapping("/addnewproduct")
	public ModelAndView addProductToList(@RequestParam("productid")int productid,@RequestParam("categoryid")int categoryid,@RequestParam("productname")String productname,@RequestParam("productprice")int productprice)
	{
		int p=userService.addProductToList(productid,categoryid,productname,productprice);
		return new ModelAndView("redirect:/productdetails");
	}
}
