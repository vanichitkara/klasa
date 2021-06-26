package com.noobForce.klasa.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Student implements Serializable
{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;
    private String fullName;
    private String email;
    private String password;
    private boolean isLoggedIn;
    
    public long getId()
    {
        return id;
    }
    
    public void setId(long id)
    {
        this.id = id;
    }
    
    public String getFullName()
    {
        return fullName;
    }
    
    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public boolean isLoggedIn()
    {
        return isLoggedIn;
    }
    
    public void setLoggedIn(boolean loggedIn)
    {
        isLoggedIn = loggedIn;
    }
    
    @Override
    public String toString()
    {
        return "Student{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isLoggedIn=" + isLoggedIn +
                '}';
    }
}

