package com.noobForce.klasa.model;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class Announcement implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;
    private String nameOfProfessor;
//    @Column(length = 10000000, columnDefinition = "TEXT")
//    @Column(length = 100000000)
//    @Lob @Column(length = 100000)
    private String announcement;
    
    private LocalDate date;
    private LocalTime time;
    
    public Announcement(String nameOfProfessor, String announcement, LocalDate date, LocalTime time)
    {
        this.nameOfProfessor = nameOfProfessor;
        this.announcement = announcement;
        this.date = date;
        this.time = time;
    }
    
    public Announcement() {
    }
    
    public long getId()
    {
        return id;
    }
    
    public void setId(long id)
    {
        this.id = id;
    }
    
    public String getNameOfProfessor()
    {
        return nameOfProfessor;
    }
    
    public void setNameOfProfessor(String nameOfProfessor)
    {
        this.nameOfProfessor = nameOfProfessor;
    }
    
    public String getAnnouncement()
    {
        return announcement;
    }
    
    public void setAnnouncement(String announcement)
    {
        this.announcement = announcement;
    }
    
    public LocalDate getDate()
    {
        return date;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Announcement that = (Announcement) o;
        return id == that.id && nameOfProfessor.equals(that.nameOfProfessor) && announcement.equals(that.announcement) && date.equals(that.date) && time.equals(that.time);
    }
    
    @Override
    public String toString()
    {
        return "Announcement{" +
                "id=" + id +
                ", nameOfProfessor='" + nameOfProfessor + '\'' +
                ", announcement='" + announcement + '\'' +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(id, nameOfProfessor, announcement, date, time);
    }
    
    public LocalTime getTime()
    {
        return time;
    }

}
