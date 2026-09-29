package com.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="order_details")
public class Order {

	@Id
	private int id ;
	private String bookName;
	private int bookPrice;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="sid")
	Student sid;
	
	public Order() {
		
	}

	public Order(int id, String bookName, int bookPrice) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public Student getSid() {
		return sid;
	}

	public void setSid(Student sid) {
		this.sid = sid;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", bookName=" + bookName + ", bookPrice=" + bookPrice +"]";
	}

	
}
