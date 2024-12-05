package com.receptionistservice.service;

import java.util.List;

import com.receptionistservice.entity.Reservation;

public interface ReservationService {
	String addReservation(Reservation reservation);

	Reservation updateReservation(Reservation reservation);

	String deleteReservation(int id);

	Reservation getReservationById(int id);

	List<Reservation> getAllReservations();
}
