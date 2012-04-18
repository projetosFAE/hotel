/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmd.hotel.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AlexPorto
 */
@Entity
@Table(name = "cardapiotipos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cardapiotipos.findAll", query = "SELECT c FROM Cardapiotipos c"),
    @NamedQuery(name = "Cardapiotipos.findByCardapioTipo", query = "SELECT c FROM Cardapiotipos c WHERE c.cardapioTipo = :cardapioTipo"),
    @NamedQuery(name = "Cardapiotipos.findByCardapioTiponome", query = "SELECT c FROM Cardapiotipos c WHERE c.cardapioTiponome = :cardapioTiponome")})
public class Cardapiotipos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cardapioTipo")
    private Integer cardapioTipo;
    @Basic(optional = false)
    @Column(name = "cardapioTipo_nome")
    private String cardapioTiponome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cardapioTipo")
    private List<Cardapios> cardapiosList;

    public Cardapiotipos() {
    }

    public Cardapiotipos(Integer cardapioTipo) {
        this.cardapioTipo = cardapioTipo;
    }

    public Cardapiotipos(Integer cardapioTipo, String cardapioTiponome) {
        this.cardapioTipo = cardapioTipo;
        this.cardapioTiponome = cardapioTiponome;
    }

    public Integer getCardapioTipo() {
        return cardapioTipo;
    }

    public void setCardapioTipo(Integer cardapioTipo) {
        this.cardapioTipo = cardapioTipo;
    }

    public String getCardapioTiponome() {
        return cardapioTiponome;
    }

    public void setCardapioTiponome(String cardapioTiponome) {
        this.cardapioTiponome = cardapioTiponome;
    }

    @XmlTransient
    public List<Cardapios> getCardapiosList() {
        return cardapiosList;
    }

    public void setCardapiosList(List<Cardapios> cardapiosList) {
        this.cardapiosList = cardapiosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cardapioTipo != null ? cardapioTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cardapiotipos)) {
            return false;
        }
        Cardapiotipos other = (Cardapiotipos) object;
        if ((this.cardapioTipo == null && other.cardapioTipo != null) || (this.cardapioTipo != null && !this.cardapioTipo.equals(other.cardapioTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cmd.hoteldomain.domain.Cardapiotipos[ cardapioTipo=" + cardapioTipo + " ]";
    }
    
}
