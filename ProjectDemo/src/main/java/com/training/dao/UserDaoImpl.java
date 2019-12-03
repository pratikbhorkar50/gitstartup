package com.training.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.training.beans.Products;
import com.training.beans.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<User> checkUser(String username, String password) {

		
		String sqlall="select * from users";
		List<User> ulist=jdbcTemplate.query(sqlall,new RowMapper<User>() {
			
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User u=new User();
				u.setUsername(rs.getString(1));
				u.setPassword(rs.getString(2));
				return u;
			}
		});
		System.out.println(ulist);
		return ulist;
		
	}

	@Override
	public List<Products> getProductDetails() {
		String sql="select * from product_list";
		List<Products> plist=jdbcTemplate.query(sql, new BeanPropertyRowMapper<Products>(Products.class));
		return plist;
	}

	@Override
	public int addProductToList(int productid, int categoryid, String productname, int productprice) {
		String sql="insert into product_list values(?,?,?,?)";
		//int p=(int) jdbcTemplate.queryForObject(sql,new Object[] {productid,categoryid,productname,productprice}, new BeanPropertyRowMapper(Products.class));
		int p=jdbcTemplate.update(sql,new Object[] {productid,categoryid,productname,productprice});
		return p;
	}
			
	

}
