package ma.uiass.eia.persistency.entities;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.Collection;
@Entity
public class AileEtage extends Element {
    public AileEtage(){}
    public AileEtage(Collection<WorkSpace> workSpaces){
        this.workSpaces=workSpaces;
    }
    @ManyToMany
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

    @Override
    public double getPrice() {
        double price=0;
        for(WorkSpace elm : this.workSpaces){
            price+=elm.getPrice();
        }
        return (double)(price);
    }
}

