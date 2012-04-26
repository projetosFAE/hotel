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
@Table(name = "quartos")
public class Quartos implements Persistent, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "quartos-sequence")
    @SequenceGenerator(name = "quartos-sequence",
    sequenceName = "quartos_seq")
    private Long id;
    @Basic(optional = false)
    @Column(name = "quarto_numero")
    private String quartoNumero;
    @Column(name = "quarto_descricao")
    private String quartoDescricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "quarto_valor")
    private BigDecimal quartoValor;
    @Basic(optional = false)
    @Column(name = "quarto_reservado")
    private boolean quartoReservado;
    @Basic(optional = false)
    @Column(name = "quarto_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date quartoDataCadastro;
    @OneToMany(mappedBy = "quartos")
    private List<Ramais> ramaisList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quartos")
    private List<Quartoxcamas> quartoxcamasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quartos")
    private List<ItensReservas> itensReservasList;
    @JoinColumn(name = "tipos_quarto", referencedColumnName = "tipos_quartos")
    @ManyToOne(optional = false)
    private TiposQuartos tiposQuartos;
    @JoinColumn(name = "hotel", referencedColumnName = "hotel")
    @ManyToOne(optional = false)
    private Hoteis hoteis;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quartos")
    private List<Pacotes> pacotesList;

    public Quartos() {
    }

    public Quartos(Integer quarto, String quartoNumero, BigDecimal quartoValor, boolean quartoReservado, Date quartoDataCadastro) {
        this.quartoNumero = quartoNumero;
        this.quartoValor = quartoValor;
        this.quartoReservado = quartoReservado;
        this.quartoDataCadastro = quartoDataCadastro;
    }

    @Override
    public void setId(Serializable id) {
        this.id = (Long) id;
    }

    @Override
    public Long getId() {
       return this.id;
    }

    public String getQuartoNumero() {
        return quartoNumero;
    }

    public void setQuartoNumero(String quartoNumero) {
        this.quartoNumero = quartoNumero;
    }

    public String getQuartoDescricao() {
        return quartoDescricao;
    }

    public void setQuartoDescricao(String quartoDescricao) {
        this.quartoDescricao = quartoDescricao;
    }

    public BigDecimal getQuartoValor() {
        return quartoValor;
    }

    public void setQuartoValor(BigDecimal quartoValor) {
        this.quartoValor = quartoValor;
    }

    public boolean getQuartoReservado() {
        return quartoReservado;
    }

    public void setQuartoReservado(boolean quartoReservado) {
        this.quartoReservado = quartoReservado;
    }

    public Date getQuartoDataCadastro() {
        return quartoDataCadastro;
    }

    public void setQuartoDataCadastro(Date quartoDataCadastro) {
        this.quartoDataCadastro = quartoDataCadastro;
    }

    @XmlTransient
    public List<Ramais> getRamaisList() {
        return ramaisList;
    }

    public void setRamaisList(List<Ramais> ramaisList) {
        this.ramaisList = ramaisList;
    }

    @XmlTransient
    public List<Quartoxcamas> getQuartoxcamasList() {
        return quartoxcamasList;
    }

    public void setQuartoxcamasList(List<Quartoxcamas> quartoxcamasList) {
        this.quartoxcamasList = quartoxcamasList;
    }

    @XmlTransient
    public List<ItensReservas> getItensReservasList() {
        return itensReservasList;
    }

    public void setItensReservasList(List<ItensReservas> itensReservasList) {
        this.itensReservasList = itensReservasList;
    }

    public TiposQuartos getTiposQuartos() {
        return tiposQuartos;
    }

    public void setTiposQuartos(TiposQuartos tiposQuartos) {
        this.tiposQuartos = tiposQuartos;
    }

    public Hoteis getHoteis() {
        return hoteis;
    }

    public void setHoteis(Hoteis hoteis) {
        this.hoteis = hoteis;
    }

    @XmlTransient
    public List<Pacotes> getPacotesList() {
        return pacotesList;
    }

    public void setPacotesList(List<Pacotes> pacotesList) {
        this.pacotesList = pacotesList;
    }
}
