package com.app.springsecurityapp.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.springsecurityapp.persistence.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

  Optional<UserEntity> findUserEntityByUsername(String username);

  // @Query("SELECT u FROM UserEntity u WHERE u.username=?1")
  // Optional<UserEntity> findUser(String username);

}
