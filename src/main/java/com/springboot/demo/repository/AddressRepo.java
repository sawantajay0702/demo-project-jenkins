package com.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.demo.entites.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long>{

}
