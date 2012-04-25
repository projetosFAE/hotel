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
@Table(name = "logradouros")
public class Logradouros implements Persistent, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "requester-sequence")
    @SequenceGenerator(name = "requester-sequence",
    sequenceName = "requester_seq")
    private Long id;
    @Basic(optional = false)
    @Column(name = "logradouro_nome")
    private String logradouroNome;
    @Basic(optional = false)
    @Column(name = "logradouro_numero")
    private String logradouroNumero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "logradouros")
    private List<Cep> cepList;

    public Logradouros() {
    }

    public Logradouros(Integer logradouro, String logradouroNome, String logradouroNumero) {
        this.logradouroNome = logradouroNome;
        this.logradouroNumero = logradouroNumero;
    }

    @Override
    public void setId(Serializable id) {
        this.id = (Long) id;
    }

    @Override
    public Long getId() {
       return this.id;
    }

    public String getLogradouroNome() {
        return logradouroNome;
    }

    public void setLogradouroNome(String logradouroNome) {
        this.logradouroNome = logradouroNome;
    }

    public String getLogradouroNumero() {
        return logradouroNumero;
    }

    public void setLogradouroNumero(String logradouroNumero) {
        this.logradouroNumero = logradouroNumero;
    }

    @XmlTransient
    public List<Cep> getCepList() {
        return cepList;
    }

    public void setCepList(List<Cep> cepList) {
        this.cepList = cepList;
    }
}
