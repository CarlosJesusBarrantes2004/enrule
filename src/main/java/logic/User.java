package logic;

import org.mindrot.jbcrypt.BCrypt;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity(name = "User")
@Table(name = "Users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUser")
    private int id;   
    
    @Basic
    @Column(name = "FullName", nullable = false)
    private String name;
    @Column(name = "Email", nullable = false)
    private String email;
    @Column(name = "Password")
    private String hashedPassword;
    private String salt;
    @Column(name = "ProfilePhoto", nullable = true)
    private String photo;

    public User() {
    }

    public User(String name, String email, String password, String photo) {
        this.name = name;
        this.email = email;
        this.salt = generateSalt();
        this.hashedPassword = hashPassword(password, salt);
        this.photo = photo;
    }

    private String generateSalt() {
        return BCrypt.gensalt(12);
    }

    private String hashPassword(String password, String salt) {
        return BCrypt.hashpw(password, salt); 
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}