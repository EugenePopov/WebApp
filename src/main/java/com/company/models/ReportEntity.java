package com.company.models;

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

@Entity
@Table(name = "reports")
public class ReportEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "report_date", columnDefinition = "DATETIME")
    private Date date;

    @OneToMany(mappedBy = "report")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<SmsEntity> smsEntities = new ArrayList<>();

    @OneToMany(mappedBy = "report")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ContactEntity> contactEntities = new ArrayList<>();


    public long getId() {
        return id;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        return "ReportEntity{\n" +
                "\tid=" + id + ",\n" +
                "\tdate=" + date + ",\n" +
                "\tsmsEntities=" + smsEntities + ",\n" +
                "\tcontactEntities=" + contactEntities + "\n" +
                '}';
    }
}
