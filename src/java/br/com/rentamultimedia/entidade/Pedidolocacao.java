package br.com.rentamultimedia.entidade;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "pedidolocacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedidolocacao.findAll", query = "SELECT p FROM Pedidolocacao p"),
    @NamedQuery(name = "Pedidolocacao.findByCodPedido", query = "SELECT p FROM Pedidolocacao p WHERE p.codPedido = :codPedido"),
    @NamedQuery(name = "Pedidolocacao.findByDataPedido", query = "SELECT p FROM Pedidolocacao p WHERE p.dataPedido = :dataPedido"),
    @NamedQuery(name = "Pedidolocacao.findByCodClienteFK", query = "SELECT p FROM Pedidolocacao p WHERE p.codClienteFK = :codClienteFK"),
    @NamedQuery(name = "Pedidolocacao.findByCodDevolucaoFK", query = "SELECT p FROM Pedidolocacao p WHERE p.codDevolucaoFK = :codDevolucaoFK"),
    @NamedQuery(name = "Pedidolocacao.findByCodFuncFK", query = "SELECT p FROM Pedidolocacao p WHERE p.codFuncFK = :codFuncFK"),
    @NamedQuery(name = "Pedidolocacao.findByCodPagtoFK", query = "SELECT p FROM Pedidolocacao p WHERE p.codPagtoFK = :codPagtoFK")})
public class Pedidolocacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodPedido")
    private Integer codPedido;
    @Column(name = "DataPedido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPedido;
    @Column(name = "CodClienteFK")
    private Integer codClienteFK;
    @Column(name = "CodDevolucaoFK")
    private Integer codDevolucaoFK;
    @Column(name = "CodFuncFK")
    private Integer codFuncFK;
    @Column(name = "CodPagtoFK")
    private Integer codPagtoFK;

    public Pedidolocacao() {
    }

    public Pedidolocacao(Integer codPedido) {
        this.codPedido = codPedido;
    }

    public Integer getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(Integer codPedido) {
        this.codPedido = codPedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Integer getCodClienteFK() {
        return codClienteFK;
    }

    public void setCodClienteFK(Integer codClienteFK) {
        this.codClienteFK = codClienteFK;
    }

    public Integer getCodDevolucaoFK() {
        return codDevolucaoFK;
    }

    public void setCodDevolucaoFK(Integer codDevolucaoFK) {
        this.codDevolucaoFK = codDevolucaoFK;
    }

    public Integer getCodFuncFK() {
        return codFuncFK;
    }

    public void setCodFuncFK(Integer codFuncFK) {
        this.codFuncFK = codFuncFK;
    }

    public Integer getCodPagtoFK() {
        return codPagtoFK;
    }

    public void setCodPagtoFK(Integer codPagtoFK) {
        this.codPagtoFK = codPagtoFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPedido != null ? codPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedidolocacao)) {
            return false;
        }
        Pedidolocacao other = (Pedidolocacao) object;
        if ((this.codPedido == null && other.codPedido != null) || (this.codPedido != null && !this.codPedido.equals(other.codPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Pedidolocacao[ codPedido=" + codPedido + " ]";
    }
    
}
