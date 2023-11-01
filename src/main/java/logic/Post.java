package logic;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity(name = "Post")
@Table(name = "Post")
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPost")
    private int id;

    @Basic
    @Column(name = "Title", nullable = false)
    private String title;
    @Column(name = "Content", nullable = false)
    @Size(max = 1000)
    private String content;
    @Column(name = "PublicationDate", nullable = false)
    private LocalDateTime publicationDate;
    @Column(name = "Image", nullable = true)
    private String image;
    @Column(name = "AttachedDocument", nullable = true)
    private String attachedDocument;

    @ManyToOne
    @JoinColumn(name = "IdUser")
    private User author;

    public Post() {
    }

    public Post(String title, String content, LocalDateTime publicationDate, String image, String attachedDocument, User author) {
        this.title = title;
        this.content = content;
        this.publicationDate = publicationDate;
        this.image = image;
        this.attachedDocument = attachedDocument;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public String getImage() {
        return image;
    }

    public String getAttachedDocument() {
        return attachedDocument;
    }

    public User getAuthor() {
        return author;
    }

}
