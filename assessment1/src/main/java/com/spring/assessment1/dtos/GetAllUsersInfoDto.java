package com.spring.assessment1.dtos;

import com.spring.assessment1.entities.Address;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class GetAllUsersInfoDto {

    Long id;

    @Size(min = 3, message = "should contain at least {min} characters")
    String firstName;
    @Size(min = 3, message = "should contain at least {min} characters")
    String lastName;
    String course;
    @Size(min = 10, max = 10, message = "should contain at least {min} digits only")
    String contact;
    @Size(min = 3, message = "should contain at least {min} characters")
    String fatherName;
    @Size(min = 3, message = "should contain at least {min} characters")
    String motherName;
    String hometownCity;

    private List<Address> addresses;

    public GetAllUsersInfoDto(Long id, String firstName, String lastName, String course, String contact, String hometownCity, String fatherName, String motherName, List<Address> addresses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.contact = contact;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.hometownCity = hometownCity;
        this.addresses = addresses;
    }
}
