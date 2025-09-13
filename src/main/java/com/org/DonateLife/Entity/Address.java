package com.org.DonateLife.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String houseNumber;
	private String streetName;
	private String area;
	private String landmark;
	private String city;
	private String district;
	private String state;
	private String country;
	private String pincode;
}
