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
@Table(name = "tipos_quartos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposQuartos.findAll", query = "SELECT t FROM TiposQuartos t"),
    @NamedQuery(name = "TiposQuartos.findByTiposQuartos", query = "SELECT t FROM TiposQuartos t WHERE t.tiposQuartos = :tiposQuartos"),
    @NamedQuery(name = "TiposQuartos.findByQuartosDescricao", query = "SELECT t FROM TiposQuartos t WHERE t.quartosDescricao = :quartosDescricao")})
public class TiposQuartos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tipos_quartos")
    private Integer tiposQuartos;
    @Basic(optional = false)
    @Column(name = "quartos_descricao")
    private String quartosDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiposQuarto")
    private List<Quartos> quartosList;

    public TiposQuartos() {
    }

    public TiposQuartos(Integer tiposQuartos) {
        this.tiposQuartos = tiposQuartos;
    }

    public TiposQuartos(Integer tiposQuartos, String quartosDescricao) {
        this.tiposQuartos = tiposQuartos;
        this.quartosDescricao = quartosDescricao;
    }

    public Integer getTiposQuartos() {
        return tiposQuartos;
    }

    public void setTiposQuartos(Integer tiposQuartos) {
        this.tiposQuartos = tiposQuartos;
    }

    public String getQuartosDescricao() {
        return quartosDescricao;
    }

    public void setQuartosDescricao(String quartosDescricao) {
        this.quartosDescricao = quartosDescricao;
    }

    @XmlTransient
    public List<Quartos> getQuartosList() {
        return quartosList;
    }

    public void setQuartosList(List<Quartos> quartosList) {
        this.quartosList = quartosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tiposQuartos != null ? tiposQuartos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposQuartos)) {
            return false;
        }
        TiposQuartos other = (TiposQuartos) object;
        if ((this.tiposQuartos == null && other.tiposQuartos != null) || (this.tiposQuartos != null && !this.tiposQuartos.equals(other.tiposQuartos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cmd.hoteldomain.domain.TiposQuartos[ tiposQuartos=" + tiposQuartos + " ]";
    }
    
}
