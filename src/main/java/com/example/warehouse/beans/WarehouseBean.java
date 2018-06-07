package com.example.warehouse.beans;

import com.example.warehouse.models.Warehouse;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Local
@Stateless
public class WarehouseBean {

    @PersistenceContext
    EntityManager db;

    public List<Warehouse> all()
    {
        return db.createNamedQuery("All warehouses", Warehouse.class).getResultList();
    }

    public Warehouse byId(long id)
    {
        return db.find(Warehouse.class,id);
    }

    public void persistWarehouse(Warehouse warehouse)
    {
        db.persist(warehouse);
    }

    public void mergeWarehouse(Warehouse warehouse)
    {
        db.merge(warehouse);
    }

}
