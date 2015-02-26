/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sotos
 */
@Entity
@Table(name = "MUSICPRODUCTIONCOMPANY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Musicproductioncompany.findAll", query = "SELECT m FROM Musicproductioncompany m"),
    @NamedQuery(name = "Musicproductioncompany.findByCompanyId", query = "SELECT m FROM Musicproductioncompany m WHERE m.companyId = :companyId"),
    @NamedQuery(name = "Musicproductioncompany.findByName", query = "SELECT m FROM Musicproductioncompany m WHERE m.name = :name"),
    @NamedQuery(name = "Musicproductioncompany.findByAddress", query = "SELECT m FROM Musicproductioncompany m WHERE m.address = :address"),
    @NamedQuery(name = "Musicproductioncompany.findByTelephone", query = "SELECT m FROM Musicproductioncompany m WHERE m.telephone = :telephone")})
public class Musicproductioncompany implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COMPANY_ID")
    private Long companyId;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "TELEPHONE")
    private String telephone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "musicproductioncompanycompanyId")
    private List<Album> albumList;

    public Musicproductioncompany() {
    }

    public Musicproductioncompany(Long companyId) {
        this.companyId = companyId;
    }

    public Musicproductioncompany(Long companyId, String name) {
        this.companyId = companyId;
        this.name = name;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @XmlTransient
    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyId != null ? companyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Musicproductioncompany)) {
            return false;
        }
        Musicproductioncompany other = (Musicproductioncompany) object;
        if ((this.companyId == null && other.companyId != null) || (this.companyId != null && !this.companyId.equals(other.companyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Musicproductioncompany[ companyId=" + companyId + " ]";
    }
    
}
