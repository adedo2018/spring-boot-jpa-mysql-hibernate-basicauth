package com.example.usermedical.repository;

import com.example.usermedical.model.UserMedical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Fred Assi
 */
@Repository
public interface UserMedicalRepository extends JpaRepository<UserMedical, Long> {

}
