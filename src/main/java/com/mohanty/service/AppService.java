package com.mohanty.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mohanty.model.Customer;
import com.mohanty.repository.AppRepository;
import com.mohanty.util.ParseCSVfile;

@Service
public class AppService {

	private static final Logger LOGGER = LoggerFactory.getLogger("AppService.class");

	@Autowired
	AppRepository repo;

	@Autowired
	ParseCSVfile parseFile;

	public List<Customer> getAllCustomers() {
		return repo.findAll();

	}

	public Optional<Customer> getbyId(int id) {

		return repo.findById(id);

	}

	public List<Customer> saveAll(MultipartFile file) throws Exception {
		final long START = System.currentTimeMillis();

		List<Customer> list = parseFile.parseCSVFile(file);

		LOGGER.info("Saving a list of cars of size {} records", list.size());

		list = repo.saveAll(list);

		LOGGER.info("Elapsed time {}", (System.currentTimeMillis() - START));
		return list;

	}
}
