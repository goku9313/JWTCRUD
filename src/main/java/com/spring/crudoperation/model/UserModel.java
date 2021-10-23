package com.spring.crudoperation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.springframework.lang.NonNull;

@Table(name="user")
@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;
    private int age;

    private String gender;
    private String city;
    private String Email;

    
    public UserModel() {
    }


    public UserModel(String name, int age, String gender, String city, String email) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.city = city;
        Email = email;
    }

    public Long getId(){
        return id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city;
    }


    public String getEmail() {
        return Email;
    }


    public void setEmail(String email) {
        Email = email;
    }


    @Override
    public String toString() {
        return "name= " + name + ", Email= " + Email + ", age= " + age + ", city= " + city + ", gender= " + gender
                + "]";
    }
}
