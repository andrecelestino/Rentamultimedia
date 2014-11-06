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
@Table(name = "funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByCodFunc", query = "SELECT f FROM Funcionario f WHERE f.codFunc = :codFunc"),
    @NamedQuery(name = "Funcionario.findByNomFunc", query = "SELECT f FROM Funcionario f WHERE f.nomFunc = :nomFunc"),
    @NamedQuery(name = "Funcionario.findByIdadeFunc", query = "SELECT f FROM Funcionario f WHERE f.idadeFunc = :idadeFunc"),
    @NamedQuery(name = "Funcionario.findByCPFFuncionario", query = "SELECT f FROM Funcionario f WHERE f.cPFFuncionario = :cPFFuncionario"),
    @NamedQuery(name = "Funcionario.findByRGFuncionario", query = "SELECT f FROM Funcionario f WHERE f.rGFuncionario = :rGFuncionario"),
    @NamedQuery(name = "Funcionario.findByTelFuncionario", query = "SELECT f FROM Funcionario f WHERE f.telFuncionario = :telFuncionario"),
    @NamedQuery(name = "Funcionario.findByLoginFunc", query = "SELECT f FROM Funcionario f WHERE f.loginFunc = :loginFunc"),
    @NamedQuery(name = "Funcionario.findBySenhaFunc", query = "SELECT f FROM Funcionario f WHERE f.senhaFunc = :senhaFunc"),
    @NamedQuery(name = "Funcionario.findByPerfilFunc", query = "SELECT f FROM Funcionario f WHERE f.perfilFunc = :perfilFunc"),
    @NamedQuery(name = "Funcionario.findLogin", query = "SELECT f FROM Funcionario f WHERE f.loginFunc = :loginFunc AND f.senhaFunc = :senhaFunc")})
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodFunc")
    private Integer codFunc;
    @Size(max = 50)
    @Column(name = "NomFunc")
    private String nomFunc;
    @Column(name = "IdadeFunc")
    private Integer idadeFunc;
    @Column(name = "CPFFuncionario")
    private Long cPFFuncionario;
    @Size(max = 9)
    @Column(name = "RGFuncionario")
    private String rGFuncionario;
    @Column(name = "TelFuncionario")
    private Long telFuncionario;
    @Size(max = 30)
    @Column(name = "LoginFunc")
    private String loginFunc;
    @Size(max = 30)
    @Column(name = "SenhaFunc")
    private String senhaFunc;
    @Column(name = "PerfilFunc")
    private Integer perfilFunc;

    public Funcionario() {
    }

    public Funcionario(Integer codFunc) {
        this.codFunc = codFunc;
    }

    public Integer getCodFunc() {
        return codFunc;
    }

    public void setCodFunc(Integer codFunc) {
        this.codFunc = codFunc;
    }

    public String getNomFunc() {
        return nomFunc;
    }

    public void setNomFunc(String nomFunc) {
        this.nomFunc = nomFunc;
    }

    public Integer getIdadeFunc() {
        return idadeFunc;
    }

    public void setIdadeFunc(Integer idadeFunc) {
        this.idadeFunc = idadeFunc;
    }

    public Long getCPFFuncionario() {
        return cPFFuncionario;
    }

    public void setCPFFuncionario(Long cPFFuncionario) {
        this.cPFFuncionario = cPFFuncionario;
    }

    public String getRGFuncionario() {
        return rGFuncionario;
    }

    public void setRGFuncionario(String rGFuncionario) {
        this.rGFuncionario = rGFuncionario;
    }

    public Long getTelFuncionario() {
        return telFuncionario;
    }

    public void setTelFuncionario(Long telFuncionario) {
        this.telFuncionario = telFuncionario;
    }

    public String getLoginFunc() {
        return loginFunc;
    }

    public void setLoginFunc(String loginFunc) {
        this.loginFunc = loginFunc;
    }

    public String getSenhaFunc() {
        return senhaFunc;
    }

    public void setSenhaFunc(String senhaFunc) {
        this.senhaFunc = senhaFunc;
    }

    public Integer getPerfilFunc() {
        return perfilFunc;
    }

    public void setPerfilFunc(Integer perfilFunc) {
        this.perfilFunc = perfilFunc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFunc != null ? codFunc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.codFunc == null && other.codFunc != null) || (this.codFunc != null && !this.codFunc.equals(other.codFunc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Funcionario[ codFunc=" + codFunc + " ]";
    }
    
}
