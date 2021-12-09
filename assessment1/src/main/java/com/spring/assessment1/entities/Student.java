package com.spring.assessment1.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Student {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String course;
    private String contact;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private List<Address> addresses;

    @Embedded
    FamilyDetails familyDetails;

    public void addAddress(Address address)
    {
        if(address != null)
        {
            if(addresses == null)
            {
                addresses = new ArrayList<>();
            }
            addresses.add(address);
        }
    }
}
