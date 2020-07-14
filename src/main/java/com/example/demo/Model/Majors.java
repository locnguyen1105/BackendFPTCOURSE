package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Majors {
    private String code;
    private String name;
    private Collection<Classes> classesByCode;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Majors majors = (Majors) o;
        return Objects.equals(code, majors.code) &&
                Objects.equals(name, majors.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name);
    }

    @JsonIgnore
    @OneToMany(mappedBy = "majorsByMajorCode")
    public Collection<Classes> getClassesByCode() {
        return classesByCode;
    }

    public void setClassesByCode(Collection<Classes> classesByCode) {
        this.classesByCode = classesByCode;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "majorsByMajorCode")
    public Collection<MajorSubjects> getMajorSubjectsByCode() {
        return majorSubjectsByCode;
    }

    public void setMajorSubjectsByCode(Collection<MajorSubjects> majorSubjectsByCode) {
        this.majorSubjectsByCode = majorSubjectsByCode;
    }
}
