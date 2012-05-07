/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author AlexPorto
 */
@Entity
@Table(name = "financeiros")
public class Financeiros implements Persistent, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "financeiros-sequence")
    @SequenceGenerator(name = "financeiros-sequence",
    sequenceName = "financeiros_seq")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "financeiro_valor")
    private BigDecimal financeiroValor;
    @Basic(optional = false)
    @Column(name = "financeiro_data")
    @Temporal(TemporalType.DATE)
    private Date financeiroData;
    @JoinColumn(name = "reserva", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Reservas reservas;
    @JoinColumn(name = "pagamento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pagamentos pagamentos;

    public Financeiros() {
    }

    public Financeiros(Integer financeiro, BigDecimal financeiroValor, Date financeiroData) {
        this.financeiroValor = financeiroValor;
        this.financeiroData = financeiroData;
    }

    @Override
    public void setId(Serializable id) {
        this.id = (Long) id;
    }

    @Override
    public Long getId() {
       return this.id;
    }

    public BigDecimal getFinanceiroValor() {
        return financeiroValor;
    }

    public void setFinanceiroValor(BigDecimal financeiroValor) {
        this.financeiroValor = financeiroValor;
    }

    public Date getFinanceiroData() {
        return financeiroData;
    }

    public void setFinanceiroData(Date financeiroData) {
        this.financeiroData = financeiroData;
    }

    public Reservas getReservas() {
        return reservas;
    }

    public void setReservas(Reservas reservas) {
        this.reservas = reservas;
    }

    public Pagamentos getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(Pagamentos pagamentos) {
        this.pagamentos = pagamentos;
    }    
}
