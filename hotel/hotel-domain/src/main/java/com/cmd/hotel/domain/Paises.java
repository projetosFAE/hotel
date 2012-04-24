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
@Table(name = "paises")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paises.findAll", query = "SELECT p FROM Paises p"),
    @NamedQuery(name = "Paises.findByPais", query = "SELECT p FROM Paises p WHERE p.pais = :pais"),
    @NamedQuery(name = "Paises.findByPaisNome", query = "SELECT p FROM Paises p WHERE p.paisNome = :paisNome")})
public class Paises implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pais")
    private Integer pais;
    @Basic(optional = false)
    @Column(name = "pais_nome")
    private String paisNome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pais")
    private List<Estados> estadosList;

    public Paises() {
    }

    public Paises(Integer pais) {
        this.pais = pais;
    }

    public Paises(Integer pais, String paisNome) {
        this.pais = pais;
        this.paisNome = paisNome;
    }

    public Integer getPais() {
        return pais;
    }

    public void setPais(Integer pais) {
        this.pais = pais;
    }

    public String getPaisNome() {
        return paisNome;
    }

    public void setPaisNome(String paisNome) {
        this.paisNome = paisNome;
    }

    @XmlTransient
    public List<Estados> getEstadosList() {
        return estadosList;
    }

    public void setEstadosList(List<Estados> estadosList) {
        this.estadosList = estadosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pais != null ? pais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paises)) {
            return false;
        }
        Paises other = (Paises) object;
        if ((this.pais == null && other.pais != null) || (this.pais != null && !this.pais.equals(other.pais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cmd.hoteldomain.domain.Paises[ pais=" + pais + " ]";
    }
    
}
