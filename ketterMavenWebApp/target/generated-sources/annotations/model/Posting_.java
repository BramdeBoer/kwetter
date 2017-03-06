package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Comment;

@Generated(value="EclipseLink-2.6.0.v20150330-rNA", date="2017-02-22T11:41:07")
@StaticMetamodel(Posting.class)
public class Posting_ { 

    public static volatile SingularAttribute<Posting, Date> date;
    public static volatile ListAttribute<Posting, Comment> comments;
    public static volatile SingularAttribute<Posting, Long> id;
    public static volatile SingularAttribute<Posting, String> title;
    public static volatile SingularAttribute<Posting, String> content;

}