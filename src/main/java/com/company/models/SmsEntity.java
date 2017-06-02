package com.company.models;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sms")
public class SmsEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    @Expose
    private long id;

    @Column(name = "address")
    @Expose
    private String address;

    @Column(name = "message")
    @Expose
    private String message;

    @Column(name = "sms_date")
    @Expose
    private String date;

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

    @Override
    public int hashCode() {
        return Objects.hash(id, address, message, date);
    }

    @Override
    public String toString() {
        return "\n\t\t{\n" +
                "\t\t\tid:" + id + ",\n" +
                "\t\t\taddress='" + address + '\'' + ",\n" +
                "\t\t\tmessage='" + message + '\'' + ",\n" +
                "\t\t\tdate='" + date + '\'' + "\n" +
                "\t\t}";
    }
}
