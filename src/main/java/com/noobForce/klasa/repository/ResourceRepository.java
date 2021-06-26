package com.noobForce.klasa.repository;

import java.time.LocalDate;
import java.util.List;

import com.noobForce.klasa.model.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

import com.noobForce.klasa.model.Resource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ResourceRepository extends JpaRepository<Resource, Long>
{

	List<Resource> findByDate(LocalDate date);

	//for search feature
	@Query(value = "select * from Resource r where r.resource like %:keyword%", nativeQuery = true)
	List<Resource> findByKeyword(@Param("keyword") String keyword);
	
}
