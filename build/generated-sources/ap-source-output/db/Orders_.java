package db;

import db.Klanten;
import db.Orderlijnen;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-01-20T14:03:40")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, Klanten> klant;
    public static volatile SingularAttribute<Orders, Date> datum;
    public static volatile ListAttribute<Orders, Orderlijnen> orderlijnenList;
    public static volatile SingularAttribute<Orders, Integer> id;
    public static volatile SingularAttribute<Orders, Integer> ordernummer;

}