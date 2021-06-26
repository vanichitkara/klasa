package com.noobForce.klasa.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Resource implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;
    private int SNo;
    //nameOfProfessor=link
    private String nameOfProfessor;
    private String resource;
    private LocalDate date;
    private LocalTime time;
    public Resource() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNameOfProfessor() {
		return nameOfProfessor;
	}

	public void setNameOfProfessor(String nameOfProfessor) {
		this.nameOfProfessor = nameOfProfessor;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	public int getSNo() {
		return SNo;
	}

	public void setSNo(int sNo) {
		SNo = sNo;
	}

	@Override
	public String toString() {
		return "Resource [id=" + id + ", SNo=" + SNo + ", nameOfProfessor=" + nameOfProfessor + ", resource=" + resource
				+ ", date=" + date + ", time=" + time + "]";
	}

	public Resource(int sNo, String nameOfProfessor, String resource, LocalDate date, LocalTime time) {
		super();
		SNo = sNo;
		this.nameOfProfessor = nameOfProfessor;
		this.resource = resource;
		this.date = date;
		this.time = time;
		
	}


	
    
    

}
