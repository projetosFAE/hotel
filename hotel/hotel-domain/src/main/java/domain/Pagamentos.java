/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AlexPorto
 */
@Entity
@Table(name = "pagamentos")
public class Pagamentos implements Persistent, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "pagamentos-sequence")
    @SequenceGenerator(name = "pagamentos-sequence",
    sequenceName = "pagamentos_seq")
    private Long id;
    @Column(name = "pagamento_nome")
    private String pagamentoNome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pagamentos")
    private List<Financeiros> financeirosList;

    public Pagamentos() {
    }

    @Override
    public void setId(Serializable id) {
        this.id = (Long) id;
    }

    @Override
    public Long getId() {
       return this.id;
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
}
