package db;

import db.Klanten;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-01-21T11:28:09")
@StaticMetamodel(Adressen.class)
public class Adressen_ { 

    public static volatile SingularAttribute<Adressen, String> stad;
    public static volatile SingularAttribute<Adressen, String> straat;
    public static volatile SingularAttribute<Adressen, Integer> id;
    public static volatile SingularAttribute<Adressen, String> type;
    public static volatile SingularAttribute<Adressen, Klanten> klanten;

}