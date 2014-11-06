package br.com.rentamultimedia.entidade;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "itemlocacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itemlocacao.findAll", query = "SELECT i FROM Itemlocacao i"),
    @NamedQuery(name = "Itemlocacao.findByCodItemLocacao", query = "SELECT i FROM Itemlocacao i WHERE i.codItemLocacao = :codItemLocacao"),
    @NamedQuery(name = "Itemlocacao.findByQuantidadeLoc", query = "SELECT i FROM Itemlocacao i WHERE i.quantidadeLoc = :quantidadeLoc"),
    @NamedQuery(name = "Itemlocacao.findByCodProdutoFK", query = "SELECT i FROM Itemlocacao i WHERE i.codProdutoFK = :codProdutoFK"),
    @NamedQuery(name = "Itemlocacao.findByCodPedidoFK", query = "SELECT i FROM Itemlocacao i WHERE i.codPedidoFK = :codPedidoFK")})
public class Itemlocacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodItemLocacao")
    private Integer codItemLocacao;
    @Column(name = "QuantidadeLoc")
    private BigInteger quantidadeLoc;
    @Column(name = "CodProdutoFK")
    private Integer codProdutoFK;
    @Column(name = "CodPedidoFK")
    private Integer codPedidoFK;

    public Itemlocacao() {
    }

    public Itemlocacao(Integer codItemLocacao) {
        this.codItemLocacao = codItemLocacao;
    }

    public Integer getCodItemLocacao() {
        return codItemLocacao;
    }

    public void setCodItemLocacao(Integer codItemLocacao) {
        this.codItemLocacao = codItemLocacao;
    }

    public BigInteger getQuantidadeLoc() {
        return quantidadeLoc;
    }

    public void setQuantidadeLoc(BigInteger quantidadeLoc) {
        this.quantidadeLoc = quantidadeLoc;
    }

    public Integer getCodProdutoFK() {
        return codProdutoFK;
    }

    public void setCodProdutoFK(Integer codProdutoFK) {
        this.codProdutoFK = codProdutoFK;
    }

    public Integer getCodPedidoFK() {
        return codPedidoFK;
    }

    public void setCodPedidoFK(Integer codPedidoFK) {
        this.codPedidoFK = codPedidoFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codItemLocacao != null ? codItemLocacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemlocacao)) {
            return false;
        }
        Itemlocacao other = (Itemlocacao) object;
        if ((this.codItemLocacao == null && other.codItemLocacao != null) || (this.codItemLocacao != null && !this.codItemLocacao.equals(other.codItemLocacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Itemlocacao[ codItemLocacao=" + codItemLocacao + " ]";
    }
    
}
