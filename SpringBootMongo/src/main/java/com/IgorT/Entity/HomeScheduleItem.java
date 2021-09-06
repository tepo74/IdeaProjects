package com.IgorT.Entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.sql.Time;
import java.time.DayOfWeek;

@EntityScan
@Entity
@Table(name="homescheduleitem")
public class HomeScheduleItem {
    @Id
    private int id;
    @Column
    private String homeName;
    @ManyToOne(fetch=FetchType.EAGER)
    private ItemType itemType;

    @ManyToOne(fetch=FetchType.EAGER)
    private Student student;

    private String itemFreqency;

    private DayOfWeek dayOfweek;

    private Time timeOfDay;

    public HomeScheduleItem() {
    }

    public HomeScheduleItem(int id, String homeName, ItemType itemType, Student student, String itemFreqency) {
        this.id = id;
        this.homeName = homeName;
        this.itemType = itemType;
        this.student = student;
        this.itemFreqency = itemFreqency;
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getItemFreqency() {
        return itemFreqency;
    }

    public void setItemFreqency(String itemFreqency) {
        this.itemFreqency = itemFreqency;
    }

    public DayOfWeek getDayOfweek() {
        return dayOfweek;
    }

    public void setDayOfweek(DayOfWeek dayOfweek) {
        this.dayOfweek = dayOfweek;
    }

    public Time getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(Time timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    @Override
    public String toString() {
        return "HomeScheduleItem{" +
                "id=" + id +
                ", homeName='" + homeName + '\'' +
                ", itemType=" + itemType +
                ", student=" + student +
                ", itemFreqency='" + itemFreqency + '\'' +
                '}';
    }
}
