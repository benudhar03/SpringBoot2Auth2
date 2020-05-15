package com.baseoauth.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "permission", schema = "admin")
@SequenceGenerator(name="permission_seq", sequenceName = "permission_sequence",schema="admin", initialValue=1, allocationSize=1)
public class PermissionEntity {

	@Id
	@Column(name = "permission_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permission_seq")
	private long permissionId;
	
	@Column(name = "permission_name")
	private String name;
	
	@ManyToMany(mappedBy = "permissions",cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Set<Role> roles;
}
