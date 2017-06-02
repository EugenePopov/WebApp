package com.company.models;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reports")
public class ReportEntity {

    @Id
    @GeneratedValue
    @Column(name = "report_id", unique = true)
    private long id;

    @Column(name = "report_date")
    private String date;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "report_id")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<SmsEntity> smsEntities = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "report_id")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CallEntity> calls = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "report_id")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ContactEntity> contactEntities = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "report_id")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Location> locations = new ArrayList<>();

    public long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSmsEntities(List<SmsEntity> smsEntities) {
        this.smsEntities = smsEntities;
    }

    public List<SmsEntity> getSmsEntities() {
        return smsEntities;
    }

    public void setContactEntities(List<ContactEntity> contactEntities) {
        this.contactEntities = contactEntities;
    }

    public List<ContactEntity> getContactEntities() {
        return contactEntities;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<CallEntity> getCalls() {
        return calls;
    }

    public void setCalls(List<CallEntity> calls) {
        this.calls = calls;
    }

    @Transactional
    @Override
    public String toString() {
        return "{\n" +
                "\tid:" + id + ",\n" +
                "\tdate:" + date + ",\n" +
                "\tsms:" + smsEntities + ",\n" +
                "\tcontacts:" + contactEntities + "\n" +
                "\tcalls:" + calls + "\n" +
                "\tlocations:" + locations + "\n" +
                '}';
    }
}
