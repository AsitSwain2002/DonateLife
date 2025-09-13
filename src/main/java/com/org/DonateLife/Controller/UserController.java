package com.org.DonateLife.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.DonateLife.Dto.UsersDto;
import com.org.DonateLife.Service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/save-user")
	public ResponseEntity<?> saveUser(@RequestBody UsersDto user) {

		System.out.println();
		System.out.println(user.getBloodGroup().getId());
		System.out.println();
		boolean saveUser = userService.saveUser(user);
		if (saveUser) {
			return new ResponseEntity("Saved Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
