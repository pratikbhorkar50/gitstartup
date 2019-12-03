package com.training.dao;

import java.util.List;

import com.training.beans.Book;
import com.training.beans.Users;

public interface BookDao {

	List<Book> showAllBook();

	int addByBook(Book b);

	Book getBookById(int id);

	int updateBook(int id, String bookname, int pages);

	int deleteBook(int id);

	Users validateUser(String uname, String upass);

	int changePassword(String username, String newpassword, String renewpassword);

	int registerUser(String id, String password, String name, String address, String mobile, String email);

}
