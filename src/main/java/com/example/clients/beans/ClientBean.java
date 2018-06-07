package com.example.clients.beans;

import com.example.clients.models.Client;
import com.example.users.models.User;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Local
@Stateless
public class ClientBean {


    @PersistenceContext
    EntityManager db;

    public List<Client> all()
    {

        return db.createNamedQuery("All Clients", Client.class).getResultList();

    }
}


