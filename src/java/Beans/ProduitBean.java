/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import ejb.ProduitFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import jpa.Produit;

/**
 *
 * @author M.ELBEKKOUCH
 */
@Named(value = "produitBean")
@ApplicationScoped
public class ProduitBean {
  @EJB
private ProduitFacade ProEJB;
private Produit ProEntity;
private Produit selectedProEntity;
private String search;

    public void setProEntity(Produit ProEntity) {
        this.ProEntity = ProEntity;
    }

    public void setSelectedProEntity(Produit selectedProEntity) {
        this.selectedProEntity = selectedProEntity;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Produit getProEntity() {
        return ProEntity;
    }

    public Produit getSelectedProEntity() {
        return selectedProEntity;
    }

    public String getSearch() {
        return search;
    }

    /**
     * Creates a new instance of ProduitBean
     */
    public ProduitBean() {
    }
    
    @PostConstruct
    public void init() {
        ProEntity = new Produit();
        selectedProEntity=new Produit();
           }
    
     public List<Produit> listeProduit(){
        return ProEJB.findAll();
    }
    public List<Produit> listeProduitBysearch(){
        
   return ProEJB.RecupererlistBYlib(getSearch());
            
    }
    public String Produit(){
        return "detailproduit";
    }
     public List<Produit> top5(){
        return ProEJB.top5();
    }

}
