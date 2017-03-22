package com.company.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sms")
public class SmsEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "address")
    private String address;
    @Column(name = "message")
    private String message;
    @Column(name = "sms_date")
    private String date;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "report_id", nullable = false)
    private ReportEntity report;

    public long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Column(name = "sms_date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

        return Objects.equals(this.id, ((SmsEntity) other).getId()) &&
                Objects.equals(this.address, ((SmsEntity) other).getAddress()) &&
                Objects.equals(this.message, ((SmsEntity) other).getMessage()) &&
                Objects.equals(this.date, ((SmsEntity) other).getDate());

    }

    public ReportEntity getReport() {
        return this.report;
    }

    public void setStock(ReportEntity report) {
        this.report = report;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, address, message, date);
    }

    @Override
    public String toString() {
        return "SmsEntity{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", message='" + message + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
