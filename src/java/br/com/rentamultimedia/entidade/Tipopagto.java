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
@Table(name = "tipopagto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipopagto.findAll", query = "SELECT t FROM Tipopagto t"),
    @NamedQuery(name = "Tipopagto.findByCodTipPagto", query = "SELECT t FROM Tipopagto t WHERE t.codTipPagto = :codTipPagto"),
    @NamedQuery(name = "Tipopagto.findByTipoPagto", query = "SELECT t FROM Tipopagto t WHERE t.tipoPagto = :tipoPagto")})
public class Tipopagto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodTipPagto")
    private Integer codTipPagto;
    @Size(max = 20)
    @Column(name = "TipoPagto")
    private String tipoPagto;

    public Tipopagto() {
    }

    public Tipopagto(Integer codTipPagto) {
        this.codTipPagto = codTipPagto;
    }

    public Integer getCodTipPagto() {
        return codTipPagto;
    }

    public void setCodTipPagto(Integer codTipPagto) {
        this.codTipPagto = codTipPagto;
    }

    public String getTipoPagto() {
        return tipoPagto;
    }

    public void setTipoPagto(String tipoPagto) {
        this.tipoPagto = tipoPagto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipPagto != null ? codTipPagto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipopagto)) {
            return false;
        }
        Tipopagto other = (Tipopagto) object;
        if ((this.codTipPagto == null && other.codTipPagto != null) || (this.codTipPagto != null && !this.codTipPagto.equals(other.codTipPagto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Tipopagto[ codTipPagto=" + codTipPagto + " ]";
    }
    
}
