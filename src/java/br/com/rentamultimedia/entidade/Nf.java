package br.com.rentamultimedia.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "nf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nf.findAll", query = "SELECT n FROM Nf n"),
    @NamedQuery(name = "Nf.findByCodNF", query = "SELECT n FROM Nf n WHERE n.codNF = :codNF"),
    @NamedQuery(name = "Nf.findByNumNF", query = "SELECT n FROM Nf n WHERE n.numNF = :numNF"),
    @NamedQuery(name = "Nf.findByEmailNF", query = "SELECT n FROM Nf n WHERE n.emailNF = :emailNF"),
    @NamedQuery(name = "Nf.findByDataEmissaoNF", query = "SELECT n FROM Nf n WHERE n.dataEmissaoNF = :dataEmissaoNF"),
    @NamedQuery(name = "Nf.findByDscPedido", query = "SELECT n FROM Nf n WHERE n.dscPedido = :dscPedido"),
    @NamedQuery(name = "Nf.findByValorNF", query = "SELECT n FROM Nf n WHERE n.valorNF = :valorNF")})
public class Nf implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodNF")
    private Integer codNF;
    @Column(name = "NumNF")
    private BigInteger numNF;
    @Size(max = 50)
    @Column(name = "EmailNF")
    private String emailNF;
    @Column(name = "DataEmissaoNF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEmissaoNF;
    @Size(max = 500)
    @Column(name = "DscPedido")
    private String dscPedido;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ValorNF")
    private BigDecimal valorNF;
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="CodEntrega")
    private Entrega entrega;
    
    public Nf() {
    }

    public Nf(Integer codNF) {
        this.codNF = codNF;
    }

    public Integer getCodNF() {
        return codNF;
    }

    public void setCodNF(Integer codNF) {
        this.codNF = codNF;
    }

    public BigInteger getNumNF() {
        return numNF;
    }

    public void setNumNF(BigInteger numNF) {
        this.numNF = numNF;
    }

    public String getEmailNF() {
        return emailNF;
    }

    public void setEmailNF(String emailNF) {
        this.emailNF = emailNF;
    }

    public Date getDataEmissaoNF() {
        return dataEmissaoNF;
    }

    public void setDataEmissaoNF(Date dataEmissaoNF) {
        this.dataEmissaoNF = dataEmissaoNF;
    }

    public String getDscPedido() {
        return dscPedido;
    }

    public void setDscPedido(String dscPedido) {
        this.dscPedido = dscPedido;
    }

    public BigDecimal getValorNF() {
        return valorNF;
    }

    public void setValorNF(BigDecimal valorNF) {
        this.valorNF = valorNF;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codNF != null ? codNF.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nf)) {
            return false;
        }
        Nf other = (Nf) object;
        if ((this.codNF == null && other.codNF != null) || (this.codNF != null && !this.codNF.equals(other.codNF))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Nf[ codNF=" + codNF + " ]";
    }
    
}
