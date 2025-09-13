package com.org.DonateLife.Service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.org.DonateLife.Dto.AddressDto;
import com.org.DonateLife.Dto.UsersDto;
import com.org.DonateLife.Entity.Address;
import com.org.DonateLife.Entity.BloodGroup;
import com.org.DonateLife.Entity.Users;
import com.org.DonateLife.ExceptionHandling.ResourceNotFound;
import com.org.DonateLife.Repo.AddressRepo;
import com.org.DonateLife.Repo.BloodGroupRepo;
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
	private ModelMapper mapper;

	@Override
	public boolean saveUser(UsersDto userDto) {
		// validation apply here

		Users user = mapper.map(userDto, Users.class);
		BloodGroup bloodGroup = bloodGroupRepo.findById(user.getBloodGroup().getId())
				.orElseThrow(() -> new ResourceNotFound("Blood Group Id Not found"));
		user.setBloodGroup(bloodGroup);

		// address save here
		Address address = addressRepo.save(user.getAddress());
		user.setAddress(address);

		Users save = userRepo.save(user);

		if (!ObjectUtils.isEmpty(save)) {
			return true; 
		}
		return false;
	}

}
