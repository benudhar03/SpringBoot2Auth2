package com.baseoauth.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.baseoauth.entity.Role;
import com.baseoauth.entity.UserEntity;

public class AuthUserDetails extends UserEntity implements UserDetails{
	
	public AuthUserDetails(UserEntity user) {
		super(user);
	}
	
	public AuthUserDetails() {
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthority =  new ArrayList<>();
		getRoles().forEach(role->{
			grantedAuthority.add(new SimpleGrantedAuthority(role.getRoleName()));
			role.getPermissions().forEach(permission-> {
				grantedAuthority.add(new SimpleGrantedAuthority(permission.getName()));
			});
		});
		return grantedAuthority;
	}

	@Override
	public String getUsername() {
		return super.getUserName();
	}
	
	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public boolean isAccountNonExpired() {
		return super.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return super.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return super.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return super.isEnabled();
	}
}
