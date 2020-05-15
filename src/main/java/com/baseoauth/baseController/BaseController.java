package com.baseoauth.baseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baseoauth.dto.PermissionModel;
import com.baseoauth.dto.RoleModel;
import com.baseoauth.dto.UserModel;
import com.baseoauth.resp.dto.AbstractResponse;
import com.baseoauth.service.ApplicationService;

@RestController
@RequestMapping("/admin-rest/api")
public class BaseController {

	@Autowired
	private ApplicationService applicationService;
	
	@PostMapping("/test-url")
	public  ResponseEntity<String> testServer(@RequestBody RoleModel permissionModel){
		return new ResponseEntity<>("OAUTH2 TOKEN",HttpStatus.OK);
	}
	
	@PostMapping("/createPermission")
	public ResponseEntity<? extends AbstractResponse> createPermission(@RequestBody PermissionModel permissionModel){
		return applicationService.createPermission(permissionModel);		
	}
	
	@PostMapping("/createUserRole")
	public ResponseEntity<? extends AbstractResponse> createUserRole(@RequestBody RoleModel roleModel){
		return applicationService.createRole(roleModel);		
	}
	
	@PostMapping("/createUser")
	public ResponseEntity<? extends AbstractResponse> createUser(@RequestBody UserModel userModel){
		return applicationService.createUser(userModel);		
	}
}
