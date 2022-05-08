package ma.uiass.eia.service;

import java.util.List;

import ma.uiass.eia.persistency.entities.Employee;
import ma.uiass.eia.persistency.entities.Reservation;

import ma.uiass.eia.persistency.entities.WorkSpace;

public interface ReservationServiceInterface {
	List<Reservation> getAllReservations();

	Reservation getReservationById(long id);

	void createReservation(String dateDebut, String dateFin, String heureDebut, String heureFin, WorkSpace workSpace,
			Employee employee);

}
