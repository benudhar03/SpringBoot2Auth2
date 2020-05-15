package com.baseoauth.entity;

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
import lombok.Data;

@Data
@Entity
@Table(name = "role", schema = "admin")
@SequenceGenerator(name="role_seq", sequenceName = "role_sequence",schema="admin", initialValue=1, allocationSize=1)
public class Role {

	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
	private long roleId;
	
	@Column(name = "role_name", unique = true)
	private String roleName;
	
	@Column(name = "role_desc")
	private String roleDesc;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "permission_role", schema = "admin",
            joinColumns = {
            		@JoinColumn(name = "role_id", referencedColumnName = "role_id",
            				nullable = false, updatable = false)
            },
            inverseJoinColumns = {
            		@JoinColumn(name = "permission_id", referencedColumnName = "permission_id",
            				nullable = false, updatable = false)
            }
    )
	private Set<PermissionEntity> permissions;
}
