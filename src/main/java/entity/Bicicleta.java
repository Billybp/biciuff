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
@Table(name = "bicicleta")
@NamedQueries({
    @NamedQuery(name = "Bicicleta.findAll", query = "SELECT b FROM Bicicleta b")
    , @NamedQuery(name = "Bicicleta.findById", query = "SELECT b FROM Bicicleta b WHERE b.id = :id")
    , @NamedQuery(name = "Bicicleta.findByNumSerie", query = "SELECT b FROM Bicicleta b WHERE b.numSerie = :numSerie")
    , @NamedQuery(name = "Bicicleta.findByDisponivel", query = "SELECT b FROM Bicicleta b WHERE b.disponivel = :disponivel")})
public class Bicicleta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "numSerie")
    private String numSerie;
    @Column(name = "Disponivel")
    private Boolean disponivel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "biciId")
    private List<Aluguel> aluguelList;

    public Bicicleta() {
    }

    public Bicicleta(Integer id) {
        this.id = id;
    }

    public Bicicleta(Integer id, String numSerie) {
        this.id = id;
        this.numSerie = numSerie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public List<Aluguel> getAluguelList() {
        return aluguelList;
    }

    public void setAluguelList(List<Aluguel> aluguelList) {
        this.aluguelList = aluguelList;
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
        if (!(object instanceof Bicicleta)) {
            return false;
        }
        Bicicleta other = (Bicicleta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Bicicleta[ id=" + id + " ]";
    }
    
}
