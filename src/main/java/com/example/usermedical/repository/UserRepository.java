package com.example.usermedical.repository;

import com.example.usermedical.model.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Fred Assi
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUsername(String username);
}
