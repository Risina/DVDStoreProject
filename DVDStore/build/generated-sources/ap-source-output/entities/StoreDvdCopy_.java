package entities;

import entities.StoreBooking;
import entities.StoreDvd;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-31T15:32:19")
@StaticMetamodel(StoreDvdCopy.class)
public class StoreDvdCopy_ { 

    public static volatile SingularAttribute<StoreDvdCopy, Long> storeDvdCopyId;
    public static volatile SingularAttribute<StoreDvdCopy, StoreDvd> storeDvdId;
    public static volatile SingularAttribute<StoreDvdCopy, Integer> storeDvdCopyShelf;
    public static volatile ListAttribute<StoreDvdCopy, StoreBooking> storeBookingList;
    public static volatile SingularAttribute<StoreDvdCopy, Integer> storeDvdCopyIsle;

}