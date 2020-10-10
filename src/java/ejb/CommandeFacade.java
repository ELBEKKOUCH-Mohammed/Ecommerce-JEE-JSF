/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import jpa.Commande;
import jpa.Personne;
import jpa.Produit;

/**
 *
 * @author M.ELBEKKOUCH
 */
@Stateless
public class CommandeFacade extends AbstractFacade<Commande> {

    @PersistenceContext(unitName = "mohammedPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommandeFacade() {
        super(Commande.class);
    }
    
    public void adddetail(String personne,int produit){
       
      em.createNativeQuery("INSERT INTO Commande (idcommande,login) VALUES (?,?)")
      .setParameter(1, produit)
      .setParameter(2, personne)
      .executeUpdate();
    
}
     @Transactional
     public void ajouterpanier( Personne personne,Produit produit) {
       em.createNativeQuery("INSERT INTO Commande (idcommande,login) VALUES (?,?)")
      .setParameter(1, produit.getIdProduit())
      .setParameter(2, personne.getLogin())
      .executeUpdate();
    
}
     
      public  List<Produit> ProduitPersonnePanier(String login ){
   
          Query query = em.createQuery("SELECT p FROM Produit p,Commande c WHERE p.idProduit=c.idcommande and c.login = :login ");
        query.setParameter("login",login);
	    List<Produit> entity=query.getResultList();
	  
		return entity;
   
               }
      
            public  List<Produit> ProduitPersonneOrder(String login ){
   
          Query query = em.createQuery("SELECT p FROM Produit p,Commande c WHERE p.idProduit=c.idcommande and c.login = :login and c.etatreglement=true");
        query.setParameter("login",login);
	    List<Produit> entity=query.getResultList();
	  
		return entity;
   
               }
      
     
        public Commande deleteCommande( Personne personne,Produit produit) {
            
      Query q= em.createQuery("select  c from Commande c where c.login =:login AND c.idcommande=:id");
      
      q.setParameter("login",personne.getLogin());
      q.setParameter("id",produit.getIdProduit());
      Commande comd=(Commande)q.getSingleResult();
      return comd ; 
      
    }
        
            public void BuyOrder( Personne personne,Commande cmd,Produit pro) {
      em.createQuery("UPDATE Commande c SET c.etatreglement=1 ,c.payeLivraison="+cmd.getPayeLivraison()+
            ",c.villeLivraison="+cmd.getVilleLivraison()+
            ",c.adressLivraison="+cmd.getAdressLivraison()+
            ",c.qte="+cmd.getQte()+
            " WHERE c.login=:login and c.idcommande=:idcommande")
      .setParameter("login", personne.getLogin())
      .setParameter("idcommande", +pro.getIdProduit())
      .executeUpdate();
      
}

}
