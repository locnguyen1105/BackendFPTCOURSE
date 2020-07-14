package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "classsubstudentslots")
@IdClass(ClassSubStudentSlotsPK.class)
public class ClassSubStudentSlots {
    private String studentCode;
    private int slotno;
    private int classsubCode;
    private boolean attendance;
    private String comment;
    private ClassSubStudents classSubStudents;
    private Slots slots;

    @Id
    @Column(name = "student_code")
    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    @Id
    @Column(name = "slotno")
    public int getSlotno() {
        return slotno;
    }

    public void setSlotno(int slotno) {
        this.slotno = slotno;
    }

    @Id
    @Column(name = "classsub_code")
    public int getClasssubCode() {
        return classsubCode;
    }

    public void setClasssubCode(int classsubCode) {
        this.classsubCode = classsubCode;
    }

    @Basic
    @Nullable
    @Column(name = "attendance")
    public boolean isAttendance() {
        return attendance;
    }

    public void setAttendance(boolean attendance) {
        this.attendance = attendance;
    }

    @Basic
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassSubStudentSlots that = (ClassSubStudentSlots) o;
        return slotno == that.slotno &&
                classsubCode == that.classsubCode &&
                attendance == that.attendance &&
                Objects.equals(studentCode, that.studentCode) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentCode, slotno, classsubCode, attendance, comment);
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "classsub_code", referencedColumnName = "classsub_code", nullable = false, insertable = false, updatable = false), @JoinColumn(name = "student_code", referencedColumnName = "student_code", nullable = false, insertable = false, updatable = false)})
    public ClassSubStudents getClassSubStudents() {
        return classSubStudents;
    }

    public void setClassSubStudents(ClassSubStudents classSubStudents) {
        this.classSubStudents = classSubStudents;
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "classsub_code", referencedColumnName = "classsub_code", nullable = false, insertable = false, updatable = false), @JoinColumn(name = "slotno", referencedColumnName = "slotno", nullable = false, insertable = false, updatable = false)})
    public Slots getSlots() {
        return slots;
    }

    public void setSlots(Slots slots) {
        this.slots = slots;
    }
}
