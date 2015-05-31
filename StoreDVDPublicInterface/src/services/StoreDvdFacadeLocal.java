/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;
import util.StoreDVDCopyUtil;
import util.StoreDVDUtil;

/**
 *
 * @author Risina
 */
@Remote
public interface StoreDvdFacadeLocal {
    public void addDVD(StoreDVDUtil dvd);
    public StoreDVDUtil getDVDById(long id);
    public String getSomething();
    public List<StoreDVDUtil> getDVDs();
    public List<StoreDVDUtil> getDVDsByTitle(String title);
    public List<StoreDVDUtil> getDVDsByRating(String rating);
    public List<StoreDVDUtil> getDVDsByFormat(String format);
    public List<StoreDVDUtil> getDVDsByYear(String year);
    public List<StoreDVDCopyUtil> getCopiedByDVDId(Long dvdId);
}
