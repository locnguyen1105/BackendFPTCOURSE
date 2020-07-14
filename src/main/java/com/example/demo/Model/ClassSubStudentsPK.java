package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ClassSubStudentsPK implements Serializable {
    private int classsubCode;
    private String studentCode;

    @Column(name = "classsub_code")
    @Id
    public int getClasssubCode() {
        return classsubCode;
    }

    public void setClasssubCode(int classsubCode) {
        this.classsubCode = classsubCode;
    }

    @Column(name = "student_code")
    @Id
    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassSubStudentsPK that = (ClassSubStudentsPK) o;
        return classsubCode == that.classsubCode &&
                Objects.equals(studentCode, that.studentCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classsubCode, studentCode);
    }
}
