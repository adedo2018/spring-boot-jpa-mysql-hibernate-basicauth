package com.example.usermedical.service;

import com.example.usermedical.exception.ResourceNotFoundException;
import com.example.usermedical.model.User;
import com.example.usermedical.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Fred Assi
 */
@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public UserService(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  public User findById(Long id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("user medical", "id", id));
  }

}
