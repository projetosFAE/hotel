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
@Table(name = "ambientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ambientes.findAll", query = "SELECT a FROM Ambientes a"),
    @NamedQuery(name = "Ambientes.findByAmbiente", query = "SELECT a FROM Ambientes a WHERE a.ambiente = :ambiente"),
    @NamedQuery(name = "Ambientes.findByAmbienteNome", query = "SELECT a FROM Ambientes a WHERE a.ambienteNome = :ambienteNome"),
    @NamedQuery(name = "Ambientes.findByAmbienteObservacao", query = "SELECT a FROM Ambientes a WHERE a.ambienteObservacao = :ambienteObservacao"),
    @NamedQuery(name = "Ambientes.findByAmbienteValor", query = "SELECT a FROM Ambientes a WHERE a.ambienteValor = :ambienteValor"),
    @NamedQuery(name = "Ambientes.findByAmbienteReservado", query = "SELECT a FROM Ambientes a WHERE a.ambienteReservado = :ambienteReservado"),
    @NamedQuery(name = "Ambientes.findByAmbienteDataCadastro", query = "SELECT a FROM Ambientes a WHERE a.ambienteDataCadastro = :ambienteDataCadastro")})
public class Ambientes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ambiente")
    private Integer ambiente;
    @Basic(optional = false)
    @Column(name = "ambiente_nome")
    private String ambienteNome;
    @Basic(optional = false)
    @Column(name = "ambiente_observacao")
    private String ambienteObservacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "ambiente_valor")
    private BigDecimal ambienteValor;
    @Basic(optional = false)
    @Column(name = "ambiente_reservado")
    private boolean ambienteReservado;
    @Column(name = "ambiente_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ambienteDataCadastro;
    @JoinColumn(name = "hotel", referencedColumnName = "hotel")
    @ManyToOne(optional = false)
    private Hoteis hotel;
    @OneToMany(mappedBy = "ambiente")
    private List<Ramais> ramaisList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ambiente")
    private List<ItensReservas> itensReservasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ambiente")
    private List<Pacotes> pacotesList;

    public Ambientes() {
    }

    public Ambientes(Integer ambiente) {
        this.ambiente = ambiente;
    }

    public Ambientes(Integer ambiente, String ambienteNome, String ambienteObservacao, BigDecimal ambienteValor, boolean ambienteReservado) {
        this.ambiente = ambiente;
        this.ambienteNome = ambienteNome;
        this.ambienteObservacao = ambienteObservacao;
        this.ambienteValor = ambienteValor;
        this.ambienteReservado = ambienteReservado;
    }

    public Integer getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Integer ambiente) {
        this.ambiente = ambiente;
    }

    public String getAmbienteNome() {
        return ambienteNome;
    }

    public void setAmbienteNome(String ambienteNome) {
        this.ambienteNome = ambienteNome;
    }

    public String getAmbienteObservacao() {
        return ambienteObservacao;
    }

    public void setAmbienteObservacao(String ambienteObservacao) {
        this.ambienteObservacao = ambienteObservacao;
    }

    public BigDecimal getAmbienteValor() {
        return ambienteValor;
    }

    public void setAmbienteValor(BigDecimal ambienteValor) {
        this.ambienteValor = ambienteValor;
    }

    public boolean getAmbienteReservado() {
        return ambienteReservado;
    }

    public void setAmbienteReservado(boolean ambienteReservado) {
        this.ambienteReservado = ambienteReservado;
    }

    public Date getAmbienteDataCadastro() {
        return ambienteDataCadastro;
    }

    public void setAmbienteDataCadastro(Date ambienteDataCadastro) {
        this.ambienteDataCadastro = ambienteDataCadastro;
    }

    public Hoteis getHotel() {
        return hotel;
    }

    public void setHotel(Hoteis hotel) {
        this.hotel = hotel;
    }

    @XmlTransient
    public List<Ramais> getRamaisList() {
        return ramaisList;
    }

    public void setRamaisList(List<Ramais> ramaisList) {
        this.ramaisList = ramaisList;
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
        hash += (ambiente != null ? ambiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ambientes)) {
            return false;
        }
        Ambientes other = (Ambientes) object;
        if ((this.ambiente == null && other.ambiente != null) || (this.ambiente != null && !this.ambiente.equals(other.ambiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cmd.hoteldomain.domain.Ambientes[ ambiente=" + ambiente + " ]";
    }
    
}
