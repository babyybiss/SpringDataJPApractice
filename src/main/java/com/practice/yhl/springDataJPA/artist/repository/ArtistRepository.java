package com.practice.yhl.springDataJPA.artist.repository;

import com.practice.yhl.springDataJPA.artist.entity.Artist;
import com.practice.yhl.springDataJPA.artist.entity.Genre;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
    List<Artist> findByGenreEquals(Genre genre, Sort sort);

    @Query("SELECT COUNT(a) FROM entityArtist a WHERE a.labelCode = :labelCode")
    long getCountBySomeColumnGrouped(@Param("labelCode") int labelCode);

}
