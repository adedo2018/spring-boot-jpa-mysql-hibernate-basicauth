package com.example.usermedical.security;

import com.example.usermedical.model.User;
import com.example.usermedical.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fred Assi
 */
@Service
public class UserSecurityService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException(String.format("User with the username %s doesn't exist", username));
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		if(user.isAdmin()) {
			authorities = AuthorityUtils.createAuthorityList("ROLE_ADMIN");
		}
		
		// Create a UserDetails object from the data 
		UserDetails
                    userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
		
		return userDetails;
	}
}
