package entities;

import entities.StoreDvdCopy;
import entities.StoreEmployee;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-31T15:32:19")
@StaticMetamodel(StoreDvd.class)
public class StoreDvd_ { 

    public static volatile SingularAttribute<StoreDvd, String> storeDvdFormat;
    public static volatile SingularAttribute<StoreDvd, Long> storeDvdId;
    public static volatile ListAttribute<StoreDvd, StoreDvdCopy> storeDvdCopyList;
    public static volatile SingularAttribute<StoreDvd, String> storeDvdActors;
    public static volatile SingularAttribute<StoreDvd, String> storeDvdRating;
    public static volatile SingularAttribute<StoreDvd, Date> storeDvdAddedDate;
    public static volatile SingularAttribute<StoreDvd, StoreEmployee> storeDvdAddedEmployeeId;
    public static volatile SingularAttribute<StoreDvd, String> storeDvdTitle;
    public static volatile SingularAttribute<StoreDvd, Date> storeDvdModifiedDate;
    public static volatile SingularAttribute<StoreDvd, String> storedvdreleasedYear;

}