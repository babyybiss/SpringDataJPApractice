package com.practice.yhl.springDataJPA.artist.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
@Entity(name="entityArtist")
@Table(name="TBL_ARTISTS")
public class Artist {
    @Id
    @Column(name="ARTIST_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int artistNo;
    @Column(name="NAME")
    private String name;
    @Column(name="DEBUT_DATE")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date debutDate;
    @Column(name="TOTAL_ALBUMS")
    private int totalAlbums;
    @Column(name="GENRE")
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Column(name="LABEL_CODE")
    private int labelCode;
    @Column(name="NATIONALITY")
    private String nationality;

    public int getArtistNo() {
        return artistNo;
    }

    public String getName() {
        return name;
    }

    public Date getDebutDate() {
        return debutDate;
    }

    public int getTotalAlbums() {
        return totalAlbums;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getLabelCode() {
        return labelCode;
    }

    public String getNationality() {
        return nationality;
    }

    public Artist artistNo(int val) {
        artistNo = val;
        return this;
    }

    public Artist name(String val) {
        name = val;
        return this;
    }

    public Artist debutDate(Date val) {
        debutDate = val;
        return this;
    }

    public Artist totalAlbums(int val) {
        totalAlbums = val;
        return this;
    }

    public Artist labelCode(int val) {
        labelCode = val;
        return this;
    }

    public Artist nationality(String val) {
        nationality = val;
        return this;
    }


    public Artist genre(Genre val) {
        genre = val;
        return this;
    }

    public Artist builder() {
        return new Artist(artistNo,name,debutDate,totalAlbums,genre,labelCode,nationality);
    }


    protected Artist(){}


    /*public void setArtistNo(int artistNo) {
        this.artistNo = artistNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDebutDate(Date debutDate) {
        this.debutDate = debutDate;
    }

    public void setTotalAlbums(int totalAlbums) {
        this.totalAlbums = totalAlbums;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setLabelCode(int labelCode) {
        this.labelCode = labelCode;
    }
*/
    public Artist(int artistNo, String name, Date debutDate, int totalAlbums, Genre genre, int labelCode, String nationality) {
        this.artistNo = artistNo;
        this.name = name;
        this.debutDate = debutDate;
        this.totalAlbums = totalAlbums;
        this.genre = genre;
        this.labelCode = labelCode;
        this.nationality = nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "artistNo=" + artistNo +
                ", name='" + name + '\'' +
                ", debutDate=" + debutDate +
                ", totalAlbums=" + totalAlbums +
                ", genre=" + genre +
                ", labelCode=" + labelCode +
                ", nationality='" + nationality + '\'' +
                '}';
    }

    /* 쿼리 메소드 때문에 set 다해야함*/
}
