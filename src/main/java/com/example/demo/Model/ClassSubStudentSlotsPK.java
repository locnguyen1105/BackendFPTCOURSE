package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ClassSubStudentSlotsPK implements Serializable {
    private String studentCode;
    private int slotno;
    private int classsubCode;

    @Column(name = "student_code")
    @Id
    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    @Column(name = "slotno")
    @Id
    public int getSlotno() {
        return slotno;
    }

    public void setSlotno(int slotno) {
        this.slotno = slotno;
    }

    @Column(name = "classsub_code")
    @Id
    public int getClasssubCode() {
        return classsubCode;
    }

    public void setClasssubCode(int classsubCode) {
        this.classsubCode = classsubCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassSubStudentSlotsPK that = (ClassSubStudentSlotsPK) o;
        return slotno == that.slotno &&
                classsubCode == that.classsubCode &&
                Objects.equals(studentCode, that.studentCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentCode, slotno, classsubCode);
    }
}
