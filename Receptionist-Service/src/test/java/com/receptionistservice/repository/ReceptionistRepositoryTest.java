package com.receptionistservice.repository;

import com.receptionistservice.entity.Receptionist;
import com.receptionistservice.models.User;
import com.receptionistservice.repository.ReceptionistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataMongoTest
public class ReceptionistRepositoryTest {

    @Autowired
    private ReceptionistRepository receptionistRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @BeforeEach
    public void setup() {
        // Clear the collection before each test
        mongoTemplate.remove(new Query(), Receptionist.class);
    }

    @Test
    public void testFindByUserName() {
        // Create a test receptionist
        Receptionist receptionist = new Receptionist();
        receptionist.setUserName("testuser");
        receptionistRepository.save(receptionist);

        // Search for the receptionist by username
        User user = receptionistRepository.findByUserName("testuser");

        assertNotNull(user);
        assertEquals("testuser", user.getUserName());
    }

    @Test
    public void testFindByUserNameNotFound() {
        // Try to find a non-existent receptionist by username
        User user = receptionistRepository.findByUserName("nonexistentuser");

        // Ensure that the result is null
        assertNull(user);
    }   
}

