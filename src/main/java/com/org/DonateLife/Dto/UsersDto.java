package com.org.DonateLife.Dto;

import java.util.List;

import lombok.Data;

@Data
public class UsersDto {
	private int id;
	private String firstName;
	private String lastName;
	private String mobile;
	private String email;
	private String password;
	private int age;
	private BloodGroupDto bloodGroup;
	private AddressDto address;
	private List<RolesDto> roles;

	@Data
	public static class RolesDto {
		private int id;
	}
}
