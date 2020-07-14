package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class StudentClassesPK implements Serializable {
    private String studentCode;
    private String classCode;

    @Column(name = "student_code")
    @Id
    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    @Column(name = "class_code")
    @Id
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
        StudentClassesPK that = (StudentClassesPK) o;
        return Objects.equals(studentCode, that.studentCode) &&
                Objects.equals(classCode, that.classCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentCode, classCode);
    }
}
