/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

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
    private Hoteis hoteis;
    @JoinColumn(name = "usuario", referencedColumnName = "usuario")
    @ManyToOne(optional = false)
    private Usuarios usuarios;
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

    public Hoteis getHoteis() {
        return hoteis;
    }

    public void setHoteis(Hoteis hoteis) {
        this.hoteis = hoteis;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
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
        return "domain.Logradouroxusuario[ logradouroXusuario=" + logradouroXusuario + " ]";
    }
    
}
