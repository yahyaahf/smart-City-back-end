package ma.uiass.eia.persistency.entities;

import com.google.gson.annotations.Expose;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;
@Entity
@Table(name="AILEEYAGE")
public class AileEtage extends Element {
    public AileEtage(){}
    public AileEtage(Collection<WorkSpace> workSpaces){
        this.workSpaces=workSpaces;
    }
    @OneToMany
    private Collection<WorkSpace> workSpaces ;

    public Collection<WorkSpace> getWorkSpaces() {
        return workSpaces;
    }

    public void setWorkSpaces(Collection<WorkSpace> workSpaces) {
        this.workSpaces = workSpaces;
    }
    public long getId() {
        return super.getId();
    }

    public void setId(long id) {
        super.setId(id);
    }
}

