package com.fa.restapplication.conf;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.fa.restapplication.repository.RoleRepository;
import com.fa.restapplication.repository.UserRepository;



@Component
public class DataInit implements CommandLineRunner {
	
	@Autowired
	PasswordEncoder passwordEncoder;

    private UserRepository userRepository;
    
    private RoleRepository roleRepository;

    public DataInit(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
         LoadUsers();
    }
    
    

    private void LoadUsers() {
    	
    	boolean existRoleAdmin = roleRepository.existsByName("ROLE_ADMIN");
    	boolean existRoleUser = roleRepository.existsByName("ROLE_USER");
    	
    	if(!existRoleAdmin) {
    		Role role = new Role();
        	role.setName("ROLE_ADMIN");
        	roleRepository.save(role);
    	}
    	
    	if(!existRoleUser) {
    		Role role = new Role();
        	role.setName("ROLE_USER");
        	roleRepository.save(role);
    	}

    	
   
    	
    	
    	boolean existUser = userRepository.existsByUserName("user");
    	
    	if(!existUser) {
    		User user = new User();
        	user.setEmail("test@test.it");
        	user.setPassword(passwordEncoder.encode("password"));
        	user.setUserName("user");
        	
        	List<Role> roles = new ArrayList<Role>();
        	Optional<Role> role = roleRepository.findByName("ROLE_USER");
        	roles.add(role.get());        	
        	user.setRoles(roles);
        	userRepository.save(user);
    	}
    	
        boolean existAdmin = userRepository.existsByUserName("admin");
    	
    	if(!existAdmin) {
    		User user = new User();
        	user.setEmail("admin@test.it");
        	user.setPassword(passwordEncoder.encode("password"));
        	user.setUserName("admin");
        	
        	List<Role> roles = new ArrayList<Role>();
        	Optional<Role> role = roleRepository.findByName("ROLE_ADMIN");
        	roles.add(role.get());        	
        	user.setRoles(roles);
        	userRepository.save(user);
    	}
    	
    	
    	
    	
        
    }
}