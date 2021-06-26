package com.noobForce.klasa.repository;

import com.noobForce.klasa.model.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Discussion Repository:
 * find by date
 */
@Repository
public interface DiscussionRepository extends JpaRepository<Discussion,Long> {

    @Query(value = "select * from Discussion d where d.input like %:keyword%", nativeQuery = true)
    List<Discussion> findByKeyword(@Param("keyword") String keyword);

    List<Discussion> findByDate(LocalDate localDate);

    /*
    @Query("select d from Discussion d where d.date = :date")
    List findAllWithDate(@Param("date") Date date);
    */

}
