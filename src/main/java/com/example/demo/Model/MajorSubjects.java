package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "majorsubjects")
@IdClass(MajorSubjectsPK.class)
public class MajorSubjects {
    private String majorCode;
    private String subjectCode;
    private Majors majorsByMajorCode;
    private Subjects subjectsBySubjectCode;

    @Id
    @Column(name = "major_code")
    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    @Id
    @Column(name = "subject_code")
    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MajorSubjects that = (MajorSubjects) o;
        return Objects.equals(majorCode, that.majorCode) &&
                Objects.equals(subjectCode, that.subjectCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(majorCode, subjectCode);
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "major_code", referencedColumnName = "code", nullable = false, insertable = false, updatable = false)
    public Majors getMajorsByMajorCode() {
        return majorsByMajorCode;
    }

    public void setMajorsByMajorCode(Majors majorsByMajorCode) {
        this.majorsByMajorCode = majorsByMajorCode;
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
}
