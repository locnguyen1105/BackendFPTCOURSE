package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Slotdays {
    private int slot;
    private Integer startHour;
    private Integer startMinute;
    private Integer endHour;
    private Integer endMinute;
    private String session;
    private Collection<Slots> slotsBySlot;

    @Id
    @Column(name = "slot")
    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    @Basic
    @Column(name = "start_hour")
    public Integer getStartHour() {
        return startHour;
    }

    public void setStartHour(Integer startHour) {
        this.startHour = startHour;
    }

    @Basic
    @Column(name = "start_minute")
    public Integer getStartMinute() {
        return startMinute;
    }

    public void setStartMinute(Integer startMinute) {
        this.startMinute = startMinute;
    }

    @Basic
    @Column(name = "end_hour")
    public Integer getEndHour() {
        return endHour;
    }

    public void setEndHour(Integer endHour) {
        this.endHour = endHour;
    }

    @Basic
    @Column(name = "end_minute")
    public Integer getEndMinute() {
        return endMinute;
    }

    public void setEndMinute(Integer endMinute) {
        this.endMinute = endMinute;
    }

    @Basic
    @Column(name = "session")
    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slotdays slotdays = (Slotdays) o;
        return slot == slotdays.slot &&
                Objects.equals(startHour, slotdays.startHour) &&
                Objects.equals(startMinute, slotdays.startMinute) &&
                Objects.equals(endHour, slotdays.endHour) &&
                Objects.equals(endMinute, slotdays.endMinute) &&
                Objects.equals(session, slotdays.session);
    }

    @Override
    public int hashCode() {
        return Objects.hash(slot, startHour, startMinute, endHour, endMinute, session);
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "slotdaysByDayslotno")
    public Collection<Slots> getSlotsBySlot() {
        return slotsBySlot;
    }

    public void setSlotsBySlot(Collection<Slots> slotsBySlot) {
        this.slotsBySlot = slotsBySlot;
    }
}
