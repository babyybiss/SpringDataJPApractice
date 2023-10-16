package com.practice.yhl.springDataJPA.artist.controller;

import com.practice.yhl.springDataJPA.artist.common.Pagenation;
import com.practice.yhl.springDataJPA.artist.common.PagingButton;
import com.practice.yhl.springDataJPA.artist.dto.ArtistDTO;
import com.practice.yhl.springDataJPA.artist.dto.LabelDTO;
import com.practice.yhl.springDataJPA.artist.entity.Artist;
import com.practice.yhl.springDataJPA.artist.entity.Genre;
import com.practice.yhl.springDataJPA.artist.service.ArtistService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/artist")
public class ArtistController {

    private final ArtistService service;
    public ArtistController(ArtistService service){
        this.service = service;
    }


    @GetMapping("/inputCode")
    public void findByArtistCode(){}

    @GetMapping("/{artistNo}")
    public String findByArtistNo(@PathVariable("artistNo") int artistNo, Model model) {

        System.out.println("artistNo : " + artistNo);

        ArtistDTO artistDTO = service.searchArtistByNo(artistNo);

        model.addAttribute("artistDTO", artistDTO);

        return "artist/details";
    }

    @GetMapping("/list")
    public String selectListsOfArtists(Model model, @PageableDefault Pageable pageable) {

        Page<ArtistDTO> artistDTO = service.usingPagingFindAllArtists(pageable);

        PagingButton pager= Pagenation.getPagingButtonInfo(artistDTO);

        model.addAttribute("artistDTO", artistDTO);
        model.addAttribute("pager", pager);

        return "artist/list";

    }

    @GetMapping("/queryMethod")
    public void queryMethod(){}


    @PostMapping("/searchGenre")
    public String searchByGenreQueryMethod(@RequestParam("selectedGenre") String stringGenre, Model model) {
        //enum 타입의 장르를 String으로 받아와서 다시 enum 타입으로 convert
        Genre genre = Genre.valueOf(stringGenre);

        List<ArtistDTO> artistList = service.findByGenre(genre);

        System.out.println("가져온 리스트 : " + artistList);
        model.addAttribute("artistList", artistList);
        return "artist/querySearchResult";
    }

    @GetMapping("/jqlGroupFunction")
    public void searchBylabeljpqlGroupFunction(){}

    @PostMapping("/searchByLabel")
    public String searchCountByLabel(@RequestParam("labelCode") String labelCode1, Model model) {

        int labelCode = Integer.parseInt(labelCode1);
        long sumByLabel = service.getCountBySomeColumnGrouped(labelCode);
        System.out.println("들어온 리스트 : " + sumByLabel);

        model.addAttribute("labelCode", labelCode);
        model.addAttribute("sumByLabel", sumByLabel);
        return "artist/labelList";
    }

    @GetMapping(value="/label", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<LabelDTO> findByLabelList(){
        return service.findAllLabel();
    }

    @GetMapping("/registArtist")
    public void registerArtistPage() {}


    @PostMapping("/registArtist")
    public String registArtist(ArtistDTO registeredArtist){
        service.registNewArtist(registeredArtist);

        return "redirect:/artist/list";
    }

    @GetMapping("/modifyArtist")
    public void modifyArtistPage() {}

    @PostMapping("/modifyArtist")
    public String modifyArtist(ArtistDTO modifiableArtist) {
        service.modifyArtist(modifiableArtist);

        /*조건 조회 페이지에 URI 설정하여 redirect*/
        return "redirect:/artist/" + modifiableArtist.getArtistNo();
    }

    @GetMapping("/delete")
    public void deleteArtistMapping() {}

    @PostMapping("/delete")
    public String deleteArtist(ArtistDTO deletableArtist){
        service.deleteArtist(deletableArtist);

        return "redirect:/artist/list";
    }
}