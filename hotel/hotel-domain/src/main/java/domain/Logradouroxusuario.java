/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author AlexPorto
 */
@Entity
@Table(name = "logradouroxusuario")
public class Logradouroxusuario implements Persistent, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "logradouroxusuario-sequence")
    @SequenceGenerator(name = "logradouroxusuario-sequence",
    sequenceName = "logradouroxusuario_seq")
    private Long id;
    @JoinColumn(name = "hoteis", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Hoteis hoteis;
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios usuarios;
    @JoinColumn(name = "cep", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cep cep;

    public Logradouroxusuario() {
    }

    @Override
    public void setId(Serializable id) {
        this.id = (Long) id;
    }

    @Override
    public Long getId() {
       return this.id;
    }

    public Hoteis getHoteis() {
        return hoteis;
    }

    public void setHoteis(Hoteis hoteis) {
        this.hoteis = hoteis;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Cep getCep() {
        return cep;
    }

    public void setCep(Cep cep) {
        this.cep = cep;
    }
}
