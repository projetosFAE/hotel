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
@Table(name = "camas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Camas.findAll", query = "SELECT c FROM Camas c"),
    @NamedQuery(name = "Camas.findByCama", query = "SELECT c FROM Camas c WHERE c.cama = :cama"),
    @NamedQuery(name = "Camas.findByCamaNome", query = "SELECT c FROM Camas c WHERE c.camaNome = :camaNome")})
public class Camas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cama")
    private Integer cama;
    @Basic(optional = false)
    @Column(name = "cama_nome")
    private String camaNome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cama")
    private List<Quartoxcamas> quartoxcamasList;

    public Camas() {
    }

    public Camas(Integer cama) {
        this.cama = cama;
    }

    public Camas(Integer cama, String camaNome) {
        this.cama = cama;
        this.camaNome = camaNome;
    }

    public Integer getCama() {
        return cama;
    }

    public void setCama(Integer cama) {
        this.cama = cama;
    }

    public String getCamaNome() {
        return camaNome;
    }

    public void setCamaNome(String camaNome) {
        this.camaNome = camaNome;
    }

    @XmlTransient
    public List<Quartoxcamas> getQuartoxcamasList() {
        return quartoxcamasList;
    }

    public void setQuartoxcamasList(List<Quartoxcamas> quartoxcamasList) {
        this.quartoxcamasList = quartoxcamasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cama != null ? cama.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Camas)) {
            return false;
        }
        Camas other = (Camas) object;
        if ((this.cama == null && other.cama != null) || (this.cama != null && !this.cama.equals(other.cama))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cmd.hoteldomain.domain.Camas[ cama=" + cama + " ]";
    }
    
}
