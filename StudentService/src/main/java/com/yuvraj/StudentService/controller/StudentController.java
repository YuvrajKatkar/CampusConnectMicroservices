package com.yuvraj.StudentService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuvraj.StudentService.entity.Student;
import com.yuvraj.StudentService.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService service;
	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student student) {
		return service.saveStudent(student) ;
	}
	@GetMapping("/getById/{id}")
	public Student getById(@PathVariable int id) {
		return service.getById(id);
	}
	@GetMapping("/getByCollegeId/{id}")
	public List<Student> getByStudentId(@PathVariable int id) {
		return service.getByStudentId(id);
	}
	@GetMapping("/all")
	public List<Student> getAll(){
		return service.getAll();
	}
}
