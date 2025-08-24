package com.prodbill.prodBill.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prodbill.prodBill.model.Invoice;
import com.prodbill.prodBill.service.InvoiceService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@ResponseBody
@RequestMapping("/prodbill/invoice")
public class InvoiceController {
	
	@Autowired
	private InvoiceService iservices;
	
	@PostMapping("/save")
	public Invoice saveInvoice(@RequestBody Invoice i)
	{
		return iservices.saveInvoice(i);
	}
	
	@GetMapping("/findById/{i}")
	public Invoice findByIdInvoice(@PathVariable Integer i)
	{
		return iservices.Findbyid(i);
	}
	
	@GetMapping("/fetchall")
	public List<Invoice> findAllInvoice()
	{
		return iservices.fetchAllInvoice();
	}
	
	@DeleteMapping("/deleteByid")
	public String deleteProductByid(@RequestParam Integer i)
	{
		return iservices.invoiceDeleteBasedId(i);
	}


}
