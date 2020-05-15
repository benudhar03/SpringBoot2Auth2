package com.baseoauth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baseoauth.entity.PermissionEntity;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity,Long> {

	Optional<PermissionEntity> findByName(String name);

}
