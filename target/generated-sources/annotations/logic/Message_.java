package logic;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logic.User;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-11-03T08:10:17")
@StaticMetamodel(Message.class)
public class Message_ { 

    public static volatile SingularAttribute<Message, LocalDateTime> shippingDate;
    public static volatile SingularAttribute<Message, User> remitente;
    public static volatile SingularAttribute<Message, Integer> id;
    public static volatile SingularAttribute<Message, String> content;
    public static volatile SingularAttribute<Message, User> destinatario;

}