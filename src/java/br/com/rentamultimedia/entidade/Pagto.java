package br.com.rentamultimedia.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "pagto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagto.findAll", query = "SELECT p FROM Pagto p"),
    @NamedQuery(name = "Pagto.findByCodPagto", query = "SELECT p FROM Pagto p WHERE p.codPagto = :codPagto"),
    @NamedQuery(name = "Pagto.findByValorPed", query = "SELECT p FROM Pagto p WHERE p.valorPed = :valorPed"),
    @NamedQuery(name = "Pagto.findByValorDesc", query = "SELECT p FROM Pagto p WHERE p.valorDesc = :valorDesc"),
    @NamedQuery(name = "Pagto.findByCodTipPagtoFK", query = "SELECT p FROM Pagto p WHERE p.codTipPagtoFK = :codTipPagtoFK"),
    @NamedQuery(name = "Pagto.findByCodNFFK", query = "SELECT p FROM Pagto p WHERE p.codNFFK = :codNFFK")})
public class Pagto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodPagto")
    private Integer codPagto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ValorPed")
    private BigDecimal valorPed;
    @Column(name = "ValorDesc")
    private BigDecimal valorDesc;
    @Column(name = "CodTipPagtoFK")
    private Integer codTipPagtoFK;
    @Column(name = "CodNFFK")
    private Integer codNFFK;

    public Pagto() {
    }

    public Pagto(Integer codPagto) {
        this.codPagto = codPagto;
    }

    public Integer getCodPagto() {
        return codPagto;
    }

    public void setCodPagto(Integer codPagto) {
        this.codPagto = codPagto;
    }

    public BigDecimal getValorPed() {
        return valorPed;
    }

    public void setValorPed(BigDecimal valorPed) {
        this.valorPed = valorPed;
    }

    public BigDecimal getValorDesc() {
        return valorDesc;
    }

    public void setValorDesc(BigDecimal valorDesc) {
        this.valorDesc = valorDesc;
    }

    public Integer getCodTipPagtoFK() {
        return codTipPagtoFK;
    }

    public void setCodTipPagtoFK(Integer codTipPagtoFK) {
        this.codTipPagtoFK = codTipPagtoFK;
    }

    public Integer getCodNFFK() {
        return codNFFK;
    }

    public void setCodNFFK(Integer codNFFK) {
        this.codNFFK = codNFFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPagto != null ? codPagto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagto)) {
            return false;
        }
        Pagto other = (Pagto) object;
        if ((this.codPagto == null && other.codPagto != null) || (this.codPagto != null && !this.codPagto.equals(other.codPagto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Pagto[ codPagto=" + codPagto + " ]";
    }
    
}
