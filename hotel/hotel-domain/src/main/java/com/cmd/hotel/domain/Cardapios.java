/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmd.hotel.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AlexPorto
 */
@Entity
@Table(name = "cardapios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cardapios.findAll", query = "SELECT c FROM Cardapios c"),
    @NamedQuery(name = "Cardapios.findByCardapio", query = "SELECT c FROM Cardapios c WHERE c.cardapio = :cardapio"),
    @NamedQuery(name = "Cardapios.findByCardapioNome", query = "SELECT c FROM Cardapios c WHERE c.cardapioNome = :cardapioNome"),
    @NamedQuery(name = "Cardapios.findByCardapioTempo", query = "SELECT c FROM Cardapios c WHERE c.cardapioTempo = :cardapioTempo"),
    @NamedQuery(name = "Cardapios.findByCardapioObservacao", query = "SELECT c FROM Cardapios c WHERE c.cardapioObservacao = :cardapioObservacao"),
    @NamedQuery(name = "Cardapios.findByCardapioValorCalorico", query = "SELECT c FROM Cardapios c WHERE c.cardapioValorCalorico = :cardapioValorCalorico"),
    @NamedQuery(name = "Cardapios.findByCardapioValor", query = "SELECT c FROM Cardapios c WHERE c.cardapioValor = :cardapioValor"),
    @NamedQuery(name = "Cardapios.findByCardapioDataCadastro", query = "SELECT c FROM Cardapios c WHERE c.cardapioDataCadastro = :cardapioDataCadastro")})
public class Cardapios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cardapio")
    private Integer cardapio;
    @Basic(optional = false)
    @Column(name = "cardapio_nome")
    private String cardapioNome;
    @Basic(optional = false)
    @Column(name = "cardapio_tempo")
    @Temporal(TemporalType.TIME)
    private Date cardapioTempo;
    @Column(name = "cardapio_observacao")
    private String cardapioObservacao;
    @Column(name = "cardapio_valor_calorico")
    private Integer cardapioValorCalorico;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "cardapio_valor")
    private BigDecimal cardapioValor;
    @Basic(optional = false)
    @Column(name = "cardapio_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cardapioDataCadastro;
    @JoinColumn(name = "cardapioTipo", referencedColumnName = "cardapioTipo")
    @ManyToOne(optional = false)
    private Cardapiotipos cardapioTipo;
    @JoinColumn(name = "hotel", referencedColumnName = "hotel")
    @ManyToOne(optional = false)
    private Hoteis hotel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cardapio")
    private List<ItensReservas> itensReservasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cardapio")
    private List<Pacotes> pacotesList;

    public Cardapios() {
    }

    public Cardapios(Integer cardapio) {
        this.cardapio = cardapio;
    }

    public Cardapios(Integer cardapio, String cardapioNome, Date cardapioTempo, BigDecimal cardapioValor, Date cardapioDataCadastro) {
        this.cardapio = cardapio;
        this.cardapioNome = cardapioNome;
        this.cardapioTempo = cardapioTempo;
        this.cardapioValor = cardapioValor;
        this.cardapioDataCadastro = cardapioDataCadastro;
    }

    public Integer getCardapio() {
        return cardapio;
    }

    public void setCardapio(Integer cardapio) {
        this.cardapio = cardapio;
    }

    public String getCardapioNome() {
        return cardapioNome;
    }

    public void setCardapioNome(String cardapioNome) {
        this.cardapioNome = cardapioNome;
    }

    public Date getCardapioTempo() {
        return cardapioTempo;
    }

    public void setCardapioTempo(Date cardapioTempo) {
        this.cardapioTempo = cardapioTempo;
    }

    public String getCardapioObservacao() {
        return cardapioObservacao;
    }

    public void setCardapioObservacao(String cardapioObservacao) {
        this.cardapioObservacao = cardapioObservacao;
    }

    public Integer getCardapioValorCalorico() {
        return cardapioValorCalorico;
    }

    public void setCardapioValorCalorico(Integer cardapioValorCalorico) {
        this.cardapioValorCalorico = cardapioValorCalorico;
    }

    public BigDecimal getCardapioValor() {
        return cardapioValor;
    }

    public void setCardapioValor(BigDecimal cardapioValor) {
        this.cardapioValor = cardapioValor;
    }

    public Date getCardapioDataCadastro() {
        return cardapioDataCadastro;
    }

    public void setCardapioDataCadastro(Date cardapioDataCadastro) {
        this.cardapioDataCadastro = cardapioDataCadastro;
    }

    public Cardapiotipos getCardapioTipo() {
        return cardapioTipo;
    }

    public void setCardapioTipo(Cardapiotipos cardapioTipo) {
        this.cardapioTipo = cardapioTipo;
    }

    public Hoteis getHotel() {
        return hotel;
    }

    public void setHotel(Hoteis hotel) {
        this.hotel = hotel;
    }

    @XmlTransient
    public List<ItensReservas> getItensReservasList() {
        return itensReservasList;
    }

    public void setItensReservasList(List<ItensReservas> itensReservasList) {
        this.itensReservasList = itensReservasList;
    }

    @XmlTransient
    public List<Pacotes> getPacotesList() {
        return pacotesList;
    }

    public void setPacotesList(List<Pacotes> pacotesList) {
        this.pacotesList = pacotesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cardapio != null ? cardapio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cardapios)) {
            return false;
        }
        Cardapios other = (Cardapios) object;
        if ((this.cardapio == null && other.cardapio != null) || (this.cardapio != null && !this.cardapio.equals(other.cardapio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cmd.hoteldomain.domain.Cardapios[ cardapio=" + cardapio + " ]";
    }
    
}
