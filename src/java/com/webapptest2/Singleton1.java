/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.webapptest2;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.*;

/**
 *
 * @author David
 */
@Singleton
@Startup
public class Singleton1 {
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebAppTest2PU");
    private EntityManager em;
    private EntityTransaction tx;
    
    public Singleton1() {
        /*
        em = emf.createEntityManager();
        tx = em.getTransaction();
        tx.begin();
        Users testSubject = new Users(null, "Magma", "Magma", "Magma", "Magma");
        em.persist(testSubject);
        tx.commit();
        em.close();*/
    }
}
