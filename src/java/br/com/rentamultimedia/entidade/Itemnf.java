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
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "itemnf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itemnf.findAll", query = "SELECT i FROM Itemnf i"),
    @NamedQuery(name = "Itemnf.findByCodItemNf", query = "SELECT i FROM Itemnf i WHERE i.codItemNf = :codItemNf"),
    @NamedQuery(name = "Itemnf.findByCodItemLocacaoFK", query = "SELECT i FROM Itemnf i WHERE i.codItemLocacaoFK = :codItemLocacaoFK"),
    @NamedQuery(name = "Itemnf.findByCodNfFK", query = "SELECT i FROM Itemnf i WHERE i.codNfFK = :codNfFK")})
public class Itemnf implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodItemNf")
    private Integer codItemNf;
    @Column(name = "CodItemLocacaoFK")
    private Integer codItemLocacaoFK;
    @Column(name = "CodNfFK")
    private Integer codNfFK;

    public Itemnf() {
    }

    public Itemnf(Integer codItemNf) {
        this.codItemNf = codItemNf;
    }

    public Integer getCodItemNf() {
        return codItemNf;
    }

    public void setCodItemNf(Integer codItemNf) {
        this.codItemNf = codItemNf;
    }

    public Integer getCodItemLocacaoFK() {
        return codItemLocacaoFK;
    }

    public void setCodItemLocacaoFK(Integer codItemLocacaoFK) {
        this.codItemLocacaoFK = codItemLocacaoFK;
    }

    public Integer getCodNfFK() {
        return codNfFK;
    }

    public void setCodNfFK(Integer codNfFK) {
        this.codNfFK = codNfFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codItemNf != null ? codItemNf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemnf)) {
            return false;
        }
        Itemnf other = (Itemnf) object;
        if ((this.codItemNf == null && other.codItemNf != null) || (this.codItemNf != null && !this.codItemNf.equals(other.codItemNf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Itemnf[ codItemNf=" + codItemNf + " ]";
    }
    
}
