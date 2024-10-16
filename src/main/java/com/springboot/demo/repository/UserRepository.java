package com.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.demo.entites.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
