package com.prodbill.prodBill.repo;

import com.prodbill.prodBill.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import com.prodbill.prodBill.model.Invoice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import java.util.List;

@EnableJpaRepositories
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
