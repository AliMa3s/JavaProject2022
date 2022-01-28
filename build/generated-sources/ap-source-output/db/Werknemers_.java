package db;

import db.Accounts;
import domain.ELoginTypeWerknemer;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-01-20T14:03:40")
@StaticMetamodel(Werknemers.class)
public class Werknemers_ { 

    public static volatile SingularAttribute<Werknemers, Integer> gsm;
    public static volatile ListAttribute<Werknemers, Accounts> accountsList;
    public static volatile SingularAttribute<Werknemers, ELoginTypeWerknemer> functie;
    public static volatile SingularAttribute<Werknemers, Integer> id;
    public static volatile SingularAttribute<Werknemers, String> naam;
    public static volatile SingularAttribute<Werknemers, String> email;

}