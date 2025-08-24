package com.prodbill.prodBill.controller;

import com.prodbill.prodBill.model.User;
import com.prodbill.prodBill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@ResponseBody
@RequestMapping("/prodbill/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/save")
    public User createUser(@RequestBody User u)
    {
        return userService.CreateUser(u);
    }
    @GetMapping("/emailandpassword")
    public List<HashMap<String,String>> getEmailAndPassword(@RequestParam String email,@RequestParam String password)
    {
       return userService.getLogin(email,password);
    }
    @PostMapping("/emailsent/{s}")
    public String sentEMail(@PathVariable String s)
    {
        return userService.mailsent(s);
    }
}
