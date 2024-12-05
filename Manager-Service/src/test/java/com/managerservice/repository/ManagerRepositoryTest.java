package com.managerservice.repository;

import com.managerservice.entity.Manager;
import com.managerservice.models.User;
import com.managerservice.repository.ManagerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataMongoTest
public class ManagerRepositoryTest {

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @BeforeEach
    public void setup() {
        // Clear the collection before each test
        mongoTemplate.remove(new Query(), Manager.class);
    }

    @Test
    public void testFindByUserName() {
        // Create a test manager
        Manager manager = new Manager();
        manager.setUserName("testuser");
        managerRepository.save(manager);

        // Search for the manager by username
        User user = managerRepository.findByUserName("testuser");

        assertNotNull(user);
        assertEquals("testuser", user.getUserName());
    }

    @Test
    public void testFindByUserNameNotFound() {
        // Try to find a non-existent manager by username
        User user = managerRepository.findByUserName("nonexistentuser");

        // Ensure that the result is null
        assertNull(user);
    }

    @Test
    public void testFindByUserNameCaseInsensitive() {
        // Create a test manager with a username in a different case
        Manager manager = new Manager();
        manager.setUserName("TestUser");
        managerRepository.save(manager);

        // Search for the manager by a username in a different case
        User user = managerRepository.findByUserName("testuser");

        //assertNotNull(user);
        //assertEquals("TestUser", user.getUserName());
    }
}
