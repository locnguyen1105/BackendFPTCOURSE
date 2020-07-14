package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity(name = "classsubstudents")
@IdClass(ClassSubStudentsPK.class)
@Table(name = "classsubstudents", catalog = "FPTCOURSE", schema = "DBO")
public class ClassSubStudents {
    private int classsubCode;
    private String studentCode;
    private String state;
    private Collection<ClassSubStudentSlots> classSubStudentSlots;
    private ClassSubs classSubsByClasssubCode;
    private Students studentsByStudentCode;

    @Id
    @Column(name = "classsub_code")
    public int getClasssubCode() {
        return classsubCode;
    }

    public void setClasssubCode(int classsubCode) {
        this.classsubCode = classsubCode;
    }

    @Id
    @Column(name = "student_code")
    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassSubStudents that = (ClassSubStudents) o;
        return classsubCode == that.classsubCode &&
                Objects.equals(studentCode, that.studentCode) &&
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classsubCode, studentCode, state);
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "classSubStudents")
    public Collection<ClassSubStudentSlots> getClassSubStudentSlots() {
        return classSubStudentSlots;
    }

    public void setClassSubStudentSlots(Collection<ClassSubStudentSlots> classSubStudentSlots) {
        this.classSubStudentSlots = classSubStudentSlots;
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "classsub_code", referencedColumnName = "code", nullable = false, insertable = false, updatable = false)
    public ClassSubs getClassSubsByClasssubCode() {
        return classSubsByClasssubCode;
    }

    public void setClassSubsByClasssubCode(ClassSubs classSubsByClasssubCode) {
        this.classSubsByClasssubCode = classSubsByClasssubCode;
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "student_code", referencedColumnName = "code", nullable = false, insertable = false, updatable = false)
    public Students getStudentsByStudentCode() {
        return studentsByStudentCode;
    }

    public void setStudentsByStudentCode(Students studentsByStudentCode) {
        this.studentsByStudentCode = studentsByStudentCode;
    }
}
