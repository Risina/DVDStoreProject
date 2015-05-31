package entities;

import entities.StoreCustomer;
import entities.StoreDvdCopy;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-31T15:32:19")
@StaticMetamodel(StoreBooking.class)
public class StoreBooking_ { 

    public static volatile SingularAttribute<StoreBooking, Long> storeBookingId;
    public static volatile SingularAttribute<StoreBooking, StoreCustomer> storeBookingCustomerId;
    public static volatile SingularAttribute<StoreBooking, StoreDvdCopy> storeBookingCopyId;

}