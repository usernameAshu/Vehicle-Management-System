package com.mohanty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohanty.model.Customer;

@Repository
public interface AppRepository extends JpaRepository<Customer, Integer> {

}
