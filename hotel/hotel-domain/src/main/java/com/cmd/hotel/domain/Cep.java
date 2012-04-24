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
@Table(name = "cep")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cep.findAll", query = "SELECT c FROM Cep c"),
    @NamedQuery(name = "Cep.findByCep", query = "SELECT c FROM Cep c WHERE c.cep = :cep")})
public class Cep implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cep")
    private Integer cep;
    @JoinColumn(name = "logradouro", referencedColumnName = "logradouro")
    @ManyToOne(optional = false)
    private Logradouros logradouro;
    @JoinColumn(name = "cidade", referencedColumnName = "cidade")
    @ManyToOne(optional = false)
    private Cidades cidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cep")
    private List<Logradouroxusuario> logradouroxusuarioList;

    public Cep() {
    }

    public Cep(Integer cep) {
        this.cep = cep;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public Logradouros getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(Logradouros logradouro) {
        this.logradouro = logradouro;
    }

    public Cidades getCidade() {
        return cidade;
    }

    public void setCidade(Cidades cidade) {
        this.cidade = cidade;
    }

    @XmlTransient
    public List<Logradouroxusuario> getLogradouroxusuarioList() {
        return logradouroxusuarioList;
    }

    public void setLogradouroxusuarioList(List<Logradouroxusuario> logradouroxusuarioList) {
        this.logradouroxusuarioList = logradouroxusuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cep != null ? cep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cep)) {
            return false;
        }
        Cep other = (Cep) object;
        if ((this.cep == null && other.cep != null) || (this.cep != null && !this.cep.equals(other.cep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cmd.hoteldomain.domain.Cep[ cep=" + cep + " ]";
    }
    
}
