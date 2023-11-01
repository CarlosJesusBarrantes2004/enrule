package logic;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logic.User;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-11-01T16:12:13")
@StaticMetamodel(Post.class)
public class Post_ { 

    public static volatile SingularAttribute<Post, String> image;
    public static volatile SingularAttribute<Post, String> attachedDocument;
    public static volatile SingularAttribute<Post, User> author;
    public static volatile SingularAttribute<Post, Integer> id;
    public static volatile SingularAttribute<Post, String> title;
    public static volatile SingularAttribute<Post, LocalDateTime> publicationDate;
    public static volatile SingularAttribute<Post, String> content;

}