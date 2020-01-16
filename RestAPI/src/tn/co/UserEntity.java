package tn.co;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "loginUserBD", catalog = "")
public class UserEntity {
    private int iduser;
    private String user;
    private String name;
    private String password;
    private Integer role;

    @Id
    @Column(name = "iduser")
    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    @Basic
    @Column(name = "user")
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "role")
    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return iduser == that.iduser &&
                Objects.equals(user, that.user) &&
                Objects.equals(name, that.name) &&
                Objects.equals(password, that.password) &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iduser, user, name, password, role);
    }


    @Override
    public String toString() {
        String userString = String
                .format(" { \"id\" : \"%s\" , \"user\" : \"%s\" , \"pass\" : \"%s\" }" , iduser , user , password);

        return  userString;

    }
}
