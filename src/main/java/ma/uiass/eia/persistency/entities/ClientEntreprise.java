package ma.uiass.eia.persistency.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.google.gson.annotations.Expose;


@Entity

public class ClientEntreprise  extends Client implements Serializable{
	@Expose
	private String formeJuridique;
	@Expose
    private String patente;
	@OneToMany(mappedBy = "entreprise")
	private Collection<Employee> employees;
   
    public Collection<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Collection<Employee> employees) {
		this.employees = employees;
	}

	public ClientEntreprise() {

    }

    public ClientEntreprise(String email, String telephone, String adress, String formeJuridique, String patente) {
        super(email, telephone, adress);
        this.formeJuridique = formeJuridique;
        this.patente = patente;
    }

	public String getFormeJuridique() {
		return formeJuridique;
	}

	public void setFormeJuridique(String formeJuridique) {
		this.formeJuridique = formeJuridique;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	@Override
	public String toString() {
		return "ClientEntreprise [formeJuridique=" + formeJuridique + ", patente=" + patente + ", toString()="
				+ super.toString() + "]";
	}
    
    
}
