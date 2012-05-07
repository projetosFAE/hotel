/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

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
public class Cardapios implements Persistent, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "cardapios-sequence")
    @SequenceGenerator(name = "cardapios-sequence",
    sequenceName = "cardapios_seq")
    private Long id;
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
    @JoinColumn(name = "cardapioTipos", referencedColumnName = "cardapioTipos")
    @ManyToOne(optional = false)
    private Cardapiotipos cardapiotipos;
    @JoinColumn(name = "hoteis", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Hoteis hoteis;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cardapios")
    private List<ItensReservas> itensReservasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cardapios")
    private List<Pacotes> pacotesList;

    public Cardapios() {
    }

    public Cardapios(Integer cardapio, String cardapioNome, Date cardapioTempo, BigDecimal cardapioValor, Date cardapioDataCadastro) {
        this.cardapioNome = cardapioNome;
        this.cardapioTempo = cardapioTempo;
        this.cardapioValor = cardapioValor;
        this.cardapioDataCadastro = cardapioDataCadastro;
    }

    @Override
    public void setId(Serializable id) {
        this.id = (Long) id;
    }

    @Override
    public Long getId() {
       return this.id;
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

    public Cardapiotipos getCardapiotipos() {
        return cardapiotipos;
    }

    public void setCardapiotipos(Cardapiotipos cardapiotipos) {
        this.cardapiotipos = cardapiotipos;
    }

    public Hoteis getHoteis() {
        return hoteis;
    }

    public void setHoteis(Hoteis hoteis) {
        this.hoteis = hoteis;
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
}
