package com.baseoauth.dto;

import java.util.List;

import lombok.Data;

@Data
public class RoleModel {

	private String roleName;
	private String roleDesc;	
	private List<PermissionModel> permissions;
}
