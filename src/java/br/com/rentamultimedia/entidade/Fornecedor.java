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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "fornecedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f"),
    @NamedQuery(name = "Fornecedor.findByCodForn", query = "SELECT f FROM Fornecedor f WHERE f.codForn = :codForn"),
    @NamedQuery(name = "Fornecedor.findByRazaoForn", query = "SELECT f FROM Fornecedor f WHERE f.razaoForn = :razaoForn"),
    @NamedQuery(name = "Fornecedor.findByCNPJForn", query = "SELECT f FROM Fornecedor f WHERE f.cNPJForn = :cNPJForn"),
    @NamedQuery(name = "Fornecedor.findByTelForn", query = "SELECT f FROM Fornecedor f WHERE f.telForn = :telForn"),
    @NamedQuery(name = "Fornecedor.findByEndForn", query = "SELECT f FROM Fornecedor f WHERE f.endForn = :endForn"),
    @NamedQuery(name = "Fornecedor.findByInscriEstadForn", query = "SELECT f FROM Fornecedor f WHERE f.inscriEstadForn = :inscriEstadForn")})
public class Fornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodForn")
    private Integer codForn;
    @Size(max = 50)
    @Column(name = "RazaoForn")
    private String razaoForn;
    @Size(max = 14)
    @Column(name = "CNPJForn")
    private String cNPJForn;
    @Column(name = "TelForn")
    private Long telForn;
    @Size(max = 50)
    @Column(name = "EndForn")
    private String endForn;
    @Column(name = "InscriEstadForn")
    private BigInteger inscriEstadForn;

    public Fornecedor() {
    }

    public Fornecedor(Integer codForn) {
        this.codForn = codForn;
    }

    public Integer getCodForn() {
        return codForn;
    }

    public void setCodForn(Integer codForn) {
        this.codForn = codForn;
    }

    public String getRazaoForn() {
        return razaoForn;
    }

    public void setRazaoForn(String razaoForn) {
        this.razaoForn = razaoForn;
    }

    public String getCNPJForn() {
        return cNPJForn;
    }

    public void setCNPJForn(String cNPJForn) {
        this.cNPJForn = cNPJForn;
    }

    public Long getTelForn() {
        return telForn;
    }

    public void setTelForn(Long telForn) {
        this.telForn = telForn;
    }

    public String getEndForn() {
        return endForn;
    }

    public void setEndForn(String endForn) {
        this.endForn = endForn;
    }

    public BigInteger getInscriEstadForn() {
        return inscriEstadForn;
    }

    public void setInscriEstadForn(BigInteger inscriEstadForn) {
        this.inscriEstadForn = inscriEstadForn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codForn != null ? codForn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.codForn == null && other.codForn != null) || (this.codForn != null && !this.codForn.equals(other.codForn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Fornecedor[ codForn=" + codForn + " ]";
    }
    
}
