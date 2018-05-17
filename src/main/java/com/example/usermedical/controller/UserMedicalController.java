package com.example.usermedical.controller;

import com.example.usermedical.model.UserMedical;
import com.example.usermedical.service.UserMedicalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/medical")
public class UserMedicalController {

    @Autowired
    UserMedicalService userMedicalService;

    public UserMedicalController(UserMedicalService userMedicalService){
        this.userMedicalService = userMedicalService;
    }

    @GetMapping("/symptoms")
    public List<UserMedical> getAllMedicalData() {
        return userMedicalService.getAllMedicalData();
    }

    @PostMapping("/symptoms")
    public UserMedical createMedicalData(@Valid @RequestBody UserMedical userMedical) {
        return userMedicalService.createMedicalData(userMedical);
    }

    @GetMapping("/symptoms/{id}")
    public UserMedical getMedicalDataById(@PathVariable(value = "id") Long id) {
        return userMedicalService.getMedicalDataById(id);
    }

    @PutMapping("/symptoms/{id}")
    public UserMedical updateMedicalData(@PathVariable(value = "id") Long id,
                                  @Valid @RequestBody UserMedical userMedical) {
        return userMedicalService.updateMedicalData(id, userMedical);
    }

    @DeleteMapping("/symptoms/{id}")
    public ResponseEntity<?> deleteMedicalData(@PathVariable(value = "id") Long id) {
        userMedicalService.deleteMedicalData(id);
        return ResponseEntity.ok().build();
    }
}
