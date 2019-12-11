package com.mohanty.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.mohanty.exception.AppException;
import com.mohanty.model.Customer;

@Component
public class ParseCSVfile {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("ParseCSVfile.class");
	
	public List<Customer> parseCSVFile(MultipartFile file)   {

		final List<Customer> customerList = new ArrayList<>();

		try (final BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(";");
				Customer custObject = new Customer();
				custObject.setName(data[0]);
				custObject.setAge(Integer.parseInt((data[1])));
				custObject.setCity(data[2]);
				customerList.add(custObject);
			}

			return customerList;

		} catch (IOException e) {
			LOGGER.error("Failed to parse CSV file {}", e);
			throw new AppException("Failed to parse CSV file {}", e);
		}

	}


}
