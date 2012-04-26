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
@Table(name = "pacotes")
public class Pacotes implements Persistent, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "pacotes-sequence")
    @SequenceGenerator(name = "pacotes-sequence",
    sequenceName = "pacotes_seq")
    private Long id;
    @Basic(optional = false)
    @Column(name = "pacote_nome")
    private String pacoteNome;
    @Basic(optional = false)
    @Column(name = "pacote_data_inicial")
    @Temporal(TemporalType.DATE)
    private Date pacoteDataInicial;
    @Basic(optional = false)
    @Column(name = "pacote_data_final")
    @Temporal(TemporalType.DATE)
    private Date pacoteDataFinal;
    @Basic(optional = false)
    @Column(name = "pacote_pessoas")
    private int pacotePessoas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "pacote_desc")
    private BigDecimal pacoteDesc;
    @Column(name = "pacote_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pacoteDataCadastro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacotes")
    private List<ItensReservas> itensReservasList;
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

    public Pacotes() {
    }

    public Pacotes(Integer pacote, String pacoteNome, Date pacoteDataInicial, Date pacoteDataFinal, int pacotePessoas, BigDecimal pacoteDesc) {
        this.pacoteNome = pacoteNome;
        this.pacoteDataInicial = pacoteDataInicial;
        this.pacoteDataFinal = pacoteDataFinal;
        this.pacotePessoas = pacotePessoas;
        this.pacoteDesc = pacoteDesc;
    }

    @Override
    public void setId(Serializable id) {
        this.id = (Long) id;
    }

    @Override
    public Long getId() {
       return this.id;
    }

    public String getPacoteNome() {
        return pacoteNome;
    }

    public void setPacoteNome(String pacoteNome) {
        this.pacoteNome = pacoteNome;
    }

    public Date getPacoteDataInicial() {
        return pacoteDataInicial;
    }

    public void setPacoteDataInicial(Date pacoteDataInicial) {
        this.pacoteDataInicial = pacoteDataInicial;
    }

    public Date getPacoteDataFinal() {
        return pacoteDataFinal;
    }

    public void setPacoteDataFinal(Date pacoteDataFinal) {
        this.pacoteDataFinal = pacoteDataFinal;
    }

    public int getPacotePessoas() {
        return pacotePessoas;
    }

    public void setPacotePessoas(int pacotePessoas) {
        this.pacotePessoas = pacotePessoas;
    }

    public BigDecimal getPacoteDesc() {
        return pacoteDesc;
    }

    public void setPacoteDesc(BigDecimal pacoteDesc) {
        this.pacoteDesc = pacoteDesc;
    }

    public Date getPacoteDataCadastro() {
        return pacoteDataCadastro;
    }

    public void setPacoteDataCadastro(Date pacoteDataCadastro) {
        this.pacoteDataCadastro = pacoteDataCadastro;
    }

    @XmlTransient
    public List<ItensReservas> getItensReservasList() {
        return itensReservasList;
    }

    public void setItensReservasList(List<ItensReservas> itensReservasList) {
        this.itensReservasList = itensReservasList;
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
