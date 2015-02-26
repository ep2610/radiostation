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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "ALBUM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Album.findAll", query = "SELECT a FROM Album a"),
    @NamedQuery(name = "Album.findByAlbumId", query = "SELECT a FROM Album a WHERE a.albumId = :albumId"),
    @NamedQuery(name = "Album.findByTitle", query = "SELECT a FROM Album a WHERE a.title = :title"),
    @NamedQuery(name = "Album.findByReleasedate", query = "SELECT a FROM Album a WHERE a.releasedate = :releasedate"),
    @NamedQuery(name = "Album.findByType", query = "SELECT a FROM Album a WHERE a.type = :type"),
    @NamedQuery(name = "Album.findByDisknumber", query = "SELECT a FROM Album a WHERE a.disknumber = :disknumber")})
public class Album implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ALBUM_ID")
    private Long albumId;
    @Basic(optional = false)
    @Column(name = "TITLE")
    private String title;
    @Column(name = "RELEASEDATE")
    @Temporal(TemporalType.DATE)
    private Date releasedate;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "DISKNUMBER")
    private Integer disknumber;
    @ManyToMany(mappedBy = "albumList")
    private List<Artist> artistList;
    @JoinTable(name = "ALBUM_MUSICGROUP", joinColumns = {
        @JoinColumn(name = "ALBUM_ID", referencedColumnName = "ALBUM_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP_ID")})
    @ManyToMany
    private List<Musicgroup> musicgroupList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "albumId")
    private List<Song> songList;
    @JoinColumn(name = "MUSICPRODUCTIONCOMPANYCOMPANY_ID", referencedColumnName = "COMPANY_ID")
    @ManyToOne(optional = false)
    private Musicproductioncompany musicproductioncompanycompanyId;

    public Album() {
    }

    public Album(Long albumId) {
        this.albumId = albumId;
    }

    public Album(Long albumId, String title) {
        this.albumId = albumId;
        this.title = title;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        Long oldAlbumId = this.albumId;
        this.albumId = albumId;
        changeSupport.firePropertyChange("albumId", oldAlbumId, albumId);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        String oldTitle = this.title;
        this.title = title;
        changeSupport.firePropertyChange("title", oldTitle, title);
    }

    public Date getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(Date releasedate) {
        Date oldReleasedate = this.releasedate;
        this.releasedate = releasedate;
        changeSupport.firePropertyChange("releasedate", oldReleasedate, releasedate);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        String oldType = this.type;
        this.type = type;
        changeSupport.firePropertyChange("type", oldType, type);
    }

    public Integer getDisknumber() {
        return disknumber;
    }

    public void setDisknumber(Integer disknumber) {
        Integer oldDisknumber = this.disknumber;
        this.disknumber = disknumber;
        changeSupport.firePropertyChange("disknumber", oldDisknumber, disknumber);
    }

    @XmlTransient
    public List<Artist> getArtistList() {
        return artistList;
    }

    public void setArtistList(List<Artist> artistList) {
        this.artistList = artistList;
    }

    @XmlTransient
    public List<Musicgroup> getMusicgroupList() {
        return musicgroupList;
    }

    public void setMusicgroupList(List<Musicgroup> musicgroupList) {
        this.musicgroupList = musicgroupList;
    }

    @XmlTransient
    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    public Musicproductioncompany getMusicproductioncompanycompanyId() {
        return musicproductioncompanycompanyId;
    }

    public void setMusicproductioncompanycompanyId(Musicproductioncompany musicproductioncompanycompanyId) {
        Musicproductioncompany oldMusicproductioncompanycompanyId = this.musicproductioncompanycompanyId;
        this.musicproductioncompanycompanyId = musicproductioncompanycompanyId;
        changeSupport.firePropertyChange("musicproductioncompanycompanyId", oldMusicproductioncompanycompanyId, musicproductioncompanycompanyId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (albumId != null ? albumId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.albumId == null && other.albumId != null) || (this.albumId != null && !this.albumId.equals(other.albumId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Album[ albumId=" + albumId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
