package com.training.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.training.beans.Book;
import com.training.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	           
	@RequestMapping("/")
	public String index()
	{
		return "index";
	}
	
	@RequestMapping(value="/book")
	public ModelAndView showBook()
	{
		List<Book> list=bookService.showBook();
		return new ModelAndView("showbook","list",list);
	}
	
	@RequestMapping(value="/addBook")
	public ModelAndView addBookDetails(@RequestParam(value="id") int id,@RequestParam(value="name") String name,@RequestParam(value="pages")int pages)
	{
		Book b = new Book(id,name,pages);
		int ans=bookService.addBook(b);
		return new ModelAndView("redirect:/book");
	}
	
	@RequestMapping("/addProduct")
	public ModelAndView addBook()
	{
		return new ModelAndView("add","command",new Book());
	}
	
	
	@RequestMapping("/edit/{id}")
	public ModelAndView editBook(@PathVariable(value="id") int id)
	{
		Book b=bookService.getBookById(id);
		return new ModelAndView("EditBook","book",b);
	}
	
	
	
	@RequestMapping("/editBookDetails")
	public ModelAndView editBook(@RequestParam(value="bookid") int id,@RequestParam(value="bookname")String bookname,@RequestParam(value="numberofpages")int pages)
	{
		
		int ans=bookService.updateBook(id,bookname,pages);
		return new ModelAndView("redirect:/book");
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteBook(@PathVariable(value="id")int id)
	{
		int ans=bookService.deleteBook(id);
		return new ModelAndView("redirect:/book");
	}
	
	
	@RequestMapping(value="/validate")
	public ModelAndView validateUser(@RequestParam("uname")String uname,@RequestParam("upass")String upass,HttpSession session)
	{
		boolean ans=bookService.validateUser(uname, upass);
		
		if(ans)
		{
			session.setAttribute("username", uname);
			//return new ModelAndView("welcome","uname",uname);
			return new ModelAndView("redirect:/book");
		}
		return new ModelAndView("redirect:/");
		
		
	}
	
	@RequestMapping(value="/forgotpassword")
	public ModelAndView forgetPass()
	{
		return new ModelAndView("ForgetPass","command",new Object());
		
	}
	
	@RequestMapping(value="/forgetpass")
	public ModelAndView forgetPasswordInDb(@RequestParam(value="username")String username,@RequestParam(value="newpass") String newpassword,@RequestParam(value="renewpass")String renewpassword)
	{
		int ans=bookService.changePassword(username,newpassword,renewpassword);
		return new ModelAndView("redirect:/");
		
	}

	@RequestMapping("/registration")
	public ModelAndView registration()
	{
		return new ModelAndView("Registration","command",new Object());
	}
	
	@RequestMapping("/register")
	public ModelAndView registrationUser(@RequestParam("id")String id,@RequestParam("password")String password,@RequestParam("name")String name,@RequestParam("address")String address,@RequestParam("mobile")String mobile,@RequestParam("email")String email)
	{
		int ans=bookService.registerUsers(id,password,name,address,mobile,email);
		return new ModelAndView("redirect:/");
	}
}
