package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@IdClass(SlotsPK.class)
public class Slots {
    private int classsubCode;
    private Date date;
    private int room;
    private int dayslotno;
    private int slotno;
    private Collection<ClassSubStudentSlots> classSubStudentSlots;
    private ClassSubs classSubsByClasssubCode;
    private ClassSubs classSubsByClasssubCode_0;
    private Slotdays slotdaysByDayslotno;

    @Id
    @Column(name = "classsub_code")
    public int getClasssubCode() {
        return classsubCode;
    }

    public void setClasssubCode(int classsubCode) {
        this.classsubCode = classsubCode;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "room")
    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    @Basic
    @Column(name = "dayslotno")
    public int getDayslotno() {
        return dayslotno;
    }

    public void setDayslotno(int dayslotno) {
        this.dayslotno = dayslotno;
    }

    @Id
    @Column(name = "slotno")
    public int getSlotno() {
        return slotno;
    }

    public void setSlotno(int slotno) {
        this.slotno = slotno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slots slots = (Slots) o;
        return classsubCode == slots.classsubCode &&
                room == slots.room &&
                dayslotno == slots.dayslotno &&
                slotno == slots.slotno &&
                Objects.equals(date, slots.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classsubCode, date, room, dayslotno, slotno);
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "slots")
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
    @JoinColumn(name = "classsub_code", referencedColumnName = "code", nullable = false, insertable = false, updatable = false)
    public ClassSubs getClassSubsByClasssubCode_0() {
        return classSubsByClasssubCode_0;
    }

    public void setClassSubsByClasssubCode_0(ClassSubs classSubsByClasssubCode_0) {
        this.classSubsByClasssubCode_0 = classSubsByClasssubCode_0;
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "dayslotno", referencedColumnName = "slot", nullable = false, insertable = false, updatable = false)
    public Slotdays getSlotdaysByDayslotno() {
        return slotdaysByDayslotno;
    }

    public void setSlotdaysByDayslotno(Slotdays slotdaysByDayslotno) {
        this.slotdaysByDayslotno = slotdaysByDayslotno;
    }
}
