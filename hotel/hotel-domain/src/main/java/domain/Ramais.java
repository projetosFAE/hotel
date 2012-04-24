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
@Table(name = "ramais")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ramais.findAll", query = "SELECT r FROM Ramais r"),
    @NamedQuery(name = "Ramais.findByRamal", query = "SELECT r FROM Ramais r WHERE r.ramal = :ramal"),
    @NamedQuery(name = "Ramais.findByRamalNumero", query = "SELECT r FROM Ramais r WHERE r.ramalNumero = :ramalNumero")})
public class Ramais implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ramal")
    private Integer ramal;
    @Basic(optional = false)
    @Column(name = "ramal_numero")
    private int ramalNumero;
    @JoinColumn(name = "ambiente", referencedColumnName = "ambiente")
    @ManyToOne
    private Ambientes ambientes;
    @JoinColumn(name = "quarto", referencedColumnName = "quarto")
    @ManyToOne
    private Quartos quartos;

    public Ramais() {
    }

    public Ramais(Integer ramal) {
        this.ramal = ramal;
    }

    public Ramais(Integer ramal, int ramalNumero) {
        this.ramal = ramal;
        this.ramalNumero = ramalNumero;
    }

    public Integer getRamal() {
        return ramal;
    }

    public void setRamal(Integer ramal) {
        this.ramal = ramal;
    }

    public int getRamalNumero() {
        return ramalNumero;
    }

    public void setRamalNumero(int ramalNumero) {
        this.ramalNumero = ramalNumero;
    }

    public Ambientes getAmbientes() {
        return ambientes;
    }

    public void setAmbientes(Ambientes ambientes) {
        this.ambientes = ambientes;
    }

    public Quartos getQuartos() {
        return quartos;
    }

    public void setQuartos(Quartos quartos) {
        this.quartos = quartos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ramal != null ? ramal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ramais)) {
            return false;
        }
        Ramais other = (Ramais) object;
        if ((this.ramal == null && other.ramal != null) || (this.ramal != null && !this.ramal.equals(other.ramal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Ramais[ ramal=" + ramal + " ]";
    }
    
}
