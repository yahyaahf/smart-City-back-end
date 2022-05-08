package ma.uiass.eia.persistency.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "RESERVATION")
public class Reservation {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Expose
    private long id;

    @Expose
    private String dateDebut;
    @Expose
    private String dateFin ;
    @Expose
    private String heureDebut ;
    @Expose
    private String heureFin ;
    @OneToOne
    private WorkSpace workSpace;
    @OneToOne
    private Employee employee;

    public long getId() {
        return id;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

    public Reservation() {
    }

	public Reservation(String dateDebut, String dateFin, String heureDebut, String heureFin, WorkSpace workSpace,
			Employee employee) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.workSpace = workSpace;
		this.employee = employee;
	}
    

}
