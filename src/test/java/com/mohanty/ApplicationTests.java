package com.mohanty;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mohanty.model.Customer;
import com.mohanty.repository.CustomerRepository;
import com.mohanty.service.AppService;

@RunWith(SpringRunner.class)
@SpringBootTest
class ApplicationTests {

	@Autowired
	AppService service;
	
	@MockBean
	CustomerRepository repo;
	
	@Test
	public void getAllCustomersTest() {
		when(repo.findAll()).
		thenReturn(Stream.of(
				new Customer(1,"John",25,"Bangalore"),
				new Customer(2,"Rambo",45,"Los Angeles"))
				.collect(Collectors.toList()));
		
		assertEquals(2, service.getAllCustomers().size());
	}

}
