/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmd.hotel.domain;

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
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservas.findAll", query = "SELECT r FROM Reservas r"),
    @NamedQuery(name = "Reservas.findByReserva", query = "SELECT r FROM Reservas r WHERE r.reserva = :reserva"),
    @NamedQuery(name = "Reservas.findByReservaCheckIn", query = "SELECT r FROM Reservas r WHERE r.reservaCheckIn = :reservaCheckIn"),
    @NamedQuery(name = "Reservas.findByReservaFinalizado", query = "SELECT r FROM Reservas r WHERE r.reservaFinalizado = :reservaFinalizado")})
public class Reservas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "reserva")
    private Integer reserva;
    @Basic(optional = false)
    @Column(name = "reserva_check_in")
    private boolean reservaCheckIn;
    @Basic(optional = false)
    @Column(name = "reserva_finalizado")
    private boolean reservaFinalizado;
    @JoinColumn(name = "usuario", referencedColumnName = "usuario")
    @ManyToOne(optional = false)
    private Usuarios usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reserva")
    private List<ItensReservas> itensReservasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reserva")
    private List<Financeiros> financeirosList;

    public Reservas() {
    }

    public Reservas(Integer reserva) {
        this.reserva = reserva;
    }

    public Reservas(Integer reserva, boolean reservaCheckIn, boolean reservaFinalizado) {
        this.reserva = reserva;
        this.reservaCheckIn = reservaCheckIn;
        this.reservaFinalizado = reservaFinalizado;
    }

    public Integer getReserva() {
        return reserva;
    }

    public void setReserva(Integer reserva) {
        this.reserva = reserva;
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

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reserva != null ? reserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservas)) {
            return false;
        }
        Reservas other = (Reservas) object;
        if ((this.reserva == null && other.reserva != null) || (this.reserva != null && !this.reserva.equals(other.reserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cmd.hoteldomain.domain.Reservas[ reserva=" + reserva + " ]";
    }
    
}
