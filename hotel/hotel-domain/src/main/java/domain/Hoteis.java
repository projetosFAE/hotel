/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

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
public class Hoteis implements Persistent, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "requester-sequence")
    @SequenceGenerator(name = "requester-sequence",
    sequenceName = "requester_seq")
    private Long id;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hoteis")
    private List<Ambientes> ambientesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hoteis")
    private List<Cardapios> cardapiosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hoteis")
    private List<Logradouroxusuario> logradouroxusuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hoteis")
    private List<Quartos> quartosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hoteis")
    private List<Telefones> telefonesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hoteis")
    private List<Servicos> servicosList;

    public Hoteis() {
    }

    public Hoteis(Integer hotel, String hotelNome, int hotelCnpj, int hotelInscricaoEstadual, String hotelEmail) {
        this.hotelNome = hotelNome;
        this.hotelCnpj = hotelCnpj;
        this.hotelInscricaoEstadual = hotelInscricaoEstadual;
        this.hotelEmail = hotelEmail;
    }

    @Override
    public void setId(Serializable id) {
        this.id = (Long) id;
    }

    @Override
    public Long getId() {
       return this.id;
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
}
