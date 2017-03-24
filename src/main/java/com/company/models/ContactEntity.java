package com.company.models;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "contacts")
public class ContactEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "report_id", nullable = false)
    private ReportEntity report;

    @OneToMany(mappedBy = "contactEntity",  cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<PhoneNumberEntity> phoneNumberEntities = new ArrayList<>();

    public ContactEntity(){
        this.report = new ReportEntity();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumberEntities(List<PhoneNumberEntity> phoneNumberEntities) {
        this.phoneNumberEntities = phoneNumberEntities;
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

        return Objects.equals(this.id, ((ContactEntity) other).getId()) &&
                Objects.equals(this.name, ((ContactEntity) other).getName());

    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "\n\t\tContactEntity{\n" +
                "\t\t\tid=" + id +  ",\n" +
                "\t\t\tname='" + name + '\'' +  ",\n" +
                "\t\tPhoneNumberEntities" + phoneNumberEntities + "\n" +
                "\t\t}";
    }
}
