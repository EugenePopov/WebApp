package com.company.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "phone_numbers")
public class PhoneNumberEntity {

    @Id
    @Column(name = "number")
    private String number;

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
                "\t\t\t}";
    }
}
