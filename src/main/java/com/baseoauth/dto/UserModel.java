package com.baseoauth.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserModel {
	
	private String userName;
	private String email;
	private String mobileNo;
	private String password;
	private List<UserRoleModel> roles;

}