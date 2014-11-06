package br.com.rentamultimedia.entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tipocliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipocliente.findAll", query = "SELECT t FROM Tipocliente t"),
    @NamedQuery(name = "Tipocliente.findByCodTipoCliente", query = "SELECT t FROM Tipocliente t WHERE t.codTipoCliente = :codTipoCliente"),
    @NamedQuery(name = "Tipocliente.findByTipoCliente", query = "SELECT t FROM Tipocliente t WHERE t.tipoCliente = :tipoCliente"),
    @NamedQuery(name = "Tipocliente.findByCNPJCliente", query = "SELECT t FROM Tipocliente t WHERE t.cNPJCliente = :cNPJCliente")})
public class Tipocliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodTipoCliente")
    private Integer codTipoCliente;
    @Size(max = 20)
    @Column(name = "TipoCliente")
    private String tipoCliente;
    @Size(max = 14)
    @Column(name = "CNPJCliente")
    private String cNPJCliente;
    
    public Tipocliente() {
    }

    public Tipocliente(Integer codTipoCliente) {
        this.codTipoCliente = codTipoCliente;
    }

    public Integer getCodTipoCliente() {
        return codTipoCliente;
    }

    public void setCodTipoCliente(Integer codTipoCliente) {
        this.codTipoCliente = codTipoCliente;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getCNPJCliente() {
        return cNPJCliente;
    }

    public void setCNPJCliente(String cNPJCliente) {
        this.cNPJCliente = cNPJCliente;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoCliente != null ? codTipoCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipocliente)) {
            return false;
        }
        Tipocliente other = (Tipocliente) object;
        if ((this.codTipoCliente == null && other.codTipoCliente != null) || (this.codTipoCliente != null && !this.codTipoCliente.equals(other.codTipoCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.rentamultimedia.entidade.Tipocliente[ codTipoCliente=" + codTipoCliente + " ]";
    }
    
}
