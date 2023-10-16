package com.practice.yhl.springDataJPA.artist.repository;

import com.practice.yhl.springDataJPA.artist.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LabelRepository extends JpaRepository<Label, Integer> {
    @Query(value="SELECT LABEL_CODE, LABEL_NAME, LOCATION, FOUNDER FROM TBL_LABEL ORDER BY LABEL_CODE ASC", nativeQuery = true)
    List<Label> findAllLabel();
}
