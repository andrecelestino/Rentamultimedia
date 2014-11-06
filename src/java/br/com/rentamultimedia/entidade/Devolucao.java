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

@Entity
@Table(name = "devolucao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Devolucao.findAll", query = "SELECT d FROM Devolucao d"),
    @NamedQuery(name = "Devolucao.findByCodDevolucao", query = "SELECT d FROM Devolucao d WHERE d.codDevolucao = :codDevolucao"),
    @NamedQuery(name = "Devolucao.findByDataDevolucao", query = "SELECT d FROM Devolucao d WHERE d.dataDevolucao = :dataDevolucao"),
    @NamedQuery(name = "Devolucao.findByMotivoDevolucao", query = "SELECT d FROM Devolucao d WHERE d.motivoDevolucao = :motivoDevolucao")})
public class Devolucao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodDevolucao")
    private Integer codDevolucao;
    @Column(name = "DataDevolucao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDevolucao;
    @Size(max = 30)
    @Column(name = "MotivoDevolucao")
    private String motivoDevolucao;

    public Devolucao() {
    }

    public Devolucao(Integer codDevolucao) {
        this.codDevolucao = codDevolucao;
    }

    public Integer getCodDevolucao() {
        return codDevolucao;
    }

    public void setCodDevolucao(Integer codDevolucao) {
        this.codDevolucao = codDevolucao;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getMotivoDevolucao() {
        return motivoDevolucao;
    }

    public void setMotivoDevolucao(String motivoDevolucao) {
        this.motivoDevolucao = motivoDevolucao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDevolucao != null ? codDevolucao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Devolucao)) {
            return false;
        }
        Devolucao other = (Devolucao) object;
        if ((this.codDevolucao == null && other.codDevolucao != null) || (this.codDevolucao != null && !this.codDevolucao.equals(other.codDevolucao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Devolucao[ codDevolucao=" + codDevolucao + " ]";
    }
    
}
