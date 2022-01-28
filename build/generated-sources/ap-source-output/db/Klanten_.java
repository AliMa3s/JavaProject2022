package db;

import db.Adressen;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-01-21T11:28:09")
@StaticMetamodel(Klanten.class)
public class Klanten_ { 

    public static volatile SingularAttribute<Klanten, String> gsm;
    public static volatile ListAttribute<Klanten, Adressen> adressen;
    public static volatile SingularAttribute<Klanten, Integer> id;
    public static volatile SingularAttribute<Klanten, String> naam;
    public static volatile SingularAttribute<Klanten, String> email;

}