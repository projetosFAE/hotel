/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmd.hotel.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AlexPorto
 */
@Entity
@Table(name = "itens_reservas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItensReservas.findAll", query = "SELECT i FROM ItensReservas i"),
    @NamedQuery(name = "ItensReservas.findByItensReserva", query = "SELECT i FROM ItensReservas i WHERE i.itensReserva = :itensReserva"),
    @NamedQuery(name = "ItensReservas.findByItensReservaDataCadastro", query = "SELECT i FROM ItensReservas i WHERE i.itensReservaDataCadastro = :itensReservaDataCadastro"),
    @NamedQuery(name = "ItensReservas.findByItensDataInicial", query = "SELECT i FROM ItensReservas i WHERE i.itensDataInicial = :itensDataInicial"),
    @NamedQuery(name = "ItensReservas.findByItensDataFinal", query = "SELECT i FROM ItensReservas i WHERE i.itensDataFinal = :itensDataFinal")})
public class ItensReservas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "itens_reserva")
    private Integer itensReserva;
    @Basic(optional = false)
    @Column(name = "itens_reserva_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date itensReservaDataCadastro;
    @Basic(optional = false)
    @Column(name = "itens_data_inicial")
    @Temporal(TemporalType.TIMESTAMP)
    private Date itensDataInicial;
    @Basic(optional = false)
    @Column(name = "itens_data_final")
    @Temporal(TemporalType.TIMESTAMP)
    private Date itensDataFinal;
    @JoinColumn(name = "pacote", referencedColumnName = "pacote")
    @ManyToOne(optional = false)
    private Pacotes pacote;
    @JoinColumn(name = "reserva", referencedColumnName = "reserva")
    @ManyToOne(optional = false)
    private Reservas reserva;
    @JoinColumn(name = "servico", referencedColumnName = "servico")
    @ManyToOne(optional = false)
    private Servicos servico;
    @JoinColumn(name = "ambiente", referencedColumnName = "ambiente")
    @ManyToOne(optional = false)
    private Ambientes ambiente;
    @JoinColumn(name = "cardapio", referencedColumnName = "cardapio")
    @ManyToOne(optional = false)
    private Cardapios cardapio;
    @JoinColumn(name = "quarto", referencedColumnName = "quarto")
    @ManyToOne(optional = false)
    private Quartos quarto;

    public ItensReservas() {
    }

    public ItensReservas(Integer itensReserva) {
        this.itensReserva = itensReserva;
    }

    public ItensReservas(Integer itensReserva, Date itensReservaDataCadastro, Date itensDataInicial, Date itensDataFinal) {
        this.itensReserva = itensReserva;
        this.itensReservaDataCadastro = itensReservaDataCadastro;
        this.itensDataInicial = itensDataInicial;
        this.itensDataFinal = itensDataFinal;
    }

    public Integer getItensReserva() {
        return itensReserva;
    }

    public void setItensReserva(Integer itensReserva) {
        this.itensReserva = itensReserva;
    }

    public Date getItensReservaDataCadastro() {
        return itensReservaDataCadastro;
    }

    public void setItensReservaDataCadastro(Date itensReservaDataCadastro) {
        this.itensReservaDataCadastro = itensReservaDataCadastro;
    }

    public Date getItensDataInicial() {
        return itensDataInicial;
    }

    public void setItensDataInicial(Date itensDataInicial) {
        this.itensDataInicial = itensDataInicial;
    }

    public Date getItensDataFinal() {
        return itensDataFinal;
    }

    public void setItensDataFinal(Date itensDataFinal) {
        this.itensDataFinal = itensDataFinal;
    }

    public Pacotes getPacote() {
        return pacote;
    }

    public void setPacote(Pacotes pacote) {
        this.pacote = pacote;
    }

    public Reservas getReserva() {
        return reserva;
    }

    public void setReserva(Reservas reserva) {
        this.reserva = reserva;
    }

    public Servicos getServico() {
        return servico;
    }

    public void setServico(Servicos servico) {
        this.servico = servico;
    }

    public Ambientes getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambientes ambiente) {
        this.ambiente = ambiente;
    }

    public Cardapios getCardapio() {
        return cardapio;
    }

    public void setCardapio(Cardapios cardapio) {
        this.cardapio = cardapio;
    }

    public Quartos getQuarto() {
        return quarto;
    }

    public void setQuarto(Quartos quarto) {
        this.quarto = quarto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itensReserva != null ? itensReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItensReservas)) {
            return false;
        }
        ItensReservas other = (ItensReservas) object;
        if ((this.itensReserva == null && other.itensReserva != null) || (this.itensReserva != null && !this.itensReserva.equals(other.itensReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cmd.hoteldomain.domain.ItensReservas[ itensReserva=" + itensReserva + " ]";
    }
    
}
