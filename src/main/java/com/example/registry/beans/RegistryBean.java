package com.example.registry.beans;

import com.example.registry.models.Registry;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Local
@Stateless
public class RegistryBean {

    @PersistenceContext
    EntityManager db;

    public List<Registry> all()
    {
        return db.createNamedQuery("All Registries", Registry.class).getResultList();
    }

    public void persistRegistry(Registry registry)
    {
        db.persist(registry);
    }
}
