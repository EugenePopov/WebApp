package com.company.models;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "calls")
public class CallEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "number")
    private String number;

    @Column(name = "duration")
    private String duration;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private String date;

    @Column(name = "type")
    private int type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CallEntity{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", duration='" + duration + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", type=" + type +
                '}';
    }
}
