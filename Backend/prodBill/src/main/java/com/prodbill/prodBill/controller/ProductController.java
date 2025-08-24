package com.prodbill.prodBill.controller;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prodbill.prodBill.model.Product;
import com.prodbill.prodBill.service.ProductService;

@RestController
@RequestMapping("prodbill/product")
@ResponseBody
@CrossOrigin
public class ProductController {
	
	@Autowired
	private ProductService pservices;
	
	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product p)
	{
		return pservices.saveProduct(p);
	}
	
	@GetMapping("/fetchall")
	public List<Product> fetchAllProduct()
	{
		return pservices.fetchByAll();
	}
	
	@GetMapping("/findByid/{i}")
	public Product findById(@PathVariable Integer i )
	{
		return pservices.findById(i);
	}
	@DeleteMapping("/delete")
	public String deleteProductid(@RequestParam Integer i)
	{
		return pservices.deleteProduct(i);
	}
	
	@PutMapping("/update/{product_id}")
	public String updateProduct(@PathVariable int product_id,@RequestBody Product p)
	{
		return pservices.updateProduct(product_id, p);
	}
	@GetMapping("/getProductName")
	public Product getProductByName(@RequestParam String s)
	{
		return pservices.getProductByName(s);
	}


}
