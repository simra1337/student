package com.spring.assessment1.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
public class StudentDto {

    @Size(min = 3, message = "should contain at least {min} characters")
    String firstName;

    @Size(min = 3, message = "should contain at least {min} characters")
    String lastName;

    String course;
    @Size(min = 10, max = 10, message = "should contain at least {min} digits only")
    String contact;
    String city;
    String state;
    String country;
    String addressLine;

    @Size(min = 3, message = "should contain at least {min} characters")
    String fatherName;
    @Size(min = 3, message = "should contain at least {min} characters")
    String motherName;
    String hometownCity;
    String zipCode;

}
