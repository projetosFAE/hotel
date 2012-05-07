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
@Table(name = "cep")
@XmlRootElement
public class Cep implements Persistent, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "cep-sequence")
    @SequenceGenerator(name = "cep-sequence",
    sequenceName = "cep_seq")
    private Long id;
    @JoinColumn(name = "logradouro", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Logradouros logradouros;
    @JoinColumn(name = "cidade", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cidades cidades;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cep")
    private List<Logradouroxusuario> logradouroxusuarioList;

    public Cep() {
    }

    @Override
    public void setId(Serializable id) {
        this.id = (Long) id;
    }

    @Override
    public Long getId() {
       return this.id;
    }

    public Logradouros getLogradouros() {
        return logradouros;
    }

    public void setLogradouros(Logradouros logradouros) {
        this.logradouros = logradouros;
    }

    public Cidades getCidades() {
        return cidades;
    }

    public void setCidades(Cidades cidades) {
        this.cidades = cidades;
    }

    @XmlTransient
    public List<Logradouroxusuario> getLogradouroxusuarioList() {
        return logradouroxusuarioList;
    }

    public void setLogradouroxusuarioList(List<Logradouroxusuario> logradouroxusuarioList) {
        this.logradouroxusuarioList = logradouroxusuarioList;
    }
  
}
