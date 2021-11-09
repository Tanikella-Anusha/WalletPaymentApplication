//package com.paymentapp.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PatchMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.paymentapp.exception.InvalidInputException;
//import com.paymentapp.service.IUserService;
//import com.paymentapp.service.IUserServiceImpl;
//
//@RestController
//@RequestMapping(path="/uapi")
//public class UserController {
//	@Autowired
//	IUserServiceImpl userservice;
//	@Autowired
//	IUserService us;
//
//	@RequestMapping("/hellouser")
//	public String HelloWallet()
//	{
//		String msg="Welcome to user";
//		return msg;
//	}
//	
//	@PatchMapping(path = "/login")
//	public String loginUser(@RequestParam String username, String password) throws InvalidInputException {
//		
//		userservice.validateLogin(username, password);
//		return "Login Successful!!!";
//	}
//}
