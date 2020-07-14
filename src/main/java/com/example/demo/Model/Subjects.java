package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Subjects {
    private String code;
    private String condition1;
    private String condition2;
    private String condition3;
    private String name;
    private int semester;
    private Integer totalSlot;
    private Collection<ClassSubs> classSubsByCode;
    private Collection<MajorSubjects> majorSubjectsByCode;

    @Id
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "condition1")
    public String getCondition1() {
        return condition1;
    }

    public void setCondition1(String condition1) {
        this.condition1 = condition1;
    }

    @Basic
    @Column(name = "condition2")
    public String getCondition2() {
        return condition2;
    }

    public void setCondition2(String condition2) {
        this.condition2 = condition2;
    }

    @Basic
    @Column(name = "condition3")
    public String getCondition3() {
        return condition3;
    }

    public void setCondition3(String condition3) {
        this.condition3 = condition3;
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
    @Column(name = "semester")
    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Basic
    @Column(name = "Total_slot")
    public Integer getTotalSlot() {
        return totalSlot;
    }

    public void setTotalSlot(Integer totalSlot) {
        this.totalSlot = totalSlot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subjects subjects = (Subjects) o;
        return semester == subjects.semester &&
                Objects.equals(code, subjects.code) &&
                Objects.equals(condition1, subjects.condition1) &&
                Objects.equals(condition2, subjects.condition2) &&
                Objects.equals(condition3, subjects.condition3) &&
                Objects.equals(name, subjects.name) &&
                Objects.equals(totalSlot, subjects.totalSlot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, condition1, condition2, condition3, name, semester, totalSlot);
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "subjectsBySubjectCode")
    public Collection<ClassSubs> getClassSubsByCode() {
        return classSubsByCode;
    }

    public void setClassSubsByCode(Collection<ClassSubs> classSubsByCode) {
        this.classSubsByCode = classSubsByCode;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "subjectsBySubjectCode")
    public Collection<MajorSubjects> getMajorSubjectsByCode() {
        return majorSubjectsByCode;
    }

    public void setMajorSubjectsByCode(Collection<MajorSubjects> majorSubjectsByCode) {
        this.majorSubjectsByCode = majorSubjectsByCode;
    }
}
