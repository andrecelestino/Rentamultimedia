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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author André
 */
@Entity
@Table(name = "entrega")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entrega.findAll", query = "SELECT e FROM Entrega e"),
    @NamedQuery(name = "Entrega.findByCodEntrega", query = "SELECT e FROM Entrega e WHERE e.codEntrega = :codEntrega"),
    @NamedQuery(name = "Entrega.findByDataEntrega", query = "SELECT e FROM Entrega e WHERE e.dataEntrega = :dataEntrega"),
    @NamedQuery(name = "Entrega.findByEndEntrega", query = "SELECT e FROM Entrega e WHERE e.endEntrega = :endEntrega")})
public class Entrega implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodEntrega")
    private Integer codEntrega;
    @Column(name = "DataEntrega")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEntrega;
    @Size(max = 100)
    @Column(name = "EndEntrega")
    private String endEntrega;

    public Entrega() {
    }

    public Entrega(Integer codEntrega) {
        this.codEntrega = codEntrega;
    }

    public Integer getCodEntrega() {
        return codEntrega;
    }

    public void setCodEntrega(Integer codEntrega) {
        this.codEntrega = codEntrega;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getEndEntrega() {
        return endEntrega;
    }

    public void setEndEntrega(String endEntrega) {
        this.endEntrega = endEntrega;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEntrega != null ? codEntrega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrega)) {
            return false;
        }
        Entrega other = (Entrega) object;
        if ((this.codEntrega == null && other.codEntrega != null) || (this.codEntrega != null && !this.codEntrega.equals(other.codEntrega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Entrega[ codEntrega=" + codEntrega + " ]";
    }
    
}
