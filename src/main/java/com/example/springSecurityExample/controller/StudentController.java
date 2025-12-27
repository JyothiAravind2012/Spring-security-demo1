package com.example.springSecurityExample.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springSecurityExample.modal.Student;

import jakarta.servlet.ServletRequest;

@RestController
public class StudentController {

	private List<Student> studentList =
		    new ArrayList<>(Arrays.asList(
		        new Student(1, "Anu"),
		        new Student(2, "Binu")
		    ));

	@GetMapping("/students")
	public List<Student> getStudents() {
		return studentList;

	}

	@PostMapping("/students")
	public Student addStudents( @RequestBody Student student) {
		studentList.add(student);
		return student;

	}
	
	@GetMapping("/csrf-token")
	public CsrfToken getCsrfToken(ServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
		
	}
}
