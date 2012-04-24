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
@Table(name = "quartoxcamas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quartoxcamas.findAll", query = "SELECT q FROM Quartoxcamas q"),
    @NamedQuery(name = "Quartoxcamas.findByQuartoXcama", query = "SELECT q FROM Quartoxcamas q WHERE q.quartoXcama = :quartoXcama")})
public class Quartoxcamas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "quartoXcama")
    private String quartoXcama;
    @JoinColumn(name = "quarto", referencedColumnName = "quarto")
    @ManyToOne(optional = false)
    private Quartos quartos;
    @JoinColumn(name = "cama", referencedColumnName = "cama")
    @ManyToOne(optional = false)
    private Camas camas;

    public Quartoxcamas() {
    }

    public Quartoxcamas(String quartoXcama) {
        this.quartoXcama = quartoXcama;
    }

    public String getQuartoXcama() {
        return quartoXcama;
    }

    public void setQuartoXcama(String quartoXcama) {
        this.quartoXcama = quartoXcama;
    }

    public Quartos getQuartos() {
        return quartos;
    }

    public void setQuartos(Quartos quartos) {
        this.quartos = quartos;
    }

    public Camas getCamas() {
        return camas;
    }

    public void setCamas(Camas camas) {
        this.camas = camas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (quartoXcama != null ? quartoXcama.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quartoxcamas)) {
            return false;
        }
        Quartoxcamas other = (Quartoxcamas) object;
        if ((this.quartoXcama == null && other.quartoXcama != null) || (this.quartoXcama != null && !this.quartoXcama.equals(other.quartoXcama))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Quartoxcamas[ quartoXcama=" + quartoXcama + " ]";
    }
    
}
