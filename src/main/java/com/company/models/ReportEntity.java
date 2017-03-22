package com.company.models;

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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "report", cascade = CascadeType.ALL)
    private List<SmsEntity> smsEntities = new ArrayList<>();


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

    @Override
    public String toString() {
        return "ReportEntity{" +
                "id=" + id +
                ", date=" + date +
                ", smsEntities=" + smsEntities +
                '}';
    }
}
