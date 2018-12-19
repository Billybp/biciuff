/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.faces.context.FacesContext;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author gabri
 */
@Entity
@Table(name = "aluguel")
@NamedQueries({
    @NamedQuery(name = "Aluguel.findAll", query = "SELECT a FROM Aluguel a")
    , @NamedQuery(name = "Aluguel.findById", query = "SELECT a FROM Aluguel a WHERE a.id = :id")
    , @NamedQuery(name = "Aluguel.findByHoraRet", query = "SELECT a FROM Aluguel a WHERE a.horaRet = :horaRet")})
public class Aluguel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "horaRet")
    @Temporal(TemporalType.DATE)
    private Date horaRet;
    @JoinColumn(name = "estOri", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Estacao estOri;
    @JoinColumn(name = "userID", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario userID;
    @JoinColumn(name = "biciId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Bicicleta biciId;
    @JoinColumn(name = "estDest", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Estacao estDest;

    public Aluguel() {
    }

    public Aluguel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getHoraRet() {
        return horaRet;
    }

    public void setHoraRet(Date horaRet) {
        this.horaRet = horaRet;
    }

    public Estacao getEstOri() {
        return estOri;
    }

    public void setEstOri(Estacao estOri) {
        this.estOri = estOri;
    }

    public Usuario getUserID() {
        return userID;
    }

    public void setUserID(Usuario userID) {
        this.userID = userID;
    }

    public Bicicleta getBiciId() {
        return biciId;
    }

    public void setBiciId(Bicicleta biciId) {
        this.biciId = biciId;
    }

    public Estacao getEstDest() {
        return estDest;
    }

    public void setEstDest(Estacao estDest) {
        this.estDest = estDest;
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
        if (!(object instanceof Aluguel)) {
            return false;
        }
        Aluguel other = (Aluguel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Aluguel[ id=" + id + " ]";
    }
    
    
}
