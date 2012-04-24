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
@Table(name = "cidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cidades.findAll", query = "SELECT c FROM Cidades c"),
    @NamedQuery(name = "Cidades.findByCidade", query = "SELECT c FROM Cidades c WHERE c.cidade = :cidade"),
    @NamedQuery(name = "Cidades.findByCidadeNome", query = "SELECT c FROM Cidades c WHERE c.cidadeNome = :cidadeNome")})
public class Cidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cidade")
    private Integer cidade;
    @Basic(optional = false)
    @Column(name = "cidade_nome")
    private String cidadeNome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cidades")
    private List<Cep> cepList;
    @JoinColumn(name = "estado", referencedColumnName = "estado")
    @ManyToOne(optional = false)
    private Estados estados;

    public Cidades() {
    }

    public Cidades(Integer cidade) {
        this.cidade = cidade;
    }

    public Cidades(Integer cidade, String cidadeNome) {
        this.cidade = cidade;
        this.cidadeNome = cidadeNome;
    }

    public Integer getCidade() {
        return cidade;
    }

    public void setCidade(Integer cidade) {
        this.cidade = cidade;
    }

    public String getCidadeNome() {
        return cidadeNome;
    }

    public void setCidadeNome(String cidadeNome) {
        this.cidadeNome = cidadeNome;
    }

    @XmlTransient
    public List<Cep> getCepList() {
        return cepList;
    }

    public void setCepList(List<Cep> cepList) {
        this.cepList = cepList;
    }

    public Estados getEstados() {
        return estados;
    }

    public void setEstados(Estados estados) {
        this.estados = estados;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cidade != null ? cidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidades)) {
            return false;
        }
        Cidades other = (Cidades) object;
        if ((this.cidade == null && other.cidade != null) || (this.cidade != null && !this.cidade.equals(other.cidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Cidades[ cidade=" + cidade + " ]";
    }
    
}
