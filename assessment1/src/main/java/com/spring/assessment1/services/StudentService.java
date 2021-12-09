package com.spring.assessment1.services;

import com.spring.assessment1.exceptions.UserNotFoundException;
import com.spring.assessment1.dtos.GetAllUsersInfoDto;
import com.spring.assessment1.dtos.StudentDto;
import com.spring.assessment1.entities.Address;
import com.spring.assessment1.entities.FamilyDetails;
import com.spring.assessment1.entities.Student;
import com.spring.assessment1.repository.AddressRepository;
import com.spring.assessment1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository repository;
    @Autowired
    AddressRepository addressRepository;

    public ResponseEntity<String> createNewStudent(StudentDto student) {
        FamilyDetails familyDetails = new FamilyDetails();
        Address address = new Address();
        Student student1 = new Student();

        familyDetails.setHometownCity(student.getHometownCity());
        familyDetails.setFatherName(student.getFatherName());
        familyDetails.setMotherName(student.getMotherName());
        student1.setFamilyDetails(familyDetails);

        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setContact(student.getContact());
        student1.setCourse(student.getCourse());

        address.setAddressLine(student.getAddressLine());
        address.setState(student.getState());
        address.setCountry(student.getCountry());
        address.setCity(student.getCity());
        address.setZipCode(student.getZipCode());
        student1.addAddress(address);

        repository.save(student1);
        return new ResponseEntity("Student created successfully.", HttpStatus.CREATED);
    }


    public ResponseEntity<String> addNewAddress(Long id, Address address) {
        Student student1 = repository.findById(id).orElse(null);
        if(student1 == null) {
            return new ResponseEntity("No user found with this id", HttpStatus.BAD_REQUEST);
        }
        Address address1 = new Address();
        address1.setZipCode(address.getZipCode());
        address1.setAddressLine(address.getAddressLine());
        address1.setCountry(address.getCountry());
        address1.setState(address.getState());
        address1.setCity(address.getCity());
        student1.addAddress(address1);
        addressRepository.save(address1);
        return new ResponseEntity("Added new address for existing user successfully.",HttpStatus.ACCEPTED);
    }

    public ResponseEntity<String> updateUserDetails(Long id, StudentDto studentDto) {
        Student student1 = repository.findById(id).orElse(null);
        if(student1 == null) {
            return new ResponseEntity("No user found with this id", HttpStatus.BAD_REQUEST);
        }
        Address address1 = addressRepository.findById(id).get();
        FamilyDetails familyDetails = new FamilyDetails();
        address1.setZipCode(studentDto.getZipCode());
        address1.setAddressLine(studentDto.getAddressLine());
        address1.setCountry(studentDto.getCountry());
        address1.setState(studentDto.getState());
        address1.setCity(studentDto.getCity());
        student1.addAddress(address1);

        student1.setFirstName(studentDto.getFirstName());
        student1.setLastName(studentDto.getLastName());
        student1.setContact(studentDto.getContact());
        student1.setCourse(studentDto.getCourse());

        familyDetails.setHometownCity(studentDto.getHometownCity());
        familyDetails.setFatherName(studentDto.getFatherName());
        familyDetails.setMotherName(studentDto.getMotherName());
        student1.setFamilyDetails(familyDetails);
        repository.save(student1);
        return new ResponseEntity("Profile updated successfully.", HttpStatus.ACCEPTED);
    }

    public ResponseEntity<String>  deleteUserDetails(Long id) {
        Student student = repository.findById(id).orElse(null);
        if(student == null) {
            return new ResponseEntity("No user found with this id", HttpStatus.BAD_REQUEST);
        }
        repository.delete(student);
        return new ResponseEntity("Student is deleted.",HttpStatus.ACCEPTED);

    }

    public List<GetAllUsersInfoDto> sameUserName(String name) {
        List<Long> ids = repository.fetchAllIdsOfUsers();
        if(ids.isEmpty()) {
            throw new UserNotFoundException("No user present");
        }
        List<GetAllUsersInfoDto> getAllUsersInfoDtoList = new ArrayList<>();
        List<Address> addresses;

        for(Long temp : ids) {
            Student student = repository.findUserById(temp);
            addresses = addressRepository.findAddressByUserId(temp);

            if(student.getFirstName().equals(name) || student.getLastName().equals(name))
            {
                getAllUsersInfoDtoList.add(new GetAllUsersInfoDto(student.getId(), student.getFirstName(), student.getLastName(),
                        student.getCourse(), student.getContact(),
                        student.getFamilyDetails().getHometownCity(),student.getFamilyDetails().getFatherName(),
                        student.getFamilyDetails().getMotherName(), addresses));
            }
        }
        return getAllUsersInfoDtoList;
    }

    public List<GetAllUsersInfoDto> listAllUsers() {
        List<Long> ids = repository.fetchAllIdsOfUsers();
        List<GetAllUsersInfoDto> getAllUsersInfoDtoList = new ArrayList<>();
        List<Address> addresses;
        Student student;
        if(ids.isEmpty()) {
            throw new UserNotFoundException("No user present in database");
        }
        for(Long id : ids) {
            student = repository.findUserById(id);
            addresses = addressRepository.findAddressByUserId(id);
            getAllUsersInfoDtoList.add(new GetAllUsersInfoDto(student.getId(), student.getFirstName(), student.getLastName(),
                    student.getCourse(), student.getContact(),
                    student.getFamilyDetails().getHometownCity(), student.getFamilyDetails().getFatherName(),
                    student.getFamilyDetails().getMotherName(), addresses));
        }

        return getAllUsersInfoDtoList;
    }

}
