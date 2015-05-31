package entities;

import entities.StoreDvd;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-31T15:32:19")
@StaticMetamodel(StoreEmployee.class)
public class StoreEmployee_ { 

    public static volatile SingularAttribute<StoreEmployee, Long> storeEmployeeId;
    public static volatile SingularAttribute<StoreEmployee, String> storeEmployeeName;
    public static volatile ListAttribute<StoreEmployee, StoreDvd> storeDvdList;
    public static volatile SingularAttribute<StoreEmployee, String> storeEmployeeEmail;
    public static volatile SingularAttribute<StoreEmployee, String> storeEmployeePassword;

}