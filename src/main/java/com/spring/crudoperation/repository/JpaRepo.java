package com.spring.crudoperation.repository;

import java.util.ArrayList;
//import java.util.Optional;

import com.spring.crudoperation.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface JpaRepo extends JpaRepository<UserModel, Long> {
    ArrayList<UserModel> findByName(String name);
    //Optional<UserModel> findById(Long id);
}
