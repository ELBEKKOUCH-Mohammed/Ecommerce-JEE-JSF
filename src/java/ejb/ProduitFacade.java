/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jpa.Produit;

/**
 *
 * @author M.ELBEKKOUCH
 */
@Stateless
public class ProduitFacade extends AbstractFacade<Produit> {

    @PersistenceContext(unitName = "mohammedPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProduitFacade() {
        super(Produit.class);
    }
    
       public List<Produit> RecupererlistBYlib(String libelle){
           
          
               
          
               Query q=em.createNamedQuery("Produit.findByLibelle");
               q.setParameter("libelle","%"+libelle+"%" );
               List<Produit> lists=q.getResultList();
               return lists;
           
             
       }
    
        public  List<Produit> top5(){
                   
            Query query = em.createQuery("SELECT p  FROM Produit AS p,Commande AS c WHERE p.idProduit=c.idcommande GROUP BY p order by COUNT(p) DESC");
	    
	List<Produit> entity=query.setMaxResults(5).getResultList();
         
		return entity;
        
               }
}
