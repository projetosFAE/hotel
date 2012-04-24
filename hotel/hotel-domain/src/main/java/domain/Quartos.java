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
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quartos.findAll", query = "SELECT q FROM Quartos q"),
    @NamedQuery(name = "Quartos.findByQuarto", query = "SELECT q FROM Quartos q WHERE q.quarto = :quarto"),
    @NamedQuery(name = "Quartos.findByQuartoNumero", query = "SELECT q FROM Quartos q WHERE q.quartoNumero = :quartoNumero"),
    @NamedQuery(name = "Quartos.findByQuartoDescricao", query = "SELECT q FROM Quartos q WHERE q.quartoDescricao = :quartoDescricao"),
    @NamedQuery(name = "Quartos.findByQuartoValor", query = "SELECT q FROM Quartos q WHERE q.quartoValor = :quartoValor"),
    @NamedQuery(name = "Quartos.findByQuartoReservado", query = "SELECT q FROM Quartos q WHERE q.quartoReservado = :quartoReservado"),
    @NamedQuery(name = "Quartos.findByQuartoDataCadastro", query = "SELECT q FROM Quartos q WHERE q.quartoDataCadastro = :quartoDataCadastro")})
public class Quartos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "quarto")
    private Integer quarto;
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

    public Quartos(Integer quarto) {
        this.quarto = quarto;
    }

    public Quartos(Integer quarto, String quartoNumero, BigDecimal quartoValor, boolean quartoReservado, Date quartoDataCadastro) {
        this.quarto = quarto;
        this.quartoNumero = quartoNumero;
        this.quartoValor = quartoValor;
        this.quartoReservado = quartoReservado;
        this.quartoDataCadastro = quartoDataCadastro;
    }

    public Integer getQuarto() {
        return quarto;
    }

    public void setQuarto(Integer quarto) {
        this.quarto = quarto;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (quarto != null ? quarto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quartos)) {
            return false;
        }
        Quartos other = (Quartos) object;
        if ((this.quarto == null && other.quarto != null) || (this.quarto != null && !this.quarto.equals(other.quarto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Quartos[ quarto=" + quarto + " ]";
    }
    
}
