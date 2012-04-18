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
@Table(name = "servicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicos.findAll", query = "SELECT s FROM Servicos s"),
    @NamedQuery(name = "Servicos.findByServico", query = "SELECT s FROM Servicos s WHERE s.servico = :servico"),
    @NamedQuery(name = "Servicos.findByServicoNome", query = "SELECT s FROM Servicos s WHERE s.servicoNome = :servicoNome"),
    @NamedQuery(name = "Servicos.findByServicoObservacao", query = "SELECT s FROM Servicos s WHERE s.servicoObservacao = :servicoObservacao"),
    @NamedQuery(name = "Servicos.findByServicoValor", query = "SELECT s FROM Servicos s WHERE s.servicoValor = :servicoValor"),
    @NamedQuery(name = "Servicos.findByServicoDataCadastro", query = "SELECT s FROM Servicos s WHERE s.servicoDataCadastro = :servicoDataCadastro")})
public class Servicos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "servico")
    private Integer servico;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servico")
    private List<ItensReservas> itensReservasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servico")
    private List<Pacotes> pacotesList;
    @JoinColumn(name = "hotel", referencedColumnName = "hotel")
    @ManyToOne(optional = false)
    private Hoteis hotel;

    public Servicos() {
    }

    public Servicos(Integer servico) {
        this.servico = servico;
    }

    public Servicos(Integer servico, String servicoNome, BigDecimal servicoValor) {
        this.servico = servico;
        this.servicoNome = servicoNome;
        this.servicoValor = servicoValor;
    }

    public Integer getServico() {
        return servico;
    }

    public void setServico(Integer servico) {
        this.servico = servico;
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

    public Hoteis getHotel() {
        return hotel;
    }

    public void setHotel(Hoteis hotel) {
        this.hotel = hotel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servico != null ? servico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicos)) {
            return false;
        }
        Servicos other = (Servicos) object;
        if ((this.servico == null && other.servico != null) || (this.servico != null && !this.servico.equals(other.servico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cmd.hoteldomain.domain.Servicos[ servico=" + servico + " ]";
    }
    
}
