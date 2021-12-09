package com.spring.assessment1.controllers;

import com.spring.assessment1.dtos.GetAllUsersInfoDto;
import com.spring.assessment1.dtos.StudentDto;
import com.spring.assessment1.entities.Address;
import com.spring.assessment1.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping("/")
    String hello() {
        return "Hello";
    }

    @PostMapping("/create")
    ResponseEntity<String> createStudent(@Valid @RequestBody StudentDto student) {

        return service.createNewStudent(student);
    }

    @PostMapping("/add-address/{id}")
    ResponseEntity<String> addAddress(@PathVariable(name = "id") Long id,@Valid @RequestBody Address address) {

        return service.addNewAddress(id, address);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<String> updateDetails( @PathVariable(name = "id") Long id,@Valid @RequestBody StudentDto studentDto) {
        return service.updateUserDetails(id, studentDto);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteUser(@PathVariable(name = "id") Long id) {
        return service.deleteUserDetails(id);
    }

    @GetMapping("/list-users")
    List<GetAllUsersInfoDto> listUsers() {
        return service.listAllUsers();
    }

    @DeleteMapping("/delete-all")
    ResponseEntity<String> deleteAllUsers() {
        return service.deleteAllExistingUsers();
    }

    @GetMapping("/{name}")
    List<GetAllUsersInfoDto> sameUser(@PathVariable(name = "name") String name) {
        return service.sameUserName(name);
    }
}
