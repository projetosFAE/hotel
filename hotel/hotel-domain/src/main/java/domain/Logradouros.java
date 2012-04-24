/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

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
@Table(name = "logradouros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logradouros.findAll", query = "SELECT l FROM Logradouros l"),
    @NamedQuery(name = "Logradouros.findByLogradouro", query = "SELECT l FROM Logradouros l WHERE l.logradouro = :logradouro"),
    @NamedQuery(name = "Logradouros.findByLogradouroNome", query = "SELECT l FROM Logradouros l WHERE l.logradouroNome = :logradouroNome"),
    @NamedQuery(name = "Logradouros.findByLogradouroNumero", query = "SELECT l FROM Logradouros l WHERE l.logradouroNumero = :logradouroNumero")})
public class Logradouros implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "logradouro")
    private Integer logradouro;
    @Basic(optional = false)
    @Column(name = "logradouro_nome")
    private String logradouroNome;
    @Basic(optional = false)
    @Column(name = "logradouro_numero")
    private String logradouroNumero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "logradouros")
    private List<Cep> cepList;

    public Logradouros() {
    }

    public Logradouros(Integer logradouro) {
        this.logradouro = logradouro;
    }

    public Logradouros(Integer logradouro, String logradouroNome, String logradouroNumero) {
        this.logradouro = logradouro;
        this.logradouroNome = logradouroNome;
        this.logradouroNumero = logradouroNumero;
    }

    public Integer getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(Integer logradouro) {
        this.logradouro = logradouro;
    }

    public String getLogradouroNome() {
        return logradouroNome;
    }

    public void setLogradouroNome(String logradouroNome) {
        this.logradouroNome = logradouroNome;
    }

    public String getLogradouroNumero() {
        return logradouroNumero;
    }

    public void setLogradouroNumero(String logradouroNumero) {
        this.logradouroNumero = logradouroNumero;
    }

    @XmlTransient
    public List<Cep> getCepList() {
        return cepList;
    }

    public void setCepList(List<Cep> cepList) {
        this.cepList = cepList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logradouro != null ? logradouro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logradouros)) {
            return false;
        }
        Logradouros other = (Logradouros) object;
        if ((this.logradouro == null && other.logradouro != null) || (this.logradouro != null && !this.logradouro.equals(other.logradouro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Logradouros[ logradouro=" + logradouro + " ]";
    }
    
}
