package logic;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-11-01T16:12:13")
@StaticMetamodel(CompanyUser.class)
public class CompanyUser_ extends User_ {

    public static volatile SingularAttribute<CompanyUser, String> ruc;
    public static volatile SingularAttribute<CompanyUser, String> province;
    public static volatile SingularAttribute<CompanyUser, String> district;
    public static volatile SingularAttribute<CompanyUser, String> description;
    public static volatile SingularAttribute<CompanyUser, String> department;
    public static volatile SingularAttribute<CompanyUser, String> direction;

}