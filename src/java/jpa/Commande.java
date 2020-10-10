/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author M.ELBEKKOUCH
 */
@Entity
@Table(name = "commande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c")
    , @NamedQuery(name = "Commande.findByIdcommande", query = "SELECT c FROM Commande c WHERE c.idcommande = :idcommande")
    , @NamedQuery(name = "Commande.findByLogin", query = "SELECT c FROM Commande c WHERE c.login = :login")
    , @NamedQuery(name = "Commande.findByAdressLivraison", query = "SELECT c FROM Commande c WHERE c.adressLivraison = :adressLivraison")
    , @NamedQuery(name = "Commande.findByVilleLivraison", query = "SELECT c FROM Commande c WHERE c.villeLivraison = :villeLivraison")
    , @NamedQuery(name = "Commande.findByPayeLivraison", query = "SELECT c FROM Commande c WHERE c.payeLivraison = :payeLivraison")
    , @NamedQuery(name = "Commande.findByQte", query = "SELECT c FROM Commande c WHERE c.qte = :qte")
    , @NamedQuery(name = "Commande.findByEtatlivraison", query = "SELECT c FROM Commande c WHERE c.etatlivraison = :etatlivraison")
    , @NamedQuery(name = "Commande.findByEtatreglement", query = "SELECT c FROM Commande c WHERE c.etatreglement = :etatreglement")})
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcommande")
    private Integer idcommande;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "login")
    private String login;
    @Size(max = 255)
    @Column(name = "adressLivraison")
    private String adressLivraison;
    @Size(max = 100)
    @Column(name = "villeLivraison")
    private String villeLivraison;
    @Size(max = 100)
    @Column(name = "payeLivraison")
    private String payeLivraison;
    @Column(name = "qte")
    private Integer qte;
    @Column(name = "etatlivraison")
    private Boolean etatlivraison;
    @Column(name = "etatreglement")
    private Boolean etatreglement;

    public Commande() {
    }

    public Commande(Integer idcommande) {
        this.idcommande = idcommande;
    }

    public Commande(Integer idcommande, String login) {
        this.idcommande = idcommande;
        this.login = login;
    }

    public Integer getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(Integer idcommande) {
        this.idcommande = idcommande;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAdressLivraison() {
        return adressLivraison;
    }

    public void setAdressLivraison(String adressLivraison) {
        this.adressLivraison = adressLivraison;
    }

    public String getVilleLivraison() {
        return villeLivraison;
    }

    public void setVilleLivraison(String villeLivraison) {
        this.villeLivraison = villeLivraison;
    }

    public String getPayeLivraison() {
        return payeLivraison;
    }

    public void setPayeLivraison(String payeLivraison) {
        this.payeLivraison = payeLivraison;
    }

    public Integer getQte() {
        return qte;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
    }

    public Boolean getEtatlivraison() {
        return etatlivraison;
    }

    public void setEtatlivraison(Boolean etatlivraison) {
        this.etatlivraison = etatlivraison;
    }

    public Boolean getEtatreglement() {
        return etatreglement;
    }

    public void setEtatreglement(Boolean etatreglement) {
        this.etatreglement = etatreglement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcommande != null ? idcommande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.idcommande == null && other.idcommande != null) || (this.idcommande != null && !this.idcommande.equals(other.idcommande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Commande[ idcommande=" + idcommande + " ]";
    }
    
}
