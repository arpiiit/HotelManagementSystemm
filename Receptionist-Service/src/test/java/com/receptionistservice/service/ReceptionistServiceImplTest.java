package com.receptionistservice.service;

import com.receptionistservice.entity.Receptionist;
import com.receptionistservice.repository.ReceptionistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class ReceptionistServiceImplTest {

    @InjectMocks
    private ReceptionistServiceImpl receptionistService;

    @Mock
    private ReceptionistRepository receptionistRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllReceptionists() {
        List<Receptionist> receptionistList = List.of(new Receptionist(), new Receptionist());
        when(receptionistRepository.findAll()).thenReturn(receptionistList);

        List<Receptionist> retrievedReceptionists = receptionistService.getAllReceptionists();

        assertNotNull(retrievedReceptionists);
        assertEquals(receptionistList, retrievedReceptionists);
    }

    @Test
    public void testAddReceptionist() {
        Receptionist receptionist = new Receptionist();
        when(receptionistRepository.save(receptionist)).thenReturn(receptionist);

        Receptionist addedReceptionist = receptionistService.addReceptionist(receptionist);

        assertNotNull(addedReceptionist);
        assertEquals(receptionist, addedReceptionist);
    }
}
