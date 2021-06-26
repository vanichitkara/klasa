package com.noobForce.klasa.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Discussion implements Serializable {

    /*
    Student field is removed
    Have to call the student name from student database who is currently loggedIn == true
     */
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;

    private @JsonFormat(pattern="dd-MM-YY") LocalDate date;

    private @JsonFormat(pattern="HH:mm") LocalTime time;
    private String input;

    public Discussion() {
        this.date = LocalDate.now();
        this.time = LocalTime.now();
    }

    public Discussion(String input) {
        this.date = LocalDate.now();
        this.time = LocalTime.now();
        this.input = input;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = LocalDate.now();
    }

    public LocalDate getDate() {return date;}

    public void setTime(LocalTime time) {
        this.time = LocalTime.now();
    }

    public LocalTime getTime() {return time;}

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "Discussion{" +
                "id=" + id +
                ", date=" + date +
                ", time=" + time +
                ", input='" + input + '\'' +
                '}';
    }
}
