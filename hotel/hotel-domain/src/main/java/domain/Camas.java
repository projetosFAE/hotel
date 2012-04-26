/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AlexPorto
 */
@Entity
@Table(name = "camas")
public class Camas implements Persistent, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "camas-sequence")
    @SequenceGenerator(name = "camas-sequence",
    sequenceName = "camas_seq")
    private Long id;
    @Basic(optional = false)
    @Column(name = "cama_nome")
    private String camaNome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "camas")
    private List<Quartoxcamas> quartoxcamasList;

    public Camas() {
    }

    @Override
    public void setId(Serializable id) {
        this.id = (Long) id;
    }

    @Override
    public Long getId() {
       return this.id;
    }
    
    public String getCamaNome() {
        return camaNome;
    }

    public void setCamaNome(String camaNome) {
        this.camaNome = camaNome;
    }

    @XmlTransient
    public List<Quartoxcamas> getQuartoxcamasList() {
        return quartoxcamasList;
    }

    public void setQuartoxcamasList(List<Quartoxcamas> quartoxcamasList) {
        this.quartoxcamasList = quartoxcamasList;
    }
}
