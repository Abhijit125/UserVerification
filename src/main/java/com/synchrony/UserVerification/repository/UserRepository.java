package com.synchrony.UserVerification.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synchrony.UserVerification.entities.UserReg;



@Repository
public interface UserRepository extends JpaRepository<UserReg, Long> {

	Optional<UserReg> findByUsername(String username);

	Boolean existsByUsername(String username);

}
