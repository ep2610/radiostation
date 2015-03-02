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
@Table(name = "ARTIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artist.findAll", query = "SELECT a FROM Artist a"),
    @NamedQuery(name = "Artist.findByArtistId", query = "SELECT a FROM Artist a WHERE a.artistId = :artistId"),
    @NamedQuery(name = "Artist.findByFirstname", query = "SELECT a FROM Artist a WHERE a.firstname = :firstname"),
    @NamedQuery(name = "Artist.findByLastname", query = "SELECT a FROM Artist a WHERE a.lastname = :lastname"),
    @NamedQuery(name = "Artist.findByArtisticname", query = "SELECT a FROM Artist a WHERE a.artisticname = :artisticname"),
    @NamedQuery(name = "Artist.findBySex", query = "SELECT a FROM Artist a WHERE a.sex = :sex"),
    @NamedQuery(name = "Artist.findByBirthday", query = "SELECT a FROM Artist a WHERE a.birthday = :birthday"),
    @NamedQuery(name = "Artist.findByBirthplace", query = "SELECT a FROM Artist a WHERE a.birthplace = :birthplace")})
public class Artist implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ARTIST_ID")
    private Long artistId;
    @Basic(optional = false)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "ARTISTICNAME")
    private String artisticname;
    @Column(name = "SEX")
    private String sex;
    @Column(name = "BIRTHDAY")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Column(name = "BIRTHPLACE")
    private String birthplace;
    //@JoinTable(name = "ARTIST_MUSICGROUP", joinColumns = {
    //    @JoinColumn(name = "ARTIST_ID", referencedColumnName = "ARTIST_ID")}, inverseJoinColumns = {
    //    @JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP_ID")})
    //@ManyToMany
    @ManyToMany(mappedBy = "artistList")
    private List<Musicgroup> musicgroupList;
    @JoinTable(name = "ARTIST_ALBUM", joinColumns = {
        @JoinColumn(name = "ARTIST_ID", referencedColumnName = "ARTIST_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ALBUM_ID", referencedColumnName = "ALBUM_ID")})
    @ManyToMany
    private List<Album> albumList;
    @JoinColumn(name = "MUSICGENREGENRE_ID", referencedColumnName = "GENRE_ID")
    @ManyToOne(optional = false)
    private Musicgenre musicgenregenreId;

    public Artist() {
    }

    public Artist(Long artistId) {
        this.artistId = artistId;
    }

    public Artist(Long artistId, String firstname, String lastname) {
        this.artistId = artistId;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        Long oldArtistId = this.artistId;
        this.artistId = artistId;
        changeSupport.firePropertyChange("artistId", oldArtistId, artistId);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        String oldFirstname = this.firstname;
        this.firstname = firstname;
        changeSupport.firePropertyChange("firstname", oldFirstname, firstname);
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        String oldLastname = this.lastname;
        this.lastname = lastname;
        changeSupport.firePropertyChange("lastname", oldLastname, lastname);
    }

    public String getArtisticname() {
        return artisticname;
    }

    public void setArtisticname(String artisticname) {
        String oldArtisticname = this.artisticname;
        this.artisticname = artisticname;
        changeSupport.firePropertyChange("artisticname", oldArtisticname, artisticname);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        String oldSex = this.sex;
        this.sex = sex;
        changeSupport.firePropertyChange("sex", oldSex, sex);
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        Date oldBirthday = this.birthday;
        this.birthday = birthday;
        changeSupport.firePropertyChange("birthday", oldBirthday, birthday);
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        String oldBirthplace = this.birthplace;
        this.birthplace = birthplace;
        changeSupport.firePropertyChange("birthplace", oldBirthplace, birthplace);
    }

    @XmlTransient
    public List<Musicgroup> getMusicgroupList() {
        return musicgroupList;
    }

    public void setMusicgroupList(List<Musicgroup> musicgroupList) {
        this.musicgroupList = musicgroupList;
    }

    @XmlTransient
    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }

    public Musicgenre getMusicgenregenreId() {
        return musicgenregenreId;
    }

    public void setMusicgenregenreId(Musicgenre musicgenregenreId) {
        Musicgenre oldMusicgenregenreId = this.musicgenregenreId;
        this.musicgenregenreId = musicgenregenreId;
        changeSupport.firePropertyChange("musicgenregenreId", oldMusicgenregenreId, musicgenregenreId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (artistId != null ? artistId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artist)) {
            return false;
        }
        Artist other = (Artist) object;
        if ((this.artistId == null && other.artistId != null) || (this.artistId != null && !this.artistId.equals(other.artistId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Artist[ artistId=" + artistId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
