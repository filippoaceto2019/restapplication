package com.fa.restapplication.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fa.restapplication.conf.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	Optional<User> findByUserName(String username);

	
	Boolean existsByUserName(String username);

}
