package com.org.DonateLife.Dto;

import lombok.Data;

@Data
public class UsersDto {
	private String firstName;
	private String lastName;
	private String mobile;
	private String email;
	private String password;
	private int age;
	private BloodGroupDto bloodGroup;
	private AddressDto address;

}
