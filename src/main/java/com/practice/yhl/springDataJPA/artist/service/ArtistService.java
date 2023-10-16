package com.practice.yhl.springDataJPA.artist.service;

import com.practice.yhl.springDataJPA.artist.dto.ArtistDTO;
import com.practice.yhl.springDataJPA.artist.dto.LabelDTO;
import com.practice.yhl.springDataJPA.artist.entity.Artist;
import com.practice.yhl.springDataJPA.artist.entity.Genre;
import com.practice.yhl.springDataJPA.artist.entity.Label;
import com.practice.yhl.springDataJPA.artist.repository.ArtistRepository;
import com.practice.yhl.springDataJPA.artist.repository.LabelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistService {

    private final ArtistRepository artistRepo;
    private final LabelRepository labelRepo;
    private final ModelMapper modelMapper;

    public ArtistService(ArtistRepository artistRepo, LabelRepository labelRepo, ModelMapper modelMapper) {
        this.artistRepo = artistRepo;
        this.labelRepo = labelRepo;
        this.modelMapper = modelMapper;
    }

    public ArtistDTO searchArtistByNo(int artistNo) {
        Artist artist = artistRepo.findById(artistNo).orElseThrow(IllegalArgumentException::new);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDebutDate = dateFormat.format(artist.getDebutDate());

        ArtistDTO artistDTO = modelMapper.map(artist, ArtistDTO.class);
        artistDTO.setDebutDate(formattedDebutDate);

        return artistDTO;
    }

    public Page<ArtistDTO> usingPagingFindAllArtists(Pageable pageable) {

      pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1
                    , pageable.getPageSize()
                    , Sort.by("artistNo").ascending());

       Page<Artist> artists = artistRepo.findAll(pageable);

       return artists.map(artistList -> modelMapper.map(artistList, ArtistDTO.class));
    }

    public List<ArtistDTO> findByGenre(Genre genre) {

        List<Artist> artistList = artistRepo.findByGenreEquals(genre, Sort.by("genre").ascending());

        return artistList.stream()
                .map(artist -> modelMapper.map(artist, ArtistDTO.class))
                .collect(Collectors.toList());
    }

    public long getCountBySomeColumnGrouped(int labelCode) {

        System.out.println("labelCode : " + labelCode);
        long artistList = artistRepo.getCountBySomeColumnGrouped(labelCode);

        System.out.println("afterRepo: "+ artistList);
        return artistList;
    }

    public List<LabelDTO> findAllLabel() {
        List<Label> labelList = labelRepo.findAllLabel();

        return labelList.stream()
                        .map(labels -> modelMapper.map(labels, LabelDTO.class))
                        .collect(Collectors.toList());
    }

    @Transactional
    public void registNewArtist(ArtistDTO registeredArtist) {

        artistRepo.save(modelMapper.map(registeredArtist, Artist.class));
    }

    @Transactional
    public void modifyArtist(ArtistDTO modifiableArtist) {
        Artist modifiedArtist = artistRepo.findById(modifiableArtist.getArtistNo()).orElseThrow(IllegalArgumentException::new);

        modifiedArtist = modifiedArtist.name(modifiableArtist.getName())
                                        .genre(modifiableArtist.getGenre())
                                        .builder();
    }

    @Transactional
    public void deleteArtist(ArtistDTO deletableArtist) {
        artistRepo.deleteById(deletableArtist.getArtistNo());
    }
}
