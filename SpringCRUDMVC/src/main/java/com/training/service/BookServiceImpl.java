package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.beans.Book;
import com.training.beans.Users;
import com.training.dao.BookDao;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bookDao;
	
	@Override
	public List<Book> showBook() {
		return bookDao.showAllBook();
	
	}

	@Override
		public int addBook(Book b) {
			
			return bookDao.addByBook(b);
			
		}

	@Override
	public Book getBookById(int id) {
		return bookDao.getBookById(id);
	}

	@Override
	public int updateBook(int id, String bookname, int pages) {
		// TODO Auto-generated method stub
		return bookDao.updateBook(id,bookname,pages);
	}

	@Override
	public int deleteBook(int id) {
		// TODO Auto-generated method stub
		return bookDao.deleteBook(id);
	}

	@Override
	public boolean validateUser(String uname, String upass) {
		// TODO Auto-generated method stub
		Users u= bookDao.validateUser(uname,upass);
		
		if(u.getUsername().equals(uname) && u.getPassword().equals(upass))
		{
			System.out.println("true");
			return true;
		}
		else
		{
			System.out.println("false");
			return false;
		}
	}

	@Override
	public int changePassword(String username, String newpassword, String renewpassword) {
		// TODO Auto-generated method stub
	return bookDao.changePassword(username,newpassword,renewpassword);
	}

	@Override
	public int registerUsers(String id, String password, String name, String address, String mobile, String email) {
		return bookDao.registerUser(id,password,name,address,mobile,email);
	}
	
		
	}

