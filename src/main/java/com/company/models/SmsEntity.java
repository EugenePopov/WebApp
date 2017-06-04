package com.company.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "sms")
public class SmsEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    private long id;

    @Column(name = "address")
    private String address;

    @Column(name = "message", columnDefinition="TEXT")
    private String message;

    @Column(name = "date")
    private String date;

    @Column(name = "type")
    private String type;

    @Column(name = "read_state")
    private String readState;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
