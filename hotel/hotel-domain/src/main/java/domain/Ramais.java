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
public class Ramais implements Persistent, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "requester-sequence")
    @SequenceGenerator(name = "requester-sequence",
    sequenceName = "requester_seq")
    private Long id;
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

    public Ramais(Integer ramal, int ramalNumero) {
        this.ramalNumero = ramalNumero;
    }

    @Override
    public void setId(Serializable id) {
        this.id = (Long) id;
    }

    @Override
    public Long getId() {
       return this.id;
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
}
