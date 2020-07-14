package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity(name = "classsubs")
public class ClassSubs {
    private int code;
    private String subjectCode;
    private String lecturerCode;
    private String classCode;
    private Date startDate;
    private Date endDate;
    private Collection<ClassSubStudents> classSubStudentsByCode;
    private Subjects subjectsBySubjectCode;
    private Lecturers lecturersByLecturerCode;
    private Classes classesByClassCode;
    private Collection<Slots> slotsByCode;
    private Collection<Slots> slotsByCode_0;

    @Id
    @Column(name = "code")
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Basic
    @Column(name = "subject_code")
    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    @Basic
    @Column(name = "lecturer_code")
    public String getLecturerCode() {
        return lecturerCode;
    }

    public void setLecturerCode(String lecturerCode) {
        this.lecturerCode = lecturerCode;
    }

    @Basic
    @Column(name = "class_code")
    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    @Basic
    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassSubs classSubs = (ClassSubs) o;
        return code == classSubs.code &&
                Objects.equals(subjectCode, classSubs.subjectCode) &&
                Objects.equals(lecturerCode, classSubs.lecturerCode) &&
                Objects.equals(classCode, classSubs.classCode) &&
                Objects.equals(startDate, classSubs.startDate) &&
                Objects.equals(endDate, classSubs.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, subjectCode, lecturerCode, classCode, startDate, endDate);
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "classSubsByClasssubCode")
    public Collection<ClassSubStudents> getClassSubStudentsByCode() {
        return classSubStudentsByCode;
    }

    public void setClassSubStudentsByCode(Collection<ClassSubStudents> classSubStudentsByCode) {
        this.classSubStudentsByCode = classSubStudentsByCode;
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "subject_code", referencedColumnName = "code", nullable = false, insertable = false, updatable = false)
    public Subjects getSubjectsBySubjectCode() {
        return subjectsBySubjectCode;
    }

    public void setSubjectsBySubjectCode(Subjects subjectsBySubjectCode) {
        this.subjectsBySubjectCode = subjectsBySubjectCode;
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "lecturer_code", referencedColumnName = "code", nullable = false, insertable = false, updatable = false)
    public Lecturers getLecturersByLecturerCode() {
        return lecturersByLecturerCode;
    }

    public void setLecturersByLecturerCode(Lecturers lecturersByLecturerCode) {
        this.lecturersByLecturerCode = lecturersByLecturerCode;
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "class_code", referencedColumnName = "code", nullable = false, insertable = false, updatable = false)
    public Classes getClassesByClassCode() {
        return classesByClassCode;
    }

    public void setClassesByClassCode(Classes classesByClassCode) {
        this.classesByClassCode = classesByClassCode;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "classSubsByClasssubCode")
    public Collection<Slots> getSlotsByCode() {
        return slotsByCode;
    }

    public void setSlotsByCode(Collection<Slots> slotsByCode) {
        this.slotsByCode = slotsByCode;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "classSubsByClasssubCode_0")
    public Collection<Slots> getSlotsByCode_0() {
        return slotsByCode_0;
    }

    public void setSlotsByCode_0(Collection<Slots> slotsByCode_0) {
        this.slotsByCode_0 = slotsByCode_0;
    }
}
