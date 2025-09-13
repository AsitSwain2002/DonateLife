package com.org.DonateLife.Service;

import com.org.DonateLife.Dto.UsersDto;

public interface UserService {
	
	boolean saveUser(UsersDto user);
	
	UsersDto findById(Integer id);
	
	
}
