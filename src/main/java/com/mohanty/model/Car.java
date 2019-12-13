package com.mohanty.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="car")
public class Car {
	
	@Id
	private String carRegNo ;
	private String carBrand ;
	private String carBrandModel;
	
	@ManyToOne
	private Customer customer;
	
	public Car(String carRegNo, String carBrand, String carBrandModel) {
		this.carRegNo = carRegNo;
		this.carBrand = carBrand;
		this.carBrandModel = carBrandModel;
	}

	public Car() {
	}

	public String getCarRegNo() {
		return carRegNo;
	}

	public void setCarRegNo(String carRegNo) {
		this.carRegNo = carRegNo;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getCarBrandModel() {
		return carBrandModel;
	}

	public void setCarBrandModel(String carBrandModel) {
		this.carBrandModel = carBrandModel;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	
	
}
