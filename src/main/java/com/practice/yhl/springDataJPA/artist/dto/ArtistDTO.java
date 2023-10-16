package com.practice.yhl.springDataJPA.artist.dto;

import com.practice.yhl.springDataJPA.artist.entity.Genre;

import java.util.Date;

public class ArtistDTO {

    private int artistNo;
    private String name;
    private String debutDate;
    private int totalAlbums;
    private Genre genre;
    private int labelCode;
    private String nationality;

    public ArtistDTO() {
    }

    public ArtistDTO(int artistNo, String name, String debutDate, int totalAlbums, Genre genre, int labelCode, String nationality) {
        this.artistNo = artistNo;
        this.name = name;
        this.debutDate = debutDate;
        this.totalAlbums = totalAlbums;
        this.genre = genre;
        this.labelCode = labelCode;
        this.nationality = nationality;
    }

    public int getArtistNo() {
        return artistNo;
    }

    public void setArtistNo(int artistNo) {
        this.artistNo = artistNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDebutDate() {
        return debutDate;
    }

    public void setDebutDate(String debutDate) {
        this.debutDate = debutDate;
    }

    public int getTotalAlbums() {
        return totalAlbums;
    }

    public void setTotalAlbums(int totalAlbums) {
        this.totalAlbums = totalAlbums;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getLabelCode() {
        return labelCode;
    }

    public void setLabelCode(int labelCode) {
        this.labelCode = labelCode;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "ArtistDTO{" +
                "artistNo=" + artistNo +
                ", name='" + name + '\'' +
                ", debutDate=" + debutDate +
                ", totalAlbums=" + totalAlbums +
                ", genre=" + genre +
                ", labelCode=" + labelCode +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
