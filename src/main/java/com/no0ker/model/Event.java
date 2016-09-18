package com.no0ker.model;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private Date date;

    public Event() {
    }

    public Event(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
