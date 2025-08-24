package com.prodbill.prodBill.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prodbill.prodBill.model.Product;
import com.prodbill.prodBill.repo.ProductRepository;
@Service
public class ProductService {

	@Autowired
	private ProductRepository prepo;

	public Product saveProduct(Product p) {
		return prepo.save(p);
	}

	public List<Product> fetchByAll() {
		return prepo.findAll();
	}

	public Product findById(Integer i) {
		Optional<Product> o = prepo.findById(i);
		if (o.isPresent()) {
			return o.get();
		}
		return null;
	}

	public String deleteProduct(Integer i) {

		if (i != null) {
			prepo.deleteById(i);
			return "Product Delete";
		}
		return "Id not Found";
	}

	public String updateProduct(int product_id, Product p) {
		Product p1 = findById(product_id);
		if (p1 != null) {
			p1.setName(p.getName());
			p1.setDescription(p.getDescription());
			p1.setPrice(p.getPrice());
			p1.setStock(p.getStock());
			saveProduct(p1);
			return "Produt updated";
		}
		return "id not Found";
	}

	public Product getProductByName(String name) {
		Optional<Product> productName = prepo.findByNameIgnoreCase(name);
		if (productName.isPresent()) {
			return productName.get();
		} else {
			return null;
		}
	}

}

