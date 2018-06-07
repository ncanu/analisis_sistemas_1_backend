package com.example.bank.beans;

import com.example.bank.models.Bank;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Local
@Stateless
public class BankBean {

    @PersistenceContext
    EntityManager db;

    public List<Bank> all()
    {

        return db.createNamedQuery("All Banks", Bank.class).getResultList();

    }

}
