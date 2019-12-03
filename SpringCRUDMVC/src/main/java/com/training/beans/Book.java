package com.training.beans;

public class Book {
	
	private int bookid;
	private String bookname;
	private int numberofpages;
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getNumberofpages() {
		return numberofpages;
	}
	public void setNumberofpages(int numberofpages) {
		this.numberofpages = numberofpages;
	}
	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", bookname=" + bookname + ", numberofpages=" + numberofpages + "]";
	}
	public Book(int bookid, String bookname, int numberofpages) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.numberofpages = numberofpages;
	}
	public Book() {
		super();
	}
	
	
	

}
