/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;

/**
 *
 * @author Risina
 */
public class StoreDVDCopyUtil implements Serializable{
    private long id;
    private StoreDVDUtil dvdId;
    private int shelf;
    private int isle;

    public StoreDVDCopyUtil(long id, StoreDVDUtil dvdId, int shelf, int isle) {
        this.id = id;
        this.dvdId = dvdId;
        this.shelf = shelf;
        this.isle = isle;
    }
    
    public StoreDVDCopyUtil(long id) {
        this.id = id;
    }
    
    public StoreDVDCopyUtil(StoreDVDUtil dvdId, int shelf, int isle) {
        this.dvdId = dvdId;
        this.shelf = shelf;
        this.isle = isle;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public StoreDVDUtil getDvdId() {
        return dvdId;
    }

    public void setDvdId(long StoreDVDUtil) {
        this.dvdId = dvdId;
    }

    public int getShelf() {
        return shelf;
    }

    public void setShelf(int shelf) {
        this.shelf = shelf;
    }

    public int getIsle() {
        return isle;
    }

    public void setIsle(int isle) {
        this.isle = isle;
    }
}
