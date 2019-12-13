package com.mohanty.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.mohanty.model.Customer;

public interface AppService {

	public List<Customer> getAllCustomers();

	public Optional<Customer> getbyId(int id);

	public List<Customer> saveAll(MultipartFile file);

}
