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
@Table(name = "telefones")
public class Telefones implements Persistent, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "telefones-sequence")
    @SequenceGenerator(name = "telefones-sequence",
    sequenceName = "telefones_seq")
    private Long id;
    @Basic(optional = false)
    @Column(name = "telefone_ddi")
    private int telefoneDdi;
    @Basic(optional = false)
    @Column(name = "telefone_ddd")
    private int telefoneDdd;
    @Basic(optional = false)
    @Column(name = "telefone_numero")
    private int telefoneNumero;
    @JoinColumn(name = "usuario", referencedColumnName = "usuario")
    @ManyToOne(optional = false)
    private Usuarios usuarios;
    @JoinColumn(name = "hotel", referencedColumnName = "hotel")
    @ManyToOne(optional = false)
    private Hoteis hoteis;

    public Telefones() {
    }

    public Telefones(Integer telefone, int telefoneDdi, int telefoneDdd, int telefoneNumero) {
        this.telefoneDdi = telefoneDdi;
        this.telefoneDdd = telefoneDdd;
        this.telefoneNumero = telefoneNumero;
    }

    @Override
    public void setId(Serializable id) {
        this.id = (Long) id;
    }

    @Override
    public Long getId() {
       return this.id;
    }

    public int getTelefoneDdi() {
        return telefoneDdi;
    }

    public void setTelefoneDdi(int telefoneDdi) {
        this.telefoneDdi = telefoneDdi;
    }

    public int getTelefoneDdd() {
        return telefoneDdd;
    }

    public void setTelefoneDdd(int telefoneDdd) {
        this.telefoneDdd = telefoneDdd;
    }

    public int getTelefoneNumero() {
        return telefoneNumero;
    }

    public void setTelefoneNumero(int telefoneNumero) {
        this.telefoneNumero = telefoneNumero;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Hoteis getHoteis() {
        return hoteis;
    }

    public void setHoteis(Hoteis hoteis) {
        this.hoteis = hoteis;
    }
}
