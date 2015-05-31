/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import javax.ejb.Remote;
import util.StoreDVDCopyUtil;

/**
 *
 * @author Risina
 */
@Remote
public interface StoreDVDCopyFacadeLocal {
    public void addCopy(StoreDVDCopyUtil dvdCopy);
    public List<StoreDVDCopyUtil> getCopiedByDVDId(Long dvdId);
}
