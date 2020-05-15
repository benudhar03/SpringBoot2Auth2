package com.baseoauth.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name = "user", schema = "admin")
@SequenceGenerator(name="user_seq", sequenceName = "user_sequence",schema="admin", initialValue=1, allocationSize=1)
public class UserEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public UserEntity() {
	}			

	public UserEntity(UserEntity user) {
		this.id = user.id;
		this.userName = user.userName;
		this.email = user.email;
		this.mobileNo = user.mobileNo;
		this.password = user.password;
		this.isEnabled = user.isEnabled;
		this.isCredentialsNonExpired = user.isCredentialsNonExpired;
		this.isAccountNonLocked = user.isAccountNonLocked;
		this.isAccountNonExpired = user.isAccountNonExpired;
		this.roles = user.roles;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_details_seq")
	private long id;
	
	@Column(name = "user_name",unique = true)
	private String userName;
	
	@Column(name = "email_id")
	private String email;
	
	@Column(name = "mobile_no")
	private String mobileNo;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "is_enabled")
	private boolean isEnabled;
	
	@Column(name = "is_credentials_non_expired")
	private boolean isCredentialsNonExpired;
	
	@Column(name = "is_account_non_locked")
	private boolean isAccountNonLocked;
	
	@Column(name = "is_account_non_expired")
	private boolean isAccountNonExpired;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "user_role",schema = "admin",
            joinColumns = {
            		@JoinColumn(name = "user_id", referencedColumnName = "user_name",
            				nullable = false, updatable = false)
            },
            inverseJoinColumns = {
            		@JoinColumn(name = "role_id", referencedColumnName = "role_id",
            				nullable = false, updatable = false)
            }
    )
	private Set<Role> roles;
	
}
