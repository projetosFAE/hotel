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
@Table(name = "telefones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefones.findAll", query = "SELECT t FROM Telefones t"),
    @NamedQuery(name = "Telefones.findByTelefone", query = "SELECT t FROM Telefones t WHERE t.telefone = :telefone"),
    @NamedQuery(name = "Telefones.findByTelefoneDdi", query = "SELECT t FROM Telefones t WHERE t.telefoneDdi = :telefoneDdi"),
    @NamedQuery(name = "Telefones.findByTelefoneDdd", query = "SELECT t FROM Telefones t WHERE t.telefoneDdd = :telefoneDdd"),
    @NamedQuery(name = "Telefones.findByTelefoneNumero", query = "SELECT t FROM Telefones t WHERE t.telefoneNumero = :telefoneNumero")})
public class Telefones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "telefone")
    private Integer telefone;
    @Basic(optional = false)
    @Column(name = "telefone_ddi")
    private int telefoneDdi;
    @Basic(optional = false)
    @Column(name = "telefone_ddd")
    private int telefoneDdd;
    @Basic(optional = false)
    @Column(name = "telefone_numero")
    private int telefoneNumero;
    @JoinColumn(name = "usuario", referencedColumnName = "usuario")
    @ManyToOne(optional = false)
    private Usuarios usuarios;
    @JoinColumn(name = "hotel", referencedColumnName = "hotel")
    @ManyToOne(optional = false)
    private Hoteis hoteis;

    public Telefones() {
    }

    public Telefones(Integer telefone) {
        this.telefone = telefone;
    }

    public Telefones(Integer telefone, int telefoneDdi, int telefoneDdd, int telefoneNumero) {
        this.telefone = telefone;
        this.telefoneDdi = telefoneDdi;
        this.telefoneDdd = telefoneDdd;
        this.telefoneNumero = telefoneNumero;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public int getTelefoneDdi() {
        return telefoneDdi;
    }

    public void setTelefoneDdi(int telefoneDdi) {
        this.telefoneDdi = telefoneDdi;
    }

    public int getTelefoneDdd() {
        return telefoneDdd;
    }

    public void setTelefoneDdd(int telefoneDdd) {
        this.telefoneDdd = telefoneDdd;
    }

    public int getTelefoneNumero() {
        return telefoneNumero;
    }

    public void setTelefoneNumero(int telefoneNumero) {
        this.telefoneNumero = telefoneNumero;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Hoteis getHoteis() {
        return hoteis;
    }

    public void setHoteis(Hoteis hoteis) {
        this.hoteis = hoteis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (telefone != null ? telefone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefones)) {
            return false;
        }
        Telefones other = (Telefones) object;
        if ((this.telefone == null && other.telefone != null) || (this.telefone != null && !this.telefone.equals(other.telefone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Telefones[ telefone=" + telefone + " ]";
    }
    
}
