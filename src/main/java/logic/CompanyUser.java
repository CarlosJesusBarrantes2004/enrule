package logic;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "CompanyUser")
@Table(name = "CompanyUser")
@DiscriminatorValue("CompanyUser")
public class CompanyUser extends User {

    @Basic
    @Column(name = "RUC", nullable = false)
    private String ruc;
    @Column(name = "Description", nullable = false)
    private String description;
    @Column(name = "Department", nullable = false)
    private String department;
    @Column(name = "Province", nullable = false)
    private String province;
    @Column(name = "District", nullable = false)
    private String district;
    @Column(name = "Direction", nullable = false)
    private String direction;

    public CompanyUser() {
    }

    public CompanyUser(String ruc, String description, String department, String province, String district, String direction, String name, String email, String password, String photo) {
        super(name, email, password, photo);
        this.ruc = ruc;
        this.description = description;
        this.department = department;
        this.province = province;
        this.district = district;
        this.direction = direction;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
