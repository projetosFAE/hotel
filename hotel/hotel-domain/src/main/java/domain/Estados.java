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
@Table(name = "estados")
public class Estados implements Persistent, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "estados-sequence")
    @SequenceGenerator(name = "estados-sequence",
    sequenceName = "estados_seq")
    private Long id;
    @Basic(optional = false)
    @Column(name = "estado_UF")
    private String estadoUF;
    @JoinColumn(name = "pais", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Paises paises;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estados")
    private List<Cidades> cidadesList;

    public Estados() {
    }

    public Estados(String estadoUF) {
        this.estadoUF = estadoUF;
    }

    @Override
    public void setId(Serializable id) {
        this.id = (Long) id;
    }

    @Override
    public Long getId() {
       return this.id;
    }

    public String getEstadoUF() {
        return estadoUF;
    }

    public void setEstadoUF(String estadoUF) {
        this.estadoUF = estadoUF;
    }

    public Paises getPaises() {
        return paises;
    }

    public void setPaises(Paises paises) {
        this.paises = paises;
    }

    @XmlTransient
    public List<Cidades> getCidadesList() {
        return cidadesList;
    }

    public void setCidadesList(List<Cidades> cidadesList) {
        this.cidadesList = cidadesList;
    }
}
