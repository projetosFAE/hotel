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
@Table(name = "reservas")
public class Reservas implements Persistent, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "reservas-sequence")
    @SequenceGenerator(name = "reservas-sequence",
    sequenceName = "reservas_seq")
    private Long id;
    @Basic(optional = false)
    @Column(name = "reserva_check_in")
    private boolean reservaCheckIn;
    @Basic(optional = false)
    @Column(name = "reserva_finalizado")
    private boolean reservaFinalizado;
    @JoinColumn(name = "usuario", referencedColumnName = "usuario")
    @ManyToOne(optional = false)
    private Usuarios usuarios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservas")
    private List<ItensReservas> itensReservasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservas")
    private List<Financeiros> financeirosList;

    public Reservas() {
    }

    public Reservas(Integer reserva, boolean reservaCheckIn, boolean reservaFinalizado) {
        this.reservaCheckIn = reservaCheckIn;
        this.reservaFinalizado = reservaFinalizado;
    }

    @Override
    public void setId(Serializable id) {
        this.id = (Long) id;
    }

    @Override
    public Long getId() {
       return this.id;
    }

    public boolean getReservaCheckIn() {
        return reservaCheckIn;
    }

    public void setReservaCheckIn(boolean reservaCheckIn) {
        this.reservaCheckIn = reservaCheckIn;
    }

    public boolean getReservaFinalizado() {
        return reservaFinalizado;
    }

    public void setReservaFinalizado(boolean reservaFinalizado) {
        this.reservaFinalizado = reservaFinalizado;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @XmlTransient
    public List<ItensReservas> getItensReservasList() {
        return itensReservasList;
    }

    public void setItensReservasList(List<ItensReservas> itensReservasList) {
        this.itensReservasList = itensReservasList;
    }

    @XmlTransient
    public List<Financeiros> getFinanceirosList() {
        return financeirosList;
    }

    public void setFinanceirosList(List<Financeiros> financeirosList) {
        this.financeirosList = financeirosList;
    }
}
