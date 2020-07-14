package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_role", schema = "dbo", catalog = "FPTCOURSE")
@IdClass(UserRolePK.class)
public class UserRole {
    private String userId;
    private int roleId;
    private Students studentsByUserId;
    private Roles rolesByRoleId;

    @Id
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "role_id")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return roleId == userRole.roleId &&
                Objects.equals(userId, userRole.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, roleId);
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "code", nullable = false, insertable = false, updatable = false)
    public Students getStudentsByUserId() {
        return studentsByUserId;
    }

    public void setStudentsByUserId(Students studentsByUserId) {
        this.studentsByUserId = studentsByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Roles getRolesByRoleId() {
        return rolesByRoleId;
    }

    public void setRolesByRoleId(Roles rolesByRoleId) {
        this.rolesByRoleId = rolesByRoleId;
    }
}
