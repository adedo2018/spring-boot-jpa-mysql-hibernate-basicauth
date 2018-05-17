package com.example.usermedical.service;

import com.example.usermedical.exception.ResourceNotFoundException;
import com.example.usermedical.model.UserMedical;
import com.example.usermedical.repository.UserMedicalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Fred Assi
 */
@Service
public class UserMedicalService {

  @Autowired
  UserMedicalRepository userMedicalRepository;

  public UserMedicalService(UserMedicalRepository userMedicalRepository){
    this.userMedicalRepository = userMedicalRepository;
  }

  public List<UserMedical> getAllMedicalData() {
    return userMedicalRepository.findAll();
  }

  public UserMedical createMedicalData(UserMedical userMedical) {
    return userMedicalRepository.save(userMedical);
  }

  public UserMedical getMedicalDataById(Long id) {
    return userMedicalRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("user medical", "id", id));
  }

  public UserMedical updateMedicalData(Long id, UserMedical userMedical) {

    UserMedical medical = userMedicalRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("user medical", "id", id));

    medical.setName(userMedical.getName());
    medical.setSymptoms(userMedical.getSymptoms());

    UserMedical updatedMedical = userMedicalRepository.save(medical);
    return updatedMedical;
  }

  public ResponseEntity<?> deleteMedicalData(Long id) {
    UserMedical userMedical = userMedicalRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("user medical", "id", id));

    userMedicalRepository.delete(userMedical);

    return ResponseEntity.ok().build();
  }

}
