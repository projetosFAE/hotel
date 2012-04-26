/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author AlexPorto
 */
@Entity
@Table(name = "itens_reservas")
public class ItensReservas implements Persistent, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "itens_reservas-sequence")
    @SequenceGenerator(name = "itens_reservas-sequence",
    sequenceName = "itens_reservas_seq")
    private Long id;
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

    public ItensReservas(Integer itensReserva, Date itensReservaDataCadastro, Date itensDataInicial, Date itensDataFinal) {
        this.itensReservaDataCadastro = itensReservaDataCadastro;
        this.itensDataInicial = itensDataInicial;
        this.itensDataFinal = itensDataFinal;
    }

    @Override
    public void setId(Serializable id) {
        this.id = (Long) id;
    }

    @Override
    public Long getId() {
       return this.id;
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
}
