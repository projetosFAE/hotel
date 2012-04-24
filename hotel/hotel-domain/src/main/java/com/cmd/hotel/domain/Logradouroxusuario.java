/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmd.hotel.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AlexPorto
 */
@Entity
@Table(name = "logradouroxusuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logradouroxusuario.findAll", query = "SELECT l FROM Logradouroxusuario l"),
    @NamedQuery(name = "Logradouroxusuario.findByLogradouroXusuario", query = "SELECT l FROM Logradouroxusuario l WHERE l.logradouroXusuario = :logradouroXusuario")})
public class Logradouroxusuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "logradouroXusuario")
    private Integer logradouroXusuario;
    @JoinColumn(name = "hotel", referencedColumnName = "hotel")
    @ManyToOne(optional = false)
    private Hoteis hotel;
    @JoinColumn(name = "usuario", referencedColumnName = "usuario")
    @ManyToOne(optional = false)
    private Usuarios usuario;
    @JoinColumn(name = "cep", referencedColumnName = "cep")
    @ManyToOne(optional = false)
    private Cep cep;

    public Logradouroxusuario() {
    }

    public Logradouroxusuario(Integer logradouroXusuario) {
        this.logradouroXusuario = logradouroXusuario;
    }

    public Integer getLogradouroXusuario() {
        return logradouroXusuario;
    }

    public void setLogradouroXusuario(Integer logradouroXusuario) {
        this.logradouroXusuario = logradouroXusuario;
    }

    public Hoteis getHotel() {
        return hotel;
    }

    public void setHotel(Hoteis hotel) {
        this.hotel = hotel;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Cep getCep() {
        return cep;
    }

    public void setCep(Cep cep) {
        this.cep = cep;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logradouroXusuario != null ? logradouroXusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logradouroxusuario)) {
            return false;
        }
        Logradouroxusuario other = (Logradouroxusuario) object;
        if ((this.logradouroXusuario == null && other.logradouroXusuario != null) || (this.logradouroXusuario != null && !this.logradouroXusuario.equals(other.logradouroXusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cmd.hoteldomain.domain.Logradouroxusuario[ logradouroXusuario=" + logradouroXusuario + " ]";
    }
    
}
