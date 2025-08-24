package com.prodbill.prodBill.model;

import jakarta.persistence.*;

@Entity
public class ProductInvoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int product_id;
	private String name;
	private String description;
	private int quantity;
	private double price_at_purchase;
	private double price; // changed to private
	private double gst_Amount;
	private double gst_percentage;


	public int getId() { return id; }
	public int getProduct_id() { return product_id; }
	public int getQuantity() { return quantity; }
	public double getPrice_at_purchase() { return price_at_purchase; }
	public String getName() { return name; }
	public String getDescription() { return description; }
	public double getGst_Amount() { return gst_Amount; }
	public double getGst_percentage() { return gst_percentage; }
	public double getPrice() { return price; }


	// Setters
	public void setId(int id) { this.id = id; }
	public void setProduct_id(int product_id) { this.product_id = product_id; }
	public void setQuantity(int quantity) { this.quantity = quantity; }
	public void setPrice_at_purchase(double price_at_purchase) { this.price_at_purchase = price_at_purchase; }
	public void setName(String name) { this.name = name; }
	public void setDescription(String description) { this.description = description; }
	public void setGst_Amount(double gst_Amount) { this.gst_Amount = gst_Amount; }
	public void setPrice(double price) { this.price = price; }
	public void setGst_percentage(double gst_percentage) { this.gst_percentage = gst_percentage; }



	public void gstvalue() {
		this.gst_percentage = 18;
	}
	@PrePersist
	public void prevalues() {
		gstvalue();
		this.gst_Amount = (this.price_at_purchase * this.quantity * this.gst_percentage) / 100;
	}

}
