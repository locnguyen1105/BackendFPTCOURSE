package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "Students")
public class Students {
    private String last_name;
    private String image;
    private String username;
    private String password;
    private String first_name;
    @Id
    private String code;
    private Date birth_date;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Integer roleId;
    private Collection<ClassSubStudents> classSubStudentsByCode;
    private Collection<StudentClasses> studentClassesByCode;
    private Collection<UserRole> userRolesByCode;

    public Students(String code, String first_name, String last_name, String image, String username, String password, Date birth_date) {
        this.code = code;
        this.first_name = first_name;
        this.last_name = last_name;
        this.image = image;
        this.username = username;
        this.password = password;
        this.birth_date = birth_date;
    }

    public Students() {
    }

    @Basic
    @Column(name = "image", nullable = false, length = 100, insertable = false, updatable = false)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 50, insertable = false, updatable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 50, insertable = false, updatable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id
    @Column(name = "code", nullable = false, length = 8, insertable = false, updatable = false)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 50, insertable = false, updatable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = false, length = 50, insertable = false, updatable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "birth_date", nullable = false, insertable = false, updatable = false)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "role_id", nullable = true, insertable = false, updatable = false)
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return Objects.equals(image, students.image) &&
                Objects.equals(username, students.username) &&
                Objects.equals(password, students.password) &&
                Objects.equals(code, students.code) &&
                Objects.equals(firstName, students.firstName) &&
                Objects.equals(lastName, students.lastName) &&
                Objects.equals(birthDate, students.birthDate) &&
                Objects.equals(roleId, students.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, firstName, lastName, image, username, password, birthDate, roleId);
    }

    @JsonIgnoreProperties("studentsByStudentCode")
    @OneToMany(mappedBy = "studentsByStudentCode")
    public Collection<ClassSubStudents> getClassSubStudentsByCode() {
        return classSubStudentsByCode;
    }

    public void setClassSubStudentsByCode(Collection<ClassSubStudents> classSubStudentsByCode) {
        this.classSubStudentsByCode = classSubStudentsByCode;
    }

    @JsonIgnoreProperties("studentsByStudentCode")
    @OneToMany(mappedBy = "studentsByStudentCode")
    public Collection<StudentClasses> getStudentClassesByCode() {
        return studentClassesByCode;
    }

    public void setStudentClassesByCode(Collection<StudentClasses> studentClassesByCode) {
        this.studentClassesByCode = studentClassesByCode;
    }

    @OneToMany(mappedBy = "studentsByUserId")
    public Collection<UserRole> getUserRolesByCode() {
        return userRolesByCode;
    }

    public void setUserRolesByCode(Collection<UserRole> userRolesByCode) {
        this.userRolesByCode = userRolesByCode;
    }
}
