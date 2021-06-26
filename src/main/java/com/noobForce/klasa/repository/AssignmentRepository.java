package com.noobForce.klasa.repository;

import java.time.LocalDate;
import java.util.List;

import com.noobForce.klasa.model.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;

import com.noobForce.klasa.model.Assignment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AssignmentRepository extends JpaRepository<Assignment, Long>
{

//	List<Assignment> findByDateAndDueDate(LocalDate of, LocalDate of2);
    List<Assignment> findByDueDate(LocalDate of);

    //for search feature
    @Query(value = "select * from Assignment a where a.title like %:keyword%", nativeQuery = true)
    List<Assignment> findByKeyword(@Param("keyword") String keyword);
}
