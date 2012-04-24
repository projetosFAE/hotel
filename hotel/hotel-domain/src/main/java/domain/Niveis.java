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
@Table(name = "niveis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Niveis.findAll", query = "SELECT n FROM Niveis n"),
    @NamedQuery(name = "Niveis.findByNivel", query = "SELECT n FROM Niveis n WHERE n.nivel = :nivel"),
    @NamedQuery(name = "Niveis.findByNivelNome", query = "SELECT n FROM Niveis n WHERE n.nivelNome = :nivelNome")})
public class Niveis implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nivel")
    private Integer nivel;
    @Basic(optional = false)
    @Column(name = "nivel_nome")
    private String nivelNome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "niveis")
    private List<Usuarios> usuariosList;

    public Niveis() {
    }

    public Niveis(Integer nivel) {
        this.nivel = nivel;
    }

    public Niveis(Integer nivel, String nivelNome) {
        this.nivel = nivel;
        this.nivelNome = nivelNome;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getNivelNome() {
        return nivelNome;
    }

    public void setNivelNome(String nivelNome) {
        this.nivelNome = nivelNome;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nivel != null ? nivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Niveis)) {
            return false;
        }
        Niveis other = (Niveis) object;
        if ((this.nivel == null && other.nivel != null) || (this.nivel != null && !this.nivel.equals(other.nivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Niveis[ nivel=" + nivel + " ]";
    }
    
}
