package com.prodbill.prodBill.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoice_id;

	private String ownCompany;
	private String ownAddress;
	@Column(nullable = false)
	private String company_name;
	@Column(nullable = false)
	private String customer_Address;
	@Column(nullable = false)
	private String gst_number;
	@Column(nullable = false)
	private String date;
	@Column(nullable = false)
	private String total_Amount;

	private String uniqueInvoice;  
	private double gst_percent;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "invoice_id", referencedColumnName = "invoice_id")
	private List<ProductInvoice> productInvoice;
	public int getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}

	public String getUniqueInvoice() {
		return uniqueInvoice;
	}

	public void setUniqueInvoice(String uniqueInvoice) {
		this.uniqueInvoice = uniqueInvoice;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getCustomer_Address() {
		return customer_Address;
	}

	public void setCustomer_Address(String customer_Address) {
		this.customer_Address = customer_Address;
	}

	public String getGst_number() {
		return gst_number;
	}

	public void setGst_number(String gst_number) {
		this.gst_number = gst_number;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTotal_Amount() {
		return total_Amount;
	}

	public void setTotal_Amount(String total_Amount) {
		this.total_Amount = total_Amount;
	}

	public String getOwnCompany() {
		return ownCompany;
	}

	public void setOwnCompany(String ownCompany) {
		this.ownCompany = ownCompany;
	}

	public String getOwnAddress() {
		return ownAddress;
	}

	public void setOwnAddress(String ownAddress) {
		this.ownAddress = ownAddress;
	}

	public double getGst_percent() {
		return gst_percent;
	}

	public void setGst_percent(double gst_percent) {
		this.gst_percent = gst_percent;
	}

	public List<ProductInvoice> getProductInvoice() {
		return productInvoice;
	}

	public void setProductInvoice(List<ProductInvoice> productInvoice) {
		this.productInvoice = productInvoice;
	}
	private void setDefaultCompany() {
		this.ownCompany = "Stellar Dynamics Corp";
	}

	private void setDefaultAddress() {
		this.ownAddress = "456 Oak Avenue, Anytown, USA";
	}

	private void setDefaultGst() {
		this.gst_percent = 18;
	}
	@PrePersist
	public void prePersist() {
		setDefaultAddress();
		setDefaultCompany();
		setDefaultGst();
	}

	@PostPersist
	public void postPersist() {
		this.uniqueInvoice = "Simple" + String.format("%05d", this.invoice_id);
	}
}
