package com.training.service;

import java.util.List;

import com.training.beans.Book;

public interface BookService {

	List<Book> showBook();
	int addBook(Book b);
	Book getBookById(int id);
	int updateBook(int id, String bookname, int pages);
	int deleteBook(int id);
	boolean validateUser(String uname, String upass);
	int changePassword(String username, String newpassword, String renewpassword);
	int registerUsers(String id, String password, String name, String address, String mobile, String email);
}
