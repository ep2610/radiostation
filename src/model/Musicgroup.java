/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sotos
 */
@Entity
@Table(name = "MUSICGROUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Musicgroup.findAll", query = "SELECT m FROM Musicgroup m"),
    @NamedQuery(name = "Musicgroup.findByGroupId", query = "SELECT m FROM Musicgroup m WHERE m.groupId = :groupId"),
    @NamedQuery(name = "Musicgroup.findByName", query = "SELECT m FROM Musicgroup m WHERE m.name = :name"),
    @NamedQuery(name = "Musicgroup.findByFormationdate", query = "SELECT m FROM Musicgroup m WHERE m.formationdate = :formationdate")})
public class Musicgroup implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GROUP_ID")
    private Long groupId;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "FORMATIONDATE")
    @Temporal(TemporalType.DATE)
    private Date formationdate;
    //@ManyToMany(mappedBy = "musicgroupList")
    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(name = "ARTIST_MUSICGROUP", joinColumns = {
        @JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP_ID" )}, inverseJoinColumns = {
        @JoinColumn(name = "ARTIST_ID", referencedColumnName = "ARTIST_ID" )})
    private List<Artist> artistList;
    @ManyToMany(mappedBy = "musicgroupList")
    private List<Album> albumList;

    public Musicgroup() {
    }

    public Musicgroup(Long groupId) {
        this.groupId = groupId;
    }

    public Musicgroup(Long groupId, String name) {
        this.groupId = groupId;
        this.name = name;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        Long oldGroupId = this.groupId;
        this.groupId = groupId;
        changeSupport.firePropertyChange("groupId", oldGroupId, groupId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public Date getFormationdate() {
        return formationdate;
    }

    public void setFormationdate(Date formationdate) {
        Date oldFormationdate = this.formationdate;
        this.formationdate = formationdate;
        changeSupport.firePropertyChange("formationdate", oldFormationdate, formationdate);
    }

    @XmlTransient
    public List<Artist> getArtistList() {
        return artistList;
    }

    public void setArtistList(List<Artist> artistList) {
        this.artistList = artistList;
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
        hash += (groupId != null ? groupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Musicgroup)) {
            return false;
        }
        Musicgroup other = (Musicgroup) object;
        if ((this.groupId == null && other.groupId != null) || (this.groupId != null && !this.groupId.equals(other.groupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Musicgroup[ groupId=" + groupId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
