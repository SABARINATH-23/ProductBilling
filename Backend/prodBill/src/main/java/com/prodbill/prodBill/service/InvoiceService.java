package com.prodbill.prodBill.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import com.prodbill.prodBill.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prodbill.prodBill.model.Invoice;
import com.prodbill.prodBill.repo.InvoiceRepository;

@Service
public class InvoiceService {
	@Autowired
	private InvoiceRepository irepo;
	
	public Invoice saveInvoice(Invoice i)
	{
		return irepo.save(i);
	}
	public Invoice Findbyid(Integer i)
	{
		Optional<Invoice> in = irepo.findById(i);
		if(in != null)
		{
			return in.get();
		}
		return null;
	}
	
	public List<Invoice> fetchAllInvoice()
	{
		return irepo.findAll();
	}
	public String invoiceDeleteBasedId(Integer i)
	{
		if(i != null)
		{
			irepo.deleteById(i);
			return "Product Deleted";
		}
		return "Id Not Found";
	}

}