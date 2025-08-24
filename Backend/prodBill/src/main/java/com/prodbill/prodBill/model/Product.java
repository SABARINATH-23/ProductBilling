package com.prodbill.prodBill.model;

import jakarta.persistence.*;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int product_id;
	@Column(unique = true)
	private String name;
	@Column(columnDefinition="Text",nullable = false)
	private String description;
	@Column(nullable = false)
	private double price;
	private int stock;
	@Column(nullable = false)
	private String category;



	public int getProduct_id()
	{	
		return product_id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName()
	{
		return name;
	}
	public String getDescription()
	{
		return description;
	}
	public double getPrice()
	{
		return price;
	}
	public int getStock()
	{
		return stock;
	}


	public void setProduct_id(int id)
	{
		this.product_id =id;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	public void setStock(int stock)
	{
		this.stock = stock;
	}



	
}
