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
@Table(name = "cardapiotipos")
public class Cardapiotipos implements Persistent, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "cardapiotipos-sequence")
    @SequenceGenerator(name = "cardapiotipos-sequence",
    sequenceName = "cardapiotipos_seq")
    private Long id;
    @Basic(optional = false)
    @Column(name = "cardapioTipo_nome")
    private String cardapioTiponome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cardapiotipos")
    private List<Cardapios> cardapiosList;

    public Cardapiotipos() {
    }

    @Override
    public void setId(Serializable id) {
        this.id = (Long) id;
    }

    @Override
    public Long getId() {
       return this.id;
    }

    public String getCardapioTiponome() {
        return cardapioTiponome;
    }

    public void setCardapioTiponome(String cardapioTiponome) {
        this.cardapioTiponome = cardapioTiponome;
    }

    @XmlTransient
    public List<Cardapios> getCardapiosList() {
        return cardapiosList;
    }

    public void setCardapiosList(List<Cardapios> cardapiosList) {
        this.cardapiosList = cardapiosList;
    }
}
