/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import ejb.PersonneFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import jpa.Personne;

/**
 *
 * @author M.ELBEKKOUCH
 */
@Named(value = "personneBean")
@SessionScoped
public class PersonneBean implements Serializable {
     private static final long serialVersionUID = 3456788L;
@EJB
private PersonneFacade PerEJB;
private Personne PerEntity;
private String search;
private Personne selectedPersonne;


    public Personne getPerEntity() {
        return PerEntity;
    }

    public String getSearch() {
        return search;
    }

    /**
     * Creates a new instance of PersonneBean
     */
    public Personne getSelectedPersonne() {
        return selectedPersonne;
    }

    public void setPerEntity(Personne PerEntity) {
        this.PerEntity = PerEntity;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public void setSelectedPersonne(Personne selectedPersonne) {
        this.selectedPersonne = selectedPersonne;
    }

    public PersonneBean() {
    }
    
    @PostConstruct
    public void init() {
        PerEntity = new Personne();
        selectedPersonne =new Personne();
                }
    
    public String login(){
    
    if(PerEJB.verifier(PerEntity.getLogin(), PerEntity.getPassword())!=null){
        setPerEntity(PerEJB.verifier(PerEntity.getLogin(), PerEntity.getPassword()));
       return "accueil";
   }else{
        return "index";
    }
    
}
      public String Register(){
       PerEJB.create(PerEntity);
       return "authentification";
    }
    public  String edit(){
        PerEJB.edit(PerEntity);
        return "Mycount";
            }
     public String logout(){
        Personne p=new Personne();
        setPerEntity(p);
        return "accueil";
            }
}
