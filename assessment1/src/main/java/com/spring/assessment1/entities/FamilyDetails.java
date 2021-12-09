package com.spring.assessment1.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Embeddable
@Getter
@Setter
public class FamilyDetails {

    private String fatherName;
    private String motherName;
    private String hometownCity;
}
