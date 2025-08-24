package com.prodbill.prodBill.service;

import com.prodbill.prodBill.model.User;
import com.prodbill.prodBill.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserService  {

    @Autowired
    private UserRepository userRepository;

    public User CreateUser(User u)
    {
        return  userRepository.save(u);
    }
    public List<HashMap<String,String>> getLogin(String email, String password)
    {
        User  u = userRepository.findByEmailAndPassword(email,password);
        ArrayList<HashMap<String,String>> al = new ArrayList<HashMap<String,String>>();
            if(u != null) {
                HashMap<String, String> hs = new HashMap<String, String>();
                hs.put("email", u.getEmail());
                hs.put("password", u.getPassword());
                al.add(hs);
            }
        return al;
    }

    private final JavaMailSender mailSender;

    public UserService(JavaMailSender mailSender)
    {
        this.mailSender = mailSender;
    }
    public String mailsent(String s)
    {
         int randomNumber = (int) (Math.random()*9000)+1000;
        try {
            SimpleMailMessage sm = new SimpleMailMessage();
            sm.setFrom("sabarinathv23@gmail.com");
            sm.setTo(s);
            sm.setSubject("Welcome to Simple Solutions");
            sm.setText("Your otp is :"+randomNumber);
            mailSender.send(sm);
            return (String.valueOf(randomNumber));
        }
        catch (Exception e)
        {
            return  e.getMessage();
        }

    }
}
