package com.prodbill.prodBill.repo;

import com.prodbill.prodBill.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmailAndPassword(String email,String Password);


}
