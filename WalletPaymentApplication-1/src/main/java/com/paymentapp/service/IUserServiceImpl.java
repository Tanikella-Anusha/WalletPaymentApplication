//package com.paymentapp.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.paymentapp.exception.InvalidInputException;
//import com.paymentapp.repo.IUserRepo;
//
//@Service
//public class IUserServiceImpl implements IUserService  {
//	
//	@Autowired
//	public IUserRepo urepo;
//
//
//	@Override
//	public boolean validateLogin(String username, String password) throws InvalidInputException {
//		boolean flag = false;
//		try {
//			if (username == null || password == null) {
//				throw new InvalidInputException("User Details cannot be Empty");
//			} else {
//				flag = true;
//			}
//		} catch (Exception e) {
//			throw new InvalidInputException("User Details cannot be Empty");
//		}
//
//		return flag;
//	}
//
//}
