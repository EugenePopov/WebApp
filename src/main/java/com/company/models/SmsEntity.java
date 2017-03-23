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

    @Column(name = "sms_type")
    private String smsType;

    @ManyToOne
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSmsType() {
        return smsType;
    }

    public void setSmsType(String smsType) {
        this.smsType = smsType;
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
                Objects.equals(this.date, ((SmsEntity) other).getDate()) &&
                Objects.equals(this.smsType, ((SmsEntity) other).getSmsType());

    }

    public ReportEntity getReport() {
        return this.report;
    }

    public void setStock(ReportEntity report) {
        this.report = report;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, address, message, date, smsType);
    }

    @Override
    public String toString() {
        return "\n\t\tSmsEntity{\n" +
                "\t\t\tid=" + id + ",\n" +
                "\t\t\taddress='" + address + '\'' + ",\n" +
                "\t\t\tmessage='" + message + '\'' + ",\n" +
                "\t\t\tdate='" + date + '\'' + "\n" +
                "\t\t\tsmsType='" + smsType + '\'' + "\n" +
                "\t\t}";
    }
}
