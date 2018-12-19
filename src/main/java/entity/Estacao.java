/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author gabri
 */
@Entity
@Table(name = "estacao")
@NamedQueries({
    @NamedQuery(name = "Estacao.findAll", query = "SELECT e FROM Estacao e")
    , @NamedQuery(name = "Estacao.findById", query = "SELECT e FROM Estacao e WHERE e.id = :id")
    , @NamedQuery(name = "Estacao.findByNome", query = "SELECT e FROM Estacao e WHERE e.nome = :nome")
    , @NamedQuery(name = "Estacao.findByEndereco", query = "SELECT e FROM Estacao e WHERE e.endereco = :endereco")
    , @NamedQuery(name = "Estacao.findByTel", query = "SELECT e FROM Estacao e WHERE e.tel = :tel")})
public class Estacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "endereco")
    private String endereco;
    @Basic(optional = false)
    @Column(name = "tel")
    private String tel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estOri")
    private List<Aluguel> aluguelList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estDest")
    private List<Aluguel> aluguelList1;

    public Estacao() {
    }

    public Estacao(Integer id) {
        this.id = id;
    }

    public Estacao(Integer id, String nome, String endereco, String tel) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.tel = tel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<Aluguel> getAluguelList() {
        return aluguelList;
    }

    public void setAluguelList(List<Aluguel> aluguelList) {
        this.aluguelList = aluguelList;
    }

    public List<Aluguel> getAluguelList1() {
        return aluguelList1;
    }

    public void setAluguelList1(List<Aluguel> aluguelList1) {
        this.aluguelList1 = aluguelList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estacao)) {
            return false;
        }
        Estacao other = (Estacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Estacao[ id=" + id + " ]";
    }
    
}
