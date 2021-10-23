package com.spring.crudoperation.controllers;

import java.util.ArrayList;
import java.util.List;

import com.spring.crudoperation.model.UserModel;

import com.spring.crudoperation.repository.JpaRepo;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping()
public class MyController {

    @Autowired
    private JpaRepo jpaRepo;

    @GetMapping("/")
    public String home(){
        return "Home Page";
    }

    @GetMapping("/users")
    public List<UserModel> getUsers(){
        return jpaRepo.findAll();
    }

    @PostMapping("/user")
    public UserModel addUser(@RequestBody UserModel userModel){
        jpaRepo.save(userModel);
        return userModel;
    }

    @GetMapping("/user/{name}")
    public ArrayList<UserModel> getUserByName(@PathVariable String name){
        return this.jpaRepo.findByName(name);
    }

    @PutMapping("/user/{id}")
    public String putStudent(@PathVariable long id, @RequestBody UserModel userModel) {
        UserModel newModel = jpaRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid User Id:" + id));
        System.out.println(newModel.toString());
        newModel.setName(userModel.getName());
        newModel.setAge(userModel.getAge());
        newModel.setEmail(userModel.getEmail());
        newModel.setCity(userModel.getCity());
        jpaRepo.save(newModel);
        return newModel.getName()+ " added successfully!!";
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id){
        UserModel newModel = jpaRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid User Id:" + id));
        jpaRepo.deleteById(id);
        return newModel.getName() + " Deleted!!";
    }

}

// Insert into user (id, name, age, email, city, gender) VALUES(123, 'Perter', 25, "perter@gmail.com", "Rotterdam", 'Male');
// Insert into user (id, name, age, email, city, gender) VALUES(124,"Lomkesh", 22, "lomkesh@gmail.com", "Aligarh", 'M');