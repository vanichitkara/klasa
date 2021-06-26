package com.noobForce.klasa.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Assignment implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;
	private int SNo;
	//Assigned date
	private LocalDate date;
	//Due Date
	private LocalDate dueDate;
	private boolean status;
	private String title;
	
	public Assignment()
	{}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getSNo() {
		return SNo;
	}
	public void setSNo(int sNo) {
		SNo = sNo;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Assignment [id=" + id + ", SNo=" + SNo + ", date=" + date + ", dueDate=" + dueDate + ", status="
				+ status + ", title=" + title + "]";
	}
	public Assignment(int sNo, LocalDate date, LocalDate dueDate, boolean status, String title) {
		super();
		SNo = sNo;
		this.date = date;
		this.dueDate = dueDate;
		this.status = status;
		this.title = title;
	}
	
	

	
}
