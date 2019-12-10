package com.mohanty.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Car")
public class Car {
	
	@Id
	private String car_reg_no ;
	private String car_brand ;
	private String car_brand_model;
	
	@ManyToOne
	private Customer customer;
	
	public Car(String car_reg_no, String car_brand, String car_brand_model) {
		this.car_reg_no = car_reg_no;
		this.car_brand = car_brand;
		this.car_brand_model = car_brand_model;
	}

	public Car() {
	}

	public String getCar_reg_no() {
		return car_reg_no;
	}

	public void setCar_reg_no(String car_reg_no) {
		this.car_reg_no = car_reg_no;
	}

	public String getCar_brand() {
		return car_brand;
	}

	public void setCar_brand(String car_brand) {
		this.car_brand = car_brand;
	}

	public String getCar_brand_model() {
		return car_brand_model;
	}

	public void setCar_brand_model(String car_brand_model) {
		this.car_brand_model = car_brand_model;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	
	
}
