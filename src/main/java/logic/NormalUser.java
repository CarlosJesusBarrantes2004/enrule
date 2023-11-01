package logic;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "NormalUser")
@Table(name = "NormalUser")
@DiscriminatorValue("NormalUser")
public class NormalUser extends User {

    @Basic
    @Column(name = "DNI", nullable = false)
    private String dni;
    @Column(name = "Profession", nullable = false)
    private String profession;
    @Column(name = "CV", nullable = true)
    private String cv;

    @ManyToMany
    @JoinTable(
            name = "FollowedUsers",
            joinColumns = @JoinColumn(name = "IdFollower"),
            inverseJoinColumns = @JoinColumn(name = "IdFollowing")
    )
    private List<User> followedUsers = new ArrayList<>();

    public NormalUser() {
    }

    public NormalUser(String dni, String profession, String cv, String name, String email, String password, String photo) {
        super(name, email, password, photo);
        this.dni = dni;
        this.profession = profession;
        this.cv = cv;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public List<User> getFollowedUsers() {
        return followedUsers;
    }

    public void setFollowedUsers(List<User> followedUsers) {
        this.followedUsers = followedUsers;
    }
}
