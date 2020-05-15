package com.baseoauth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.baseoauth.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

	Optional<Role> findByRoleName(String name);

	long findByRoleId(long roleId);

}
