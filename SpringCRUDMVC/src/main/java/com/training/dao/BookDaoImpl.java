package com.training.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.training.beans.Book;
import com.training.beans.Users;

@Repository
public class BookDaoImpl implements BookDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Book> showAllBook() {
		String sql="select * from Book";
		List<Book> list=jdbcTemplate.query(sql,new RowMapper<Book>() {

			@Override
			public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Book b= new Book();
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setNumberofpages(rs.getInt(3));
				return b;
			}
			
		});
		return list;
	}

	@Override
	public int addByBook(Book b) {
		String sql="insert into Book values(?,?,?)";
		return jdbcTemplate.update(sql,new Object[] {b.getBookid(),b.getBookname(),b.getNumberofpages()});
	}

	@Override
	public Book getBookById(int id) {
		String sql="select * from book where id=?";
		return jdbcTemplate.queryForObject(sql,new Object[] {id},new RowMapper<Book>() {

			@Override
			public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Book b= new Book();
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setNumberofpages(rs.getInt(3));
				return b;
			}
			
		});
		
	}

	@Override
	public int updateBook(int id, String bookname, int pages) {
		String sql="update book set name=?,numberofpages=? where id=?";
		return jdbcTemplate.update(sql,new Object[] {bookname,pages,id});
		
	}

	@Override
	public int deleteBook(int id) {
		String sql="delete from book where id=?";
		return jdbcTemplate.update(sql,new Object[]{id});
	}

	@Override
	public Users validateUser(String uname, String upass) {
		String sql="select * from users where username=? and password=?";
		Users mu= jdbcTemplate.queryForObject(sql,new Object[]{uname,upass},new RowMapper<Users>() {

			@Override
			public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
				Users u=new Users();
				u.setUsername(rs.getString(1));
				u.setPassword(rs.getString(2));
				
				return u;
				
				
			}});
		return mu;
		
		/*
		System.out.println("*************************");
		System.out.println(uname);
		System.out.println(upass);
		System.out.println(mu.getUsername());
		System.out.println(mu.getPassword());
		System.out.println("****************************");

		
		if(mu.getUsername().equals(uname) && mu.getPassword().equals(upass))
		{
			System.out.println("true");
			return true;
		}
		else
		{
		System.out.println("false");
		return false;
		}
		*/
	}

	@Override
	public int changePassword(String username, String newpassword, String renewpassword) {
		String sql="update users set password=? where username=?";
		return jdbcTemplate.update(sql,new Object[] {newpassword,username});
	}

	

	@Override
	public int registerUser(String id, String password, String name, String address, String mobile, String email) {
		String sql="insert into users values(?,?,?,?,?,?)";
		return jdbcTemplate.update(sql,new Object[] {id,password,name,address,mobile,email});
	}

}
