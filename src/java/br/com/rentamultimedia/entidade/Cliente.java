package br.com.rentamultimedia.entidade;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByCodCliente", query = "SELECT c FROM Cliente c WHERE c.codCliente = :codCliente"),
    @NamedQuery(name = "Cliente.findByNomeCliente", query = "SELECT c FROM Cliente c WHERE c.nomeCliente = :nomeCliente"),
    @NamedQuery(name = "Cliente.findByCPFCliente", query = "SELECT c FROM Cliente c WHERE c.cPFCliente = :cPFCliente"),
    @NamedQuery(name = "Cliente.findByRGCliente", query = "SELECT c FROM Cliente c WHERE c.rGCliente = :rGCliente"),
    @NamedQuery(name = "Cliente.findByTelCliente", query = "SELECT c FROM Cliente c WHERE c.telCliente = :telCliente"),
    @NamedQuery(name = "Cliente.findByEndCliente", query = "SELECT c FROM Cliente c WHERE c.endCliente = :endCliente")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodCliente")
    private Integer codCliente;
    @Size(max = 50)
    @Column(name = "NomeCliente")
    private String nomeCliente;
    @Column(name = "CPFCliente")
    private Long cPFCliente;
    @Size(max = 9)
    @Column(name = "RGCliente")
    private String rGCliente;
    @Column(name = "TelCliente")
    private Long telCliente;
    @Size(max = 50)
    @Column(name = "EndCliente")
    private String endCliente;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CodTipoClienteFK")
    private Tipocliente tipocliente;
    
    public Cliente() {
    }

    public Cliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Long getCPFCliente() {
        return cPFCliente;
    }

    public void setCPFCliente(Long cPFCliente) {
        this.cPFCliente = cPFCliente;
    }

    public String getRGCliente() {
        return rGCliente;
    }

    public void setRGCliente(String rGCliente) {
        this.rGCliente = rGCliente;
    }

    public Long getTelCliente() {
        return telCliente;
    }

    public void setTelCliente(Long telCliente) {
        this.telCliente = telCliente;
    }

    public String getEndCliente() {
        return endCliente;
    }

    public void setEndCliente(String endCliente) {
        this.endCliente = endCliente;
    }

    public Tipocliente getTipocliente() {
        return tipocliente;
    }

    public void setTipocliente(Tipocliente tipocliente) {
        this.tipocliente = tipocliente;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCliente != null ? codCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.codCliente == null && other.codCliente != null) || (this.codCliente != null && !this.codCliente.equals(other.codCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.rentamultimedia.entidade.Cliente[ codCliente=" + codCliente + " ]";
    }
    
}
