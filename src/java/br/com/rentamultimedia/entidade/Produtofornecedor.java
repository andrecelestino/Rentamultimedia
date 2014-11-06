package br.com.rentamultimedia.entidade;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "produtofornecedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtofornecedor.findAll", query = "SELECT p FROM Produtofornecedor p"),
    @NamedQuery(name = "Produtofornecedor.findByCodPrdForn", query = "SELECT p FROM Produtofornecedor p WHERE p.codPrdForn = :codPrdForn"),
    @NamedQuery(name = "Produtofornecedor.findByQuantidadePrd", query = "SELECT p FROM Produtofornecedor p WHERE p.quantidadePrd = :quantidadePrd"),
    @NamedQuery(name = "Produtofornecedor.findByCodFornFK", query = "SELECT p FROM Produtofornecedor p WHERE p.codFornFK = :codFornFK")})
public class Produtofornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodPrdForn")
    private Integer codPrdForn;
    @Column(name = "QuantidadePrd")
    private BigInteger quantidadePrd;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CodProdutoFK ")
    private Produto produto;
    @Column(name = "CodFornFK")
    private Integer codFornFK;

    public Produtofornecedor() {
    }

    public Produtofornecedor(Integer codPrdForn) {
        this.codPrdForn = codPrdForn;
    }

    public Integer getCodPrdForn() {
        return codPrdForn;
    }

    public void setCodPrdForn(Integer codPrdForn) {
        this.codPrdForn = codPrdForn;
    }

    public BigInteger getQuantidadePrd() {
        return quantidadePrd;
    }

    public void setQuantidadePrd(BigInteger quantidadePrd) {
        this.quantidadePrd = quantidadePrd;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public Integer getCodFornFK() {
        return codFornFK;
    }

    public void setCodFornFK(Integer codFornFK) {
        this.codFornFK = codFornFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPrdForn != null ? codPrdForn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtofornecedor)) {
            return false;
        }
        Produtofornecedor other = (Produtofornecedor) object;
        if ((this.codPrdForn == null && other.codPrdForn != null) || (this.codPrdForn != null && !this.codPrdForn.equals(other.codPrdForn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.rentamultimedia.entidade.Produtofornecedor[ codPrdForn=" + codPrdForn + " ]";
    }
    
}
