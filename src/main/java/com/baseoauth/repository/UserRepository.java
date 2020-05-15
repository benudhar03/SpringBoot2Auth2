package com.baseoauth.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.baseoauth.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

	Optional<UserEntity> findByUserName(String userName);

	Optional<UserEntity> findByUserNameOrEmailOrMobileNoEquals(String userName, String email, String mobileNo);
}
