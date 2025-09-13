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
import com.org.DonateLife.Utility.ResponseHandler;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/save-user")
	public ResponseEntity<?> saveUser(@RequestBody UsersDto user) {
		boolean saveUser = userService.saveUser(user);
		if (saveUser) {
			return ResponseHandler.withMessage("Saved Successfully", HttpStatus.OK);
		} else {
			return ResponseHandler.withMessage("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
