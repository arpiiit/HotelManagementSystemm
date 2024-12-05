package com.receptionistservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.receptionistservice.entity.Reservation;
import com.receptionistservice.exception.ReservationNotFoundWithIdException;
import com.receptionistservice.exception.RoomNotFoundWithRoomNoException;
import com.receptionistservice.repository.ReservationRepository;
import com.reservationservice.models.Room;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private SequenceGeneratorService seqService;


	@Override
	public String addReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		reservation.setReservationId(seqService.getSequenceNumber(Reservation.SEQUENCE_NAME));
		Room room=null;
		try {
		room = restTemplate.getForObject("http://localhost:8082/room/" + reservation.getRoomNo(), Room.class);
		}
		catch(HttpClientErrorException e)
		{
			throw new RoomNotFoundWithRoomNoException("Room Not Found with Room No "+reservation.getRoomNo());
		}
		if (room.isRoomAvail()) {
			reservationRepository.save(reservation);
			room.setRoomAvail(false);
			restTemplate.put("http://localhost:8082/room/update", room);
			return room.getRoomNo() + " is booked";
		}
		return "Room already booked";
	}

	@Override
	public Reservation updateReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		Optional<Reservation> foundReservation = reservationRepository.findById(reservation.getReservationId());
		if (foundReservation.isEmpty()) {
			throw new ReservationNotFoundWithIdException(
					"Reservation Not found with ID " + reservation.getReservationId());
		}
		return reservationRepository.save(reservation);
	}

	@Override
	public String deleteReservation(int id) {
		// TODO Auto-generated method stub
		Optional<Reservation> foundReservation = reservationRepository.findById(id);
		if (foundReservation.isEmpty()) {
			throw new ReservationNotFoundWithIdException("Reservation Not found with ID " + id);
		}
		reservationRepository.deleteById(id);
		return "Reservation deleted successfully with ID " + id;
	}

	@Override
	public Reservation getReservationById(int id) {
		// TODO Auto-generated method stub
		Optional<Reservation> foundReservation = reservationRepository.findById(id);
		if (foundReservation.isEmpty()) {
			throw new ReservationNotFoundWithIdException("Reservation Not found with ID " + id);
		}
		return foundReservation.get();
	}

	@Override
	public List<Reservation> getAllReservations() {
		// TODO Auto-generated method stub

		return reservationRepository.findAll();
	}

}
