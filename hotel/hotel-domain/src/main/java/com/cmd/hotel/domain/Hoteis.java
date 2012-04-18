/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmd.hotel.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AlexPorto
 */
@Entity
@Table(name = "hoteis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hoteis.findAll", query = "SELECT h FROM Hoteis h"),
    @NamedQuery(name = "Hoteis.findByHotel", query = "SELECT h FROM Hoteis h WHERE h.hotel = :hotel"),
    @NamedQuery(name = "Hoteis.findByHotelNome", query = "SELECT h FROM Hoteis h WHERE h.hotelNome = :hotelNome"),
    @NamedQuery(name = "Hoteis.findByHotelCnpj", query = "SELECT h FROM Hoteis h WHERE h.hotelCnpj = :hotelCnpj"),
    @NamedQuery(name = "Hoteis.findByHotelInscricaoEstadual", query = "SELECT h FROM Hoteis h WHERE h.hotelInscricaoEstadual = :hotelInscricaoEstadual"),
    @NamedQuery(name = "Hoteis.findByHotelEmail", query = "SELECT h FROM Hoteis h WHERE h.hotelEmail = :hotelEmail"),
    @NamedQuery(name = "Hoteis.findByHotelObservacoes", query = "SELECT h FROM Hoteis h WHERE h.hotelObservacoes = :hotelObservacoes"),
    @NamedQuery(name = "Hoteis.findByHotelGerente", query = "SELECT h FROM Hoteis h WHERE h.hotelGerente = :hotelGerente")})
public class Hoteis implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "hotel")
    private Integer hotel;
    @Basic(optional = false)
    @Column(name = "hotel_nome")
    private String hotelNome;
    @Basic(optional = false)
    @Column(name = "hotel_cnpj")
    private int hotelCnpj;
    @Basic(optional = false)
    @Column(name = "hotel_inscricao_estadual")
    private int hotelInscricaoEstadual;
    @Basic(optional = false)
    @Column(name = "hotel_email")
    private String hotelEmail;
    @Column(name = "hotel_observacoes")
    private String hotelObservacoes;
    @Column(name = "hotel_gerente")
    private String hotelGerente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel")
    private List<Ambientes> ambientesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel")
    private List<Cardapios> cardapiosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel")
    private List<Logradouroxusuario> logradouroxusuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel")
    private List<Quartos> quartosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel")
    private List<Telefones> telefonesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel")
    private List<Servicos> servicosList;

    public Hoteis() {
    }

    public Hoteis(Integer hotel) {
        this.hotel = hotel;
    }

    public Hoteis(Integer hotel, String hotelNome, int hotelCnpj, int hotelInscricaoEstadual, String hotelEmail) {
        this.hotel = hotel;
        this.hotelNome = hotelNome;
        this.hotelCnpj = hotelCnpj;
        this.hotelInscricaoEstadual = hotelInscricaoEstadual;
        this.hotelEmail = hotelEmail;
    }

    public Integer getHotel() {
        return hotel;
    }

    public void setHotel(Integer hotel) {
        this.hotel = hotel;
    }

    public String getHotelNome() {
        return hotelNome;
    }

    public void setHotelNome(String hotelNome) {
        this.hotelNome = hotelNome;
    }

    public int getHotelCnpj() {
        return hotelCnpj;
    }

    public void setHotelCnpj(int hotelCnpj) {
        this.hotelCnpj = hotelCnpj;
    }

    public int getHotelInscricaoEstadual() {
        return hotelInscricaoEstadual;
    }

    public void setHotelInscricaoEstadual(int hotelInscricaoEstadual) {
        this.hotelInscricaoEstadual = hotelInscricaoEstadual;
    }

    public String getHotelEmail() {
        return hotelEmail;
    }

    public void setHotelEmail(String hotelEmail) {
        this.hotelEmail = hotelEmail;
    }

    public String getHotelObservacoes() {
        return hotelObservacoes;
    }

    public void setHotelObservacoes(String hotelObservacoes) {
        this.hotelObservacoes = hotelObservacoes;
    }

    public String getHotelGerente() {
        return hotelGerente;
    }

    public void setHotelGerente(String hotelGerente) {
        this.hotelGerente = hotelGerente;
    }

    @XmlTransient
    public List<Ambientes> getAmbientesList() {
        return ambientesList;
    }

    public void setAmbientesList(List<Ambientes> ambientesList) {
        this.ambientesList = ambientesList;
    }

    @XmlTransient
    public List<Cardapios> getCardapiosList() {
        return cardapiosList;
    }

    public void setCardapiosList(List<Cardapios> cardapiosList) {
        this.cardapiosList = cardapiosList;
    }

    @XmlTransient
    public List<Logradouroxusuario> getLogradouroxusuarioList() {
        return logradouroxusuarioList;
    }

    public void setLogradouroxusuarioList(List<Logradouroxusuario> logradouroxusuarioList) {
        this.logradouroxusuarioList = logradouroxusuarioList;
    }

    @XmlTransient
    public List<Quartos> getQuartosList() {
        return quartosList;
    }

    public void setQuartosList(List<Quartos> quartosList) {
        this.quartosList = quartosList;
    }

    @XmlTransient
    public List<Telefones> getTelefonesList() {
        return telefonesList;
    }

    public void setTelefonesList(List<Telefones> telefonesList) {
        this.telefonesList = telefonesList;
    }

    @XmlTransient
    public List<Servicos> getServicosList() {
        return servicosList;
    }

    public void setServicosList(List<Servicos> servicosList) {
        this.servicosList = servicosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hotel != null ? hotel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hoteis)) {
            return false;
        }
        Hoteis other = (Hoteis) object;
        if ((this.hotel == null && other.hotel != null) || (this.hotel != null && !this.hotel.equals(other.hotel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cmd.hoteldomain.domain.Hoteis[ hotel=" + hotel + " ]";
    }
    
}
