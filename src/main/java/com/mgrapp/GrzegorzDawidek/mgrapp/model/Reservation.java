package com.mgrapp.GrzegorzDawidek.mgrapp.model;

import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalTime;

@Entity
@Indexed
@Table(name = "Reservation")
public class Reservation {

    private long id;
    private Date date;
    private LocalTime starthour;
    private LocalTime endhour;
    private long itemid;
    private long userid;

    public Reservation(Date date, long itemid, long userid, LocalTime starthour, LocalTime endhour) {
        this.date = date;
        this.itemid = itemid;
        this.userid = userid;
        this.starthour = starthour;
        this.endhour = endhour;
    }

    public Reservation() {
    }

    public long getItemid() {
        return itemid;
    }

    public void setItemid(long itemid) {
        this.itemid = itemid;
    }


    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column
    public LocalTime getStarthour() {
        return starthour;
    }

    public void setStarthour(LocalTime starthour) {
        this.starthour = starthour;
    }

    @Basic
    @Column
    public LocalTime getEndhour() {
        return endhour;
    }

    public void setEndhour(LocalTime endhour) {
        this.endhour = endhour;
    }
}
