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
@Table(name = "pagamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagamentos.findAll", query = "SELECT p FROM Pagamentos p"),
    @NamedQuery(name = "Pagamentos.findByPagamento", query = "SELECT p FROM Pagamentos p WHERE p.pagamento = :pagamento"),
    @NamedQuery(name = "Pagamentos.findByPagamentoNome", query = "SELECT p FROM Pagamentos p WHERE p.pagamentoNome = :pagamentoNome")})
public class Pagamentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pagamento")
    private Integer pagamento;
    @Column(name = "pagamento_nome")
    private String pagamentoNome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pagamento")
    private List<Financeiros> financeirosList;

    public Pagamentos() {
    }

    public Pagamentos(Integer pagamento) {
        this.pagamento = pagamento;
    }

    public Integer getPagamento() {
        return pagamento;
    }

    public void setPagamento(Integer pagamento) {
        this.pagamento = pagamento;
    }

    public String getPagamentoNome() {
        return pagamentoNome;
    }

    public void setPagamentoNome(String pagamentoNome) {
        this.pagamentoNome = pagamentoNome;
    }

    @XmlTransient
    public List<Financeiros> getFinanceirosList() {
        return financeirosList;
    }

    public void setFinanceirosList(List<Financeiros> financeirosList) {
        this.financeirosList = financeirosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pagamento != null ? pagamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagamentos)) {
            return false;
        }
        Pagamentos other = (Pagamentos) object;
        if ((this.pagamento == null && other.pagamento != null) || (this.pagamento != null && !this.pagamento.equals(other.pagamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cmd.hoteldomain.domain.Pagamentos[ pagamento=" + pagamento + " ]";
    }
    
}
