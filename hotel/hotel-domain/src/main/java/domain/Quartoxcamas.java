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
public class Quartoxcamas implements Persistent, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "quartoxcamas-sequence")
    @SequenceGenerator(name = "quartoxcamas-sequence",
    sequenceName = "quartoxcamas_seq")
    private Long id;
    @JoinColumn(name = "quarto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Quartos quartos;
    @JoinColumn(name = "cama", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Camas camas;

    public Quartoxcamas() {
    }

    @Override
    public void setId(Serializable id) {
        this.id = (Long) id;
    }

    @Override
    public Long getId() {
       return this.id;
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
}
