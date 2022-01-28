package db;

import db.Artikelen;
import db.Orders;
import domain.EStatus;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-01-20T14:03:40")
@StaticMetamodel(Orderlijnen.class)
public class Orderlijnen_ { 

    public static volatile SingularAttribute<Orderlijnen, Integer> aantal;
    public static volatile SingularAttribute<Orderlijnen, Artikelen> artikel;
    public static volatile SingularAttribute<Orderlijnen, Orders> orders;
    public static volatile SingularAttribute<Orderlijnen, Integer> id;
    public static volatile SingularAttribute<Orderlijnen, Double> prijs;
    public static volatile SingularAttribute<Orderlijnen, EStatus> status;

}