package com.org.DonateLife.Service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.org.DonateLife.Dto.AddressDto;
import com.org.DonateLife.Dto.UsersDto;
import com.org.DonateLife.Dto.UsersDto.RolesDto;
import com.org.DonateLife.Entity.Address;
import com.org.DonateLife.Entity.BloodGroup;
import com.org.DonateLife.Entity.Roles;
import com.org.DonateLife.Entity.Users;
import com.org.DonateLife.ExceptionHandling.ResourceNotFound;
import com.org.DonateLife.Repo.AddressRepo;
import com.org.DonateLife.Repo.BloodGroupRepo;
import com.org.DonateLife.Repo.RolesRepo;
import com.org.DonateLife.Repo.UserRepo;
import com.org.DonateLife.Service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private BloodGroupRepo bloodGroupRepo;

	@Autowired
	private AddressRepo addressRepo;

	@Autowired
	private RolesRepo rolesRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public boolean saveUser(UsersDto userDto) {
		// validation apply here

		Users user = mapper.map(userDto, Users.class);
		// Blood Group set here
		setBloodGroup(user);

		// address save here
		setAddress(user);

		// role set Here
		setRole(userDto, user);

		// update logic

		if (userDto.getId() != 0) {
			updateUser(user);
		}
		Users save = userRepo.save(user);

		if (!ObjectUtils.isEmpty(save)) {
			return true;
		}
		return false;
	}

	private void updateUser(Users user) {
		Users dbUser = userRepo.findById(user.getId()).orElseThrow(() -> new ResourceNotFound("User Id Not Found"));

	}

	private void setAddress(Users user) {
		Address address = addressRepo.save(user.getAddress());
		user.setAddress(address);

	}

	private void setBloodGroup(Users user) {
		BloodGroup bloodGroup = bloodGroupRepo.findById(user.getBloodGroup().getId())
				.orElseThrow(() -> new ResourceNotFound("Blood Group Id Not found"));
		user.setBloodGroup(bloodGroup);

	}

	private void setRole(UsersDto userDto, Users user) {
		List<RolesDto> roles = userDto.getRoles();
		List<Integer> list = roles.stream().map((e) -> e.getId()).toList();
		List<Roles> findAllById = rolesRepo.findAllById(list);
		user.setRoles(findAllById);

	}

	@Override
	public UsersDto findById(Integer id) {
		Users user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFound("User Id Not Found"));
		return mapper.map(user, UsersDto.class);
	}

}
