package ma.uiass.eia.persistency.entities;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class Client implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private long id;
	
	private String email;
	private String telephone;
	private String adress;
	@OneToMany(mappedBy ="client",fetch = FetchType.LAZY)
	@JsonIgnore
	private Collection<Location> locations;

	public Client() {
	}

	public Client(String email, String telephone, String adress) {
		this.email = email;
		this.telephone = telephone;
		this.adress = adress;
		//this.locations = new ArrayList<Location>() ;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Collection<Location> getLocations() {
		return locations;
	}

	public void setLocations(Collection<Location> locations) {
		this.locations = locations;
	}


	@Override
	public String toString() {
		return "Client [email=" + email + ", telephone=" + telephone + ", adress=" + adress + ", locations=" 
				+ "]";
	}


	
	
}
