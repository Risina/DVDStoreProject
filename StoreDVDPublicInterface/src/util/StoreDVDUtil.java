/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Risina
 */
public class StoreDVDUtil implements Serializable{
    private Long id;
    private String title;
    private String releasedYear;
    private String actors;
    private String rating;
    private String format;
    private Long addedEmployeeId;
    private Date addedDate;
    private Date modifiedDate;

    public StoreDVDUtil(String title, String releasedYear, String actors, String rating, String format) {
        this.title = title;
        this.releasedYear = releasedYear;
        this.actors = actors;
        this.rating = rating;
        this.format = format;
    }
    
    public StoreDVDUtil(Long id, String title, String releasedYear, String actors, String rating, String format) {
        this.id = id;
        this.title = title;
        this.releasedYear = releasedYear;
        this.actors = actors;
        this.rating = rating;
        this.format = format;
    }
    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleasedYear() {
        return releasedYear;
    }

    public void setReleasedYear(String releasedYear) {
        this.releasedYear = releasedYear;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Long getAddedEmployeeId() {
        return addedEmployeeId;
    }

    public void setAddedEmployeeId(Long addedEmployeeId) {
        this.addedEmployeeId = addedEmployeeId;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
    
    
}
