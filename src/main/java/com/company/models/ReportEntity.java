package com.company.models;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "reports")
public class ReportEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    @Expose
    private long id;

    @Column(name = "report_date", columnDefinition = "DATETIME")
    @Expose
    private String date;

    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @Expose
    private List<SmsEntity> smsEntities = new ArrayList<>();

    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @Expose
    private List<ContactEntity> contactEntities = new ArrayList<>();

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

    public void setContactEntities(List<ContactEntity> contactEntities) {
        this.contactEntities = contactEntities;
    }

    public List<SmsEntity> getSmsEntities() {
        return smsEntities;
    }

    public List<ContactEntity> getContactEntities() {
        return contactEntities;
    }

    @Override
    public boolean equals(Object other) {

        if (this == other) {
            return true;
        }
        //noinspection SimplifiableIfStatement
        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        return Objects.equals(this.id, ((ReportEntity) other).getId()) &&
                Objects.equals(this.date, ((ReportEntity) other).getDate());

    }

    @Override
    public int hashCode() {

        return Objects.hash(id, date);
    }

    @Transactional
    @Override
    public String toString() {
        return "{\n" +
                "\tid:" + id + ",\n" +
                "\tdate:" + date + ",\n" +
                "\tsms:" + smsEntities + ",\n" +
                "\tcontacts:" + contactEntities + "\n" +
                '}';
    }
}
