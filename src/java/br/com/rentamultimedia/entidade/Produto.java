package br.com.rentamultimedia.entidade;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByCodProduto", query = "SELECT p FROM Produto p WHERE p.codProduto = :codProduto"),
    @NamedQuery(name = "Produto.findByTipoProduto", query = "SELECT p FROM Produto p WHERE p.tipoProduto = :tipoProduto"),
    @NamedQuery(name = "Produto.findByMarcaProduto", query = "SELECT p FROM Produto p WHERE p.marcaProduto = :marcaProduto"),
    @NamedQuery(name = "Produto.findByNomeProduto", query = "SELECT p FROM Produto p WHERE p.nomeProduto = :nomeProduto"),
    @NamedQuery(name = "Produto.findByDataCompra", query = "SELECT p FROM Produto p WHERE p.dataCompra = :dataCompra"),
    @NamedQuery(name = "Produto.findByNFCompra", query = "SELECT p FROM Produto p WHERE p.nFCompra = :nFCompra")})
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodProduto")
    private Integer codProduto;
    @Size(max = 20)
    @Column(name = "TipoProduto")
    private String tipoProduto;
    @Size(max = 30)
    @Column(name = "MarcaProduto")
    private String marcaProduto;
    @Size(max = 30)
    @Column(name = "NomeProduto")
    private String nomeProduto;
    @Column(name = "DataCompra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCompra;
    @Column(name = "NFCompra")
    private BigInteger nFCompra;

    public Produto() {
    }

    public Produto(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public Integer getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public String getMarcaProduto() {
        return marcaProduto;
    }

    public void setMarcaProduto(String marcaProduto) {
        this.marcaProduto = marcaProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public BigInteger getNFCompra() {
        return nFCompra;
    }

    public void setNFCompra(BigInteger nFCompra) {
        this.nFCompra = nFCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProduto != null ? codProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.codProduto == null && other.codProduto != null) || (this.codProduto != null && !this.codProduto.equals(other.codProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Produto[ codProduto=" + codProduto + " ]";
    }
    
}
