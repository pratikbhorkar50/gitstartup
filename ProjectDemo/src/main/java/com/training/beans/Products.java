package com.training.beans;

public class Products {

	private int productid;
	private int categoryid;
	private String productname;
	private int productprice;
	public Products() {
		super();
	}
	public Products(int productid, int categoryid, String productname, int productprice) {
		super();
		this.productid = productid;
		this.categoryid = categoryid;
		this.productname = productname;
		this.productprice = productprice;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getProductprice() {
		return productprice;
	}
	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}
	@Override
	public String toString() {
		return "Products [productid=" + productid + ", categoryid=" + categoryid + ", productname=" + productname
				+ ", productprice=" + productprice + "]";
	}
	
}
