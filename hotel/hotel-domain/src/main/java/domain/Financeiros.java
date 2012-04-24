/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AlexPorto
 */
@Entity
@Table(name = "financeiros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Financeiros.findAll", query = "SELECT f FROM Financeiros f"),
    @NamedQuery(name = "Financeiros.findByFinanceiro", query = "SELECT f FROM Financeiros f WHERE f.financeiro = :financeiro"),
    @NamedQuery(name = "Financeiros.findByFinanceiroValor", query = "SELECT f FROM Financeiros f WHERE f.financeiroValor = :financeiroValor"),
    @NamedQuery(name = "Financeiros.findByFinanceiroData", query = "SELECT f FROM Financeiros f WHERE f.financeiroData = :financeiroData")})
public class Financeiros implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "financeiro")
    private Integer financeiro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "financeiro_valor")
    private BigDecimal financeiroValor;
    @Basic(optional = false)
    @Column(name = "financeiro_data")
    @Temporal(TemporalType.DATE)
    private Date financeiroData;
    @JoinColumn(name = "reserva", referencedColumnName = "reserva")
    @ManyToOne(optional = false)
    private Reservas reservas;
    @JoinColumn(name = "pagamento", referencedColumnName = "pagamento")
    @ManyToOne(optional = false)
    private Pagamentos pagamentos;

    public Financeiros() {
    }

    public Financeiros(Integer financeiro) {
        this.financeiro = financeiro;
    }

    public Financeiros(Integer financeiro, BigDecimal financeiroValor, Date financeiroData) {
        this.financeiro = financeiro;
        this.financeiroValor = financeiroValor;
        this.financeiroData = financeiroData;
    }

    public Integer getFinanceiro() {
        return financeiro;
    }

    public void setFinanceiro(Integer financeiro) {
        this.financeiro = financeiro;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (financeiro != null ? financeiro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Financeiros)) {
            return false;
        }
        Financeiros other = (Financeiros) object;
        if ((this.financeiro == null && other.financeiro != null) || (this.financeiro != null && !this.financeiro.equals(other.financeiro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Financeiros[ financeiro=" + financeiro + " ]";
    }
    
}
