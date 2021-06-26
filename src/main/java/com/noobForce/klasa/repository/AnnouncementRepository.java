package com.noobForce.klasa.repository;

import com.noobForce.klasa.model.Announcement;
import com.noobForce.klasa.model.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


public interface AnnouncementRepository extends JpaRepository<Announcement, Long>
{
    List<Announcement> findByDate(LocalDate date);

    //for search feature
    @Query(value = "select * from Announcement a where a.announcement like %:keyword% or a.name_of_professor like %:keyword% ", nativeQuery = true)
    List<Announcement> findByKeyword(@Param("keyword") String keyword);
}
