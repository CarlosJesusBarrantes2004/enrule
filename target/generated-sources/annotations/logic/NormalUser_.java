package logic;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logic.User;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-11-01T16:12:13")
@StaticMetamodel(NormalUser.class)
public class NormalUser_ extends User_ {

    public static volatile SingularAttribute<NormalUser, String> profession;
    public static volatile ListAttribute<NormalUser, User> followedUsers;
    public static volatile SingularAttribute<NormalUser, String> cv;
    public static volatile SingularAttribute<NormalUser, String> dni;

}