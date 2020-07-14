package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class SlotsPK implements Serializable {
    private int classsubCode;
    private int slotno;

    @Column(name = "classsub_code")
    @Id
    public int getClasssubCode() {
        return classsubCode;
    }

    public void setClasssubCode(int classsubCode) {
        this.classsubCode = classsubCode;
    }

    @Column(name = "slotno")
    @Id
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
        SlotsPK slotsPK = (SlotsPK) o;
        return classsubCode == slotsPK.classsubCode &&
                slotno == slotsPK.slotno;
    }

    @Override
    public int hashCode() {
        return Objects.hash(classsubCode, slotno);
    }
}
