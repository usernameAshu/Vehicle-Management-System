package com.mohanty.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mohanty.exception.AppException;
import com.mohanty.model.Customer;
import com.mohanty.service.AppService;

@RestController
@RequestMapping(value="/api")
public class AppController {

	@Autowired
	AppService service;
	
	@GetMapping(value="/public/welcome")
	public String homepage() {
		return "<h1> Welcome Home </h1>";
	}
	
	
	@PostMapping(value = "/public/uploadFile" , 
			consumes = MediaType.MULTIPART_FORM_DATA_VALUE , 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity uploadFile(@RequestParam(value = "files") MultipartFile[] files) {
	   
		try {
			
		for(MultipartFile file: files)
			service.saveAll(file);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		catch(Exception exc)
		{
			throw new AppException(exc.getMessage());
		}
		
	}
	
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	@GetMapping(value="/secured/all")
	public List<Customer> getAllCustomers() {
		return service.getAllCustomers();
	}
	
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	@GetMapping(value="/secured/idSearch/{id}")
	public Optional<Customer> getCustomerById(@PathVariable int id) {
		if(id < 0)
			throw new AppException("This is not a valid ID:"+id);
			else
				return service.getbyId(id);
	}
	
	}
	
