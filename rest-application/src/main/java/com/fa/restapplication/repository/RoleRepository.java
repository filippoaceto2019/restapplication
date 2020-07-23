package com.fa.restapplication.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fa.restapplication.conf.Role;


@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{

	Optional<Role> findByName(String name);
	
	Boolean existsByName(String name);

	
}
