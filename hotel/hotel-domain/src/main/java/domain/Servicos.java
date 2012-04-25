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
@Table(name = "servicos")
public class Servicos implements Persistent, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "requester-sequence")
    @SequenceGenerator(name = "requester-sequence",
    sequenceName = "requester_seq")
    private Long id;
    @Basic(optional = false)
    @Column(name = "servico_nome")
    private String servicoNome;
    @Column(name = "servico_observacao")
    private String servicoObservacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "servico_valor")
    private BigDecimal servicoValor;
    @Column(name = "servico_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date servicoDataCadastro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicos")
    private List<ItensReservas> itensReservasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicos")
    private List<Pacotes> pacotesList;
    @JoinColumn(name = "hotel", referencedColumnName = "hotel")
    @ManyToOne(optional = false)
    private Hoteis hoteis;

    public Servicos() {
    }

    public Servicos(Integer servico, String servicoNome, BigDecimal servicoValor) {
        this.servicoNome = servicoNome;
        this.servicoValor = servicoValor;
    }

    @Override
    public void setId(Serializable id) {
        this.id = (Long) id;
    }

    @Override
    public Long getId() {
       return this.id;
    }

    public String getServicoNome() {
        return servicoNome;
    }

    public void setServicoNome(String servicoNome) {
        this.servicoNome = servicoNome;
    }

    public String getServicoObservacao() {
        return servicoObservacao;
    }

    public void setServicoObservacao(String servicoObservacao) {
        this.servicoObservacao = servicoObservacao;
    }

    public BigDecimal getServicoValor() {
        return servicoValor;
    }

    public void setServicoValor(BigDecimal servicoValor) {
        this.servicoValor = servicoValor;
    }

    public Date getServicoDataCadastro() {
        return servicoDataCadastro;
    }

    public void setServicoDataCadastro(Date servicoDataCadastro) {
        this.servicoDataCadastro = servicoDataCadastro;
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

    public Hoteis getHoteis() {
        return hoteis;
    }

    public void setHoteis(Hoteis hoteis) {
        this.hoteis = hoteis;
    }
}
