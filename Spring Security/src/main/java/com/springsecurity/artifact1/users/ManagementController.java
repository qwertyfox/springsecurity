package com.springsecurity.artifact1.users;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.springsecurity.artifact1.users.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/management")
public class ManagementController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student( 1, "Peter Parker"),
            new Student(2, "John Wick"),
            new Student(3,"Bruce Banner")
    );


    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TRAINEE_ADMIN')")
    public List<Student> displayAllStudents() {
        return STUDENTS;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println(student);
    }

    @DeleteMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable("studentId") Integer studentId){
        System.out.println(studentId);
    }

    @PutMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable("studentId") Integer StudentId, @RequestBody Student updatedStudent){
        System.out.println(String.format("%s %s", StudentId, updatedStudent));
    }

}
