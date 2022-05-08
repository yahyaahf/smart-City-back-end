package ma.uiass.eia.service;

import java.util.List;

import ma.uiass.eia.persistency.dao.ReservationDaoImp;
import ma.uiass.eia.persistency.entities.Employee;
import ma.uiass.eia.persistency.entities.Reservation;
import ma.uiass.eia.persistency.entities.WorkSpace;

public class ReservationService implements ReservationServiceInterface {
	private ReservationDaoImp reservationDao;
	public ReservationService() {
		this.reservationDao= new ReservationDaoImp();
	}
	@Override
	public List<Reservation> getAllReservations() {
		// TODO Auto-generated method stub
		return reservationDao.getAll();
	}

	@Override
	public Reservation getReservationById(long id) {
		// TODO Auto-generated method stub
		return this.reservationDao.getById(id);
	}

	@Override
	public void createReservation(String dateDebut, String dateFin, String heureDebut, String heureFin,
			WorkSpace workSpace, Employee employee) {
		this.reservationDao.create(new Reservation(dateDebut, dateFin, heureDebut, heureFin, workSpace, employee));
	}

}
