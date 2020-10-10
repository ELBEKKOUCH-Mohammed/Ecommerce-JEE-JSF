/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jpa.Personne;

/**
 *
 * @author M.ELBEKKOUCH
 */
@Stateless
public class PersonneFacade extends AbstractFacade<Personne> {

    @PersistenceContext(unitName = "mohammedPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonneFacade() {
        super(Personne.class);
    }
    
    public Personne verifier(String login ,String passwd){
         
        Query q1=em.createNamedQuery("Personne.login");
        q1.setParameter("login", login);
        q1.setParameter("password", passwd);
        Personne list= (Personne) q1.getSingleResult();
        return list;
       }
    
}
