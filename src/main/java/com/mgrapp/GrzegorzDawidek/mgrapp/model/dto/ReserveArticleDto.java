package com.mgrapp.GrzegorzDawidek.mgrapp.model.dto;


import java.sql.Date;
import java.time.LocalTime;


public class ReserveArticleDto {
    private Date reservedate;
    private String articleid;
    private LocalTime startreserve;
    private LocalTime endreserve;


    public LocalTime getStartreserve() {
        return startreserve;
    }

    public void setStartreserve(LocalTime startreserve) {
        this.startreserve = startreserve;
    }

    public LocalTime getEndreserve() {
        return endreserve;
    }

    public void setEndreserve(LocalTime endreserve) {
        this.endreserve = endreserve;
    }

    public String getArticleid() {
        return articleid;
    }

    public void setArticleid(String articleid) {
        this.articleid = articleid;
    }

    public Date getReservedate() {
        return reservedate;
    }

    public void setReservedate(Date reservedate) {
        this.reservedate = reservedate;
    }
}
