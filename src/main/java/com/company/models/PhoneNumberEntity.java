package com.company.models;

import javax.persistence.*;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "phone_numbers")
public class PhoneNumberEntity {


    private String number;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "number_id", unique = true)
    private long id;

    @ManyToOne()
    @JoinColumn(name = "contact_id", nullable = false)
    private ContactEntity contactEntity;

    public PhoneNumberEntity(){
        this.contactEntity = new ContactEntity();
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setContactEntity(ContactEntity contactEntity) {
        this.contactEntity = contactEntity;
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

        return Objects.equals(this.number, ((PhoneNumberEntity) other).getNumber());

    }

    @Override
    public int hashCode() {

        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "\n\t\t\tPhoneNumberEntity{\n" +
                "\t\t\t\tnumber='" + number + '\'' + "\n" +
                "\t\t\t\tid='" + id + '\'' + "\n" +
                "\t\t\t}";
    }
}
