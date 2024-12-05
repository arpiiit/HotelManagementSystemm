package com.guestservice.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import javax.ws.rs.core.Application;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.receptionistservice.entity.Guest;
import com.receptionistservice.exception.InvalidEmailAddressException;
import com.receptionistservice.exception.InvalidMobileNumberException;
import com.receptionistservice.repository.GuestRepository;
import com.receptionistservice.service.GuestService;
import com.receptionistservice.service.GuestServiceImpl;

@SpringBootTest(classes = Application.class)
public class GuestServiceTest {
	@InjectMocks
	private GuestService guestService = new GuestServiceImpl();

	@Mock
	private GuestRepository guestRepository;

	@Test
	void testSaveGuest() {
		Guest guest = new Guest();
		guest.setGuestId(1);
		guest.setGuestName("abc");
		guest.setGuestMobile("6789543210");
		guest.setGuestEmail("abc@gmail.com");
		guest.setGuestGovtId("234567890123");
		guest.setGuestAddress("Hyderabad");
		when(guestRepository.save(guest)).thenReturn(guest);
		
	}

	@Test
	void testViewByGuestId() {
		Guest guest = new Guest();
		guest.setGuestId(1);
		guest.setGuestName("abc");
		guest.setGuestMobile("6789543210");
		guest.setGuestEmail("abc1@gmail.com");
		guest.setGuestGovtId("234567890123");
		guest.setGuestAddress("Hyderabad");
		Optional<Guest> optionalGuest = Optional.of(guest);
		when(guestRepository.findById(1)).thenReturn(optionalGuest);
		Guest guest1 = guestService.getByGuestId(1);
		verify(guestRepository, times(1)).findById(1);
		assertEquals("abc", guest1.getGuestName());

	}

	@Test
	void testUpdateGuest() {
		Guest guest = new Guest();
		guest.setGuestId(1);
		guest.setGuestName("abc");
		guest.setGuestMobile("6789543210");
		guest.setGuestEmail("abc1@gmail.com");
		guest.setGuestGovtId("234567890123");
		guest.setGuestAddress("Hyderabad");
		Optional<Guest> optionalGuest = Optional.of(guest);
		when(guestRepository.findById(1)).thenReturn(optionalGuest);
		guestService.updateGuest(guest);
		verify(guestRepository, times(1)).findById(1);
		verify(guestRepository, times(1)).save(guest);
	}

	@Test
	void testDeleteGuest() {
		Guest guest = new Guest();
		guest.setGuestId(1);
		guest.setGuestName("abc");
		guest.setGuestMobile("6789543210");
		guest.setGuestEmail("abc1@gmail.com");
		guest.setGuestGovtId("234567890123");
		guest.setGuestAddress("Hyderabad");
		Optional<Guest> optionalGuest = Optional.of(guest);
		when(guestRepository.findById(1)).thenReturn(optionalGuest);
		guestService.deleteGuest(1);
		verify(guestRepository, times(1)).findById(1);
		verify(guestRepository, times(1)).deleteById(1);

	}

	@Test
	void testInvalidMobile() {
		Guest guest = new Guest();
		guest.setGuestId(1);
		guest.setGuestName("abc");
		guest.setGuestMobile("5789543210");
		guest.setGuestEmail("abc1@gmail.com");
		guest.setGuestGovtId("234567890123");
		guest.setGuestAddress("Hyderabad");
		when(guestRepository.save(guest)).thenThrow(InvalidMobileNumberException.class);
	}

	@Test
	void testInvalidEmail() {
		Guest guest = new Guest();
		guest.setGuestId(1);
		guest.setGuestName("abc");
		guest.setGuestMobile("6789543210");
		guest.setGuestEmail("abc#1@gmail.com");
		guest.setGuestGovtId("234567890123");
		guest.setGuestAddress("Hyderabad");
		when(guestRepository.save(guest)).thenThrow(InvalidEmailAddressException.class);
		
	}
}
