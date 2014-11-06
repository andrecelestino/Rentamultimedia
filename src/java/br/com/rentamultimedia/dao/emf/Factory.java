package br.com.rentamultimedia.dao.emf;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Factory {
    
    private EntityManagerFactory emf;
    
    public EntityManagerFactory getFactory(){
        emf=Persistence.createEntityManagerFactory("RentamultimediaPU");
        return emf;
    }
    
}
