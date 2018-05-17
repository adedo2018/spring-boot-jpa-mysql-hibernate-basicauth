package com.example.usermedical;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.example.usermedical.model.User;
import com.example.usermedical.repository.UserRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserMedicalApplication.class)
public class SpringBootJPAIntegrationTest {
  
    @Autowired
    private UserRepository userRepository;
 
    @Test
    public void givenUserRepository_whenSaveAndRetreiveEntity_thenOK() {

        User user = new User();
        user.setId(1L);
        user.setFirstName("user");
        user.setLastName("user");
        user.setUsername("username");

        userRepository.save(user);

        User firstUser = userRepository.findByUsername("username");
        assertNotNull(firstUser);
        assertEquals(user, firstUser);
    }
}