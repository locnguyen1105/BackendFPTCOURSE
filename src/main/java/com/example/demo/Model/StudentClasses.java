package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "studentclasses")
@IdClass(StudentClassesPK.class)
public class StudentClasses {
    private String studentCode;
    private String classCode;
    private Students studentsByStudentCode;
    private Classes classesByClassCode;

    @Id
    @Column(name = "student_code")
    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    @Id
    @Column(name = "class_code")

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentClasses that = (StudentClasses) o;
        return Objects.equals(studentCode, that.studentCode) &&
                Objects.equals(classCode, that.classCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentCode, classCode);
    }

    @ManyToOne
    @JoinColumn(name = "student_code", referencedColumnName = "code", nullable = false, insertable = false, updatable = false)
    public Students getStudentsByStudentCode() {
        return studentsByStudentCode;
    }

    public void setStudentsByStudentCode(Students studentsByStudentCode) {
        this.studentsByStudentCode = studentsByStudentCode;
    }

    @JsonIgnoreProperties("studentClassesByCode")
    @ManyToOne
    @JoinColumn(name = "class_code", referencedColumnName = "code", nullable = false, insertable = false, updatable = false)
    public Classes getClassesByClassCode() {
        return classesByClassCode;
    }

    public void setClassesByClassCode(Classes classesByClassCode) {
        this.classesByClassCode = classesByClassCode;
    }
}
