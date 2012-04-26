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
@Table(name = "tipos_quartos")
public class TiposQuartos implements Persistent, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "tipos_quartos-sequence")
    @SequenceGenerator(name = "tipos_quartos-sequence",
    sequenceName = "tipos_quartos_seq")
    private Long id;
    @Basic(optional = false)
    @Column(name = "quartos_descricao")
    private String quartosDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiposQuartos")
    private List<Quartos> quartosList;

    public TiposQuartos() {
    }

    public TiposQuartos(Integer tiposQuartos, String quartosDescricao) {
        this.quartosDescricao = quartosDescricao;
    }

    @Override
    public void setId(Serializable id) {
        this.id = (Long) id;
    }

    @Override
    public Long getId() {
       return this.id;
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
}
