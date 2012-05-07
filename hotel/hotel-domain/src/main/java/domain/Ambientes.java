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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AlexPorto
 */
@Entity
@Table(name = "ambientes")
public class Ambientes implements Persistent, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "ambientes-sequence")
    @SequenceGenerator(name = "ambientes-sequence",
    sequenceName = "ambientes_seq")
    private Long id;
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
    @JoinColumn(name = "hoteis", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Hoteis hoteis;
    @OneToMany(mappedBy = "ambientes")
    private List<Ramais> ramaisList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ambientes")
    private List<ItensReservas> itensReservasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ambientes")
    private List<Pacotes> pacotesList;

    public Ambientes() {
    }

    public Ambientes(Integer ambiente, String ambienteNome, String ambienteObservacao, BigDecimal ambienteValor, boolean ambienteReservado) {
        this.ambienteNome = ambienteNome;
        this.ambienteObservacao = ambienteObservacao;
        this.ambienteValor = ambienteValor;
        this.ambienteReservado = ambienteReservado;
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

    public Hoteis getHoteis() {
        return hoteis;
    }

    public void setHoteis(Hoteis hoteis) {
        this.hoteis = hoteis;
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
    public void setId(Serializable id) {
        this.id = (Long) id;
    }

    @Override
    public Long getId() {
       return this.id;
    }
}
