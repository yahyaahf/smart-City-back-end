package ma.uiass.eia.persistency.dao;

import ma.uiass.eia.persistency.entities.Equipement;
import ma.uiass.eia.persistency.entities.Ville;

import javax.persistence.*;
import java.util.List;

public class EquipementDaoImp implements  IDAO<Equipement> {
    private EntityManager entityManager;

    public EquipementDaoImp() {
        EntityManagerFactory factory= Persistence.createEntityManagerFactory("PU_SC");


        entityManager = factory.createEntityManager();
    }
    @Override
    public void create(Equipement object) {
        EntityTransaction transaction= entityManager.getTransaction();
        try {
            transaction.begin();
            this.entityManager.persist(object);
            transaction.commit();
        }
        catch(Exception e) {
            transaction.rollback();
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void update(Equipement object, long id) {

    }

    @Override
    public Equipement getById(long id) {
        return entityManager.find(Equipement.class, id);
    }

    @Override
    public void delete(Equipement object) {
        this.entityManager.remove(object);

    }

    @Override
    public List<Equipement> getAll() {
        Query query = entityManager.createQuery("select v from Equipement v");

        return query.getResultList();
    }
}
