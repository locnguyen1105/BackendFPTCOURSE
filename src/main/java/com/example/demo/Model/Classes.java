package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Classes {
    private String code;
    private int semester;
    private String majorCode;
    private Collection<ClassSubs> classSubsByCode;
    private Majors majorsByMajorCode;
    private Collection<StudentClasses> studentClassesByCode;

    @Id
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
    @Column(name = "major_code")
    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classes classes = (Classes) o;
        return semester == classes.semester &&
                Objects.equals(code, classes.code) &&
                Objects.equals(majorCode, classes.majorCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, semester, majorCode);
    }

    @OneToMany(mappedBy = "classesByClassCode")
    public Collection<ClassSubs> getClassSubsByCode() {
        return classSubsByCode;
    }

    public void setClassSubsByCode(Collection<ClassSubs> classSubsByCode) {
        this.classSubsByCode = classSubsByCode;
    }

    @JsonIgnoreProperties()
    @ManyToOne
    @JoinColumn(name = "major_code", referencedColumnName = "code", nullable = false, insertable = false, updatable = false)
    public Majors getMajorsByMajorCode() {
        return majorsByMajorCode;
    }

    public void setMajorsByMajorCode(Majors majorsByMajorCode) {
        this.majorsByMajorCode = majorsByMajorCode;
    }

    @JsonIgnoreProperties("studentClassesByCode")
    @OneToMany(mappedBy = "classesByClassCode")
    public Collection<StudentClasses> getStudentClassesByCode() {
        return studentClassesByCode;
    }

    public void setStudentClassesByCode(Collection<StudentClasses> studentClassesByCode) {
        this.studentClassesByCode = studentClassesByCode;
    }
}
