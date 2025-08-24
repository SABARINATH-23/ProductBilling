package com.prodbill.prodBill.model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private long mobileNo;
    @Column(nullable = false)
    private String dateOfBirth;

    public int getId()
    {
        return id;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public String getEmail()
    {
        return email;
    }
    public String getPassword()
    {
        return password;
    }
    public long getMobileNo()
    {
        return mobileNo;
    }
    public String getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public void setPassword(String password)
    {
        this.password  = password;
    }
    public void setMobileNo(long mobileNo)
    {
        this.mobileNo = mobileNo;
    }
    public void setDateOfBirth(String dateOfBirth)
    {
        this.dateOfBirth =  dateOfBirth;
    }

}
