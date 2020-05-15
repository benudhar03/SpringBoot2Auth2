package com.baseoauth.service;

import org.springframework.http.ResponseEntity;

import com.baseoauth.dto.PermissionModel;
import com.baseoauth.dto.RoleModel;
import com.baseoauth.dto.UserModel;
import com.baseoauth.resp.dto.AbstractResponse;

public interface ApplicationService {

	ResponseEntity<? extends AbstractResponse> createUser(UserModel userDetails);

	ResponseEntity<? extends AbstractResponse> createRole(RoleModel roleModel);

	ResponseEntity<? extends AbstractResponse> createPermission(PermissionModel permissionModel);

}
