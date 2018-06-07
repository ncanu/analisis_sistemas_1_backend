package com.example.product.beans;

import com.example.product.models.Inventory;
import com.example.product.models.Product;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Local
@Stateless
public class InventoryBean {

    @PersistenceContext
    EntityManager db;

    public List<Product> allProducts()
    {
        return db.createNamedQuery("All products", Product.class).getResultList();
    }

    public Product productById(long id)
    {
        return db.find(Product.class,id);
    }

    public List<Inventory> InventoryByWarehouse(long warehouseId)
    {
        return db.createNamedQuery("All inventory by warehouse", Inventory.class).setParameter("warehouseId",warehouseId).getResultList();
    }
}
