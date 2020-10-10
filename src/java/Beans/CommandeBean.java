/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import ejb.CommandeFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import jpa.Commande;
import jpa.Personne;
import jpa.Produit;

/**
 *
 * @author M.ELBEKKOUCH
 */
@Named(value = "commandeBean")
@ApplicationScoped
public class CommandeBean {

        @EJB
private CommandeFacade ComEJB;
private Commande ComEntity;
private Commande ComselectedEntity;

@PostConstruct
public void init(){
    ComEntity=new Commande();
}

    public Commande getComEntity() {
        return ComEntity;
    }

    public void setComselectedEntity(Commande ComselectedEntity) {
        this.ComselectedEntity = ComselectedEntity;
    }

    public Commande getComselectedEntity() {
        return ComselectedEntity;
    }

    public void setComEntity(Commande ComEntity) {
        this.ComEntity = ComEntity;
    }
    
    /**
     * Creates a new instance of CommandeBean
     */
    public CommandeBean() {
    }
    
     public String add(String personne,int produit){
        ComEJB.adddetail(personne,produit);
           return "panier"; 
        
    }
    
     public String add1(Personne personne,Produit produit){
        ComEJB.ajouterpanier(personne, produit);
           return "panier"; 
        
    }
    
    public List<Produit> panierpersonne(String login) {
        return ComEJB.ProduitPersonnePanier(login);
    }
    
     public List<Produit> Orderpersonne(String login) {
        return ComEJB.ProduitPersonneOrder(login);
    }
    
    public String delate(Personne personne,Produit produit){
        ComEJB.remove(ComEJB.deleteCommande(personne, produit));
        return "panier";
    }
    
     
    
     public String Buy(Personne personne,Commande cmd,Produit pro){
         
        ComEJB.BuyOrder(personne,cmd,pro);
        return "order";
    }
     
     public void editCmd(){
         ComEJB.edit(ComEntity);
     }
        
     public float somtotale(Commande cmd,Produit pro){
        
         return cmd.getQte()*pro.getPrixVent();
     }
}
