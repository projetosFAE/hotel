/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

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
    private Pacotes pacotes;
    @JoinColumn(name = "reserva", referencedColumnName = "reserva")
    @ManyToOne(optional = false)
    private Reservas reservas;
    @JoinColumn(name = "servico", referencedColumnName = "servico")
    @ManyToOne(optional = false)
    private Servicos servicos;
    @JoinColumn(name = "ambiente", referencedColumnName = "ambiente")
    @ManyToOne(optional = false)
    private Ambientes ambientes;
    @JoinColumn(name = "cardapio", referencedColumnName = "cardapio")
    @ManyToOne(optional = false)
    private Cardapios cardapios;
    @JoinColumn(name = "quarto", referencedColumnName = "quarto")
    @ManyToOne(optional = false)
    private Quartos quartos;

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

    public Pacotes getPacotes() {
        return pacotes;
    }

    public void setPacotes(Pacotes pacotes) {
        this.pacotes = pacotes;
    }

    public Reservas getReservas() {
        return reservas;
    }

    public void setReservas(Reservas reservas) {
        this.reservas = reservas;
    }

    public Servicos getServicos() {
        return servicos;
    }

    public void setServicos(Servicos servicos) {
        this.servicos = servicos;
    }

    public Ambientes getAmbientes() {
        return ambientes;
    }

    public void setAmbientes(Ambientes ambientes) {
        this.ambientes = ambientes;
    }

    public Cardapios getCardapios() {
        return cardapios;
    }

    public void setCardapios(Cardapios cardapios) {
        this.cardapios = cardapios;
    }

    public Quartos getQuartos() {
        return quartos;
    }

    public void setQuartos(Quartos quartos) {
        this.quartos = quartos;
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
        return "domain.ItensReservas[ itensReserva=" + itensReserva + " ]";
    }
    
}
