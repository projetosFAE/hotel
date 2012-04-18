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
@Table(name = "pacotes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pacotes.findAll", query = "SELECT p FROM Pacotes p"),
    @NamedQuery(name = "Pacotes.findByPacote", query = "SELECT p FROM Pacotes p WHERE p.pacote = :pacote"),
    @NamedQuery(name = "Pacotes.findByPacoteNome", query = "SELECT p FROM Pacotes p WHERE p.pacoteNome = :pacoteNome"),
    @NamedQuery(name = "Pacotes.findByPacoteDataInicial", query = "SELECT p FROM Pacotes p WHERE p.pacoteDataInicial = :pacoteDataInicial"),
    @NamedQuery(name = "Pacotes.findByPacoteDataFinal", query = "SELECT p FROM Pacotes p WHERE p.pacoteDataFinal = :pacoteDataFinal"),
    @NamedQuery(name = "Pacotes.findByPacotePessoas", query = "SELECT p FROM Pacotes p WHERE p.pacotePessoas = :pacotePessoas"),
    @NamedQuery(name = "Pacotes.findByPacoteDesc", query = "SELECT p FROM Pacotes p WHERE p.pacoteDesc = :pacoteDesc"),
    @NamedQuery(name = "Pacotes.findByPacoteDataCadastro", query = "SELECT p FROM Pacotes p WHERE p.pacoteDataCadastro = :pacoteDataCadastro")})
public class Pacotes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pacote")
    private Integer pacote;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacote")
    private List<ItensReservas> itensReservasList;
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

    public Pacotes() {
    }

    public Pacotes(Integer pacote) {
        this.pacote = pacote;
    }

    public Pacotes(Integer pacote, String pacoteNome, Date pacoteDataInicial, Date pacoteDataFinal, int pacotePessoas, BigDecimal pacoteDesc) {
        this.pacote = pacote;
        this.pacoteNome = pacoteNome;
        this.pacoteDataInicial = pacoteDataInicial;
        this.pacoteDataFinal = pacoteDataFinal;
        this.pacotePessoas = pacotePessoas;
        this.pacoteDesc = pacoteDesc;
    }

    public Integer getPacote() {
        return pacote;
    }

    public void setPacote(Integer pacote) {
        this.pacote = pacote;
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
        hash += (pacote != null ? pacote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pacotes)) {
            return false;
        }
        Pacotes other = (Pacotes) object;
        if ((this.pacote == null && other.pacote != null) || (this.pacote != null && !this.pacote.equals(other.pacote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cmd.hoteldomain.domain.Pacotes[ pacote=" + pacote + " ]";
    }
    
}
