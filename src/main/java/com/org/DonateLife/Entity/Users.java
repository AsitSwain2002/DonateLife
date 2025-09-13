package com.org.DonateLife.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String mobile;
	private String email;
	private String password;
	private int age;

	@OneToOne
	private BloodGroup bloodGroup;

	@OneToOne
	private Address address;
}
