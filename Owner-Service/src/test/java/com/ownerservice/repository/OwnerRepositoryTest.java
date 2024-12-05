package com.ownerservice.repository;

import com.ownerservice.models.Owner;
import com.ownerservice.models.User;
import com.ownerservice.repository.OwnerRepository;
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
public class OwnerRepositoryTest {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @BeforeEach
    public void setup() {
        // Clear the collection before each test
        mongoTemplate.remove(new Query(), Owner.class);
    }

    @Test
    public void testFindByUserName() {
        // Create a test owner
        Owner owner = new Owner();
        owner.setUserName("testuser");
        ownerRepository.save(owner);

        // Search for the owner by username
        User user = ownerRepository.findByUserName("testuser");

        assertNotNull(user);
        assertEquals("testuser", user.getUserName());
    }

    @Test
    public void testFindByUserNameNotFound() {
        // Try to find a non-existent owner by username
        User user = ownerRepository.findByUserName("nonexistentuser");

        // Ensure that the result is null
        assertNull(user);
    }

    @Test
    public void testFindByUserNameCaseInsensitive() {
        // Create a test owner with a username in a different case
        Owner owner = new Owner();
        owner.setUserName("TestUser");
        ownerRepository.save(owner);

        // Search for the owner by a username in a different case
        User user = ownerRepository.findByUserName("testuser");

    }

}
