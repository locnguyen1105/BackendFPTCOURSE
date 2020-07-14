package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MajorSubjectsPK implements Serializable {
    private String majorCode;
    private String subjectCode;

    @Column(name = "major_code")
    @Id
    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    @Column(name = "subject_code")
    @Id
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
        MajorSubjectsPK that = (MajorSubjectsPK) o;
        return Objects.equals(majorCode, that.majorCode) &&
                Objects.equals(subjectCode, that.subjectCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(majorCode, subjectCode);
    }
}
