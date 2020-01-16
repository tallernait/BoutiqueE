package tn.co;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "role", schema = "loginUserBD", catalog = "")
public class RoleEntity {
    private int idrole;
    private String role;

    @Id
    @Column(name = "idrole")
    public int getIdrole() {
        return idrole;
    }

    public void setIdrole(int idrole) {
        this.idrole = idrole;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return idrole == that.idrole &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idrole, role);
    }
}
