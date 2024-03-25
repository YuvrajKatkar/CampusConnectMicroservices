package com.yuvraj.CollegeService.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.yuvraj.CollegeService.entity.Student;



@FeignClient(name="StudentService")
public interface StudentFeign {
	@GetMapping("/student/getById/{id}")
	public Student getById(@PathVariable int id);
	@GetMapping("/student/getByCollegeId/{id}")
	public List<Student> getByStudentId(@PathVariable int id);
	@GetMapping("/student/all")
	public List<Student> getAll();
	@PostMapping("/student/save")
	public Student saveStudent(@RequestBody Student student);
}
