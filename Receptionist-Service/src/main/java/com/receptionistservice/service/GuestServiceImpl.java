package com.receptionistservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.receptionistservice.entity.Guest;
import com.receptionistservice.exception.GuestNotAvailableException;
import com.receptionistservice.exception.GuestNotFoundWithIdException;
import com.receptionistservice.exception.InvalidAdharNumberException;
import com.receptionistservice.exception.InvalidEmailAddressException;
import com.receptionistservice.exception.InvalidMobileNumberException;
import com.receptionistservice.repository.GuestRepository;

@Service
public class GuestServiceImpl implements GuestService {
	
	@Autowired
	private GuestRepository guestRepository;
	
	@Autowired
	private SequenceServiceImpl sequence;

	@Override
	public Guest addGuest(Guest guest) {
		// TODO Auto-generated method stub
		guest.setGuestId(sequence.getSequenceNumber(Guest.SEQUENCE_NAME));
		if(guest.getGuestMobile().matches("^[6-9]{1}[0-9]{9}$"))
		{
			if(guest.getGuestEmail().matches("^[A-Za-z]*[0-9]*[@]{1}[a-z]*[.]{1}[a-z]*$"))
			{
				if(guest.getGuestGovtId().matches("^[2-9]{1}[0-9]{11}$"))
				{
			return guestRepository.save(guest);
				}
				else 
					throw new InvalidAdharNumberException("Adhar number is invalid");
			}
			else
				throw new InvalidEmailAddressException("Email is Inavlid");
		}
		else
			throw new InvalidMobileNumberException("Mobile number is Invalid");
		
	}

	@Override
	public Guest updateGuest(Guest guest) {
		// TODO Auto-generated method stub
		Optional<Guest> guestFound=guestRepository.findById(guest.getGuestId());
		if(guestFound.isEmpty())
		{
			throw new GuestNotFoundWithIdException("Guest not found with ID "+guest.getGuestId());
		}
		if(guest.getGuestMobile().matches("^[6-9]{1}[0-9]{9}$"))
		{
			if(guest.getGuestEmail().matches("^[A-Za-z]*[0-9]*[@]{1}[a-z]*[.]{1}[a-z]*$"))
			{
				Guest updatedGuest=guestRepository.save(guest);
				return updatedGuest;
			}
			else
				throw new InvalidEmailAddressException("Email is Inavlid");
		}
		else
			throw new InvalidMobileNumberException("Mobile number is Invalid");
		
	}

	@Override
	public Guest getByGuestId(int id) {
		// TODO Auto-generated method stub
		Optional<Guest> guest=guestRepository.findById(id);
		if(guest.isEmpty())
		{
			throw new GuestNotFoundWithIdException("Guest not found with ID "+id);
		}
		return guest.get();
	}

	@Override
	public List<Guest> getAllGuests() {
		// TODO Auto-generated method stub
		List<Guest> list=guestRepository.findAll();
		if(list.isEmpty())
		{
			throw new GuestNotAvailableException("No guests are present in database");
		}
		return list;
	}

	@Override
	public String deleteGuest(int id) {
		// TODO Auto-generated method stub
		Optional<Guest> guest=guestRepository.findById(id);
		if(guest.isEmpty())
		{
			throw new GuestNotFoundWithIdException("Guest not found with ID "+id);
		}
		guestRepository.deleteById(id);
		return "Successfully deleted guest with ID "+id;
	}

}
