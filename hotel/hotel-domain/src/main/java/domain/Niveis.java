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
@Table(name = "niveis")
public class Niveis implements Persistent, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "niveis-sequence")
    @SequenceGenerator(name = "niveis-sequence",
    sequenceName = "niveis_seq")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nivel_nome")
    private String nivelNome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "niveis")
    private List<Usuarios> usuariosList;

    public Niveis() {
    }

    public Niveis(Integer nivel, String nivelNome) {
        this.nivelNome = nivelNome;
    }

    @Override
    public void setId(Serializable id) {
        this.id = (Long) id;
    }

    @Override
    public Long getId() {
       return this.id;
    }

    public String getNivelNome() {
        return nivelNome;
    }

    public void setNivelNome(String nivelNome) {
        this.nivelNome = nivelNome;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }
}
