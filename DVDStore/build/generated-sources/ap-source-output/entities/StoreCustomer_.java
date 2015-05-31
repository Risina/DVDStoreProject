package entities;

import entities.StoreBooking;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-31T15:32:19")
@StaticMetamodel(StoreCustomer.class)
public class StoreCustomer_ { 

    public static volatile SingularAttribute<StoreCustomer, String> storeCustomerEmail;
    public static volatile SingularAttribute<StoreCustomer, Long> storeCustomerId;
    public static volatile SingularAttribute<StoreCustomer, String> storeCustomerPassword;
    public static volatile SingularAttribute<StoreCustomer, String> storeCustomerName;
    public static volatile ListAttribute<StoreCustomer, StoreBooking> storeBookingList;

}