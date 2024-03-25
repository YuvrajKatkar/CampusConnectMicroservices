package com.yuvraj.CollegeService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuvraj.CollegeService.entity.College;
import com.yuvraj.CollegeService.entity.Student;
import com.yuvraj.CollegeService.service.CollegeService;
import com.yuvraj.CollegeService.service.StudentFeign;

@RestController
@RequestMapping("/college")
public class CollegeController {
	@Autowired
	private CollegeService service;
	@Autowired
	private StudentFeign feign;
	
	@PostMapping("/save")
	public College saveCollege(@RequestBody College college) {
		List<Student> students = college.getListOfStudent();
		for(Student s :students) {
			feign.saveStudent(s);
		}
		College college2 = service.saveCollege(college);
		return getById(college2.getId());
	}
	@GetMapping("/getById/{id}")
	public College getById(@PathVariable int id) {
		College college = service.getById(id);
		List<Student> studentInCollege = feign.getByStudentId(id);
		college.setListOfStudent(studentInCollege);
		return college;
	}
	@GetMapping("/all")
	public List<College> getAll(){
		List<College> collegeList = service.getAll();//2 
		List<College> newList = collegeList.stream().map(college ->{// Iterate 
			List<Student> studentInCollege = feign.getByStudentId(college.getId());
			System.out.println(studentInCollege);
			college.setListOfStudent(studentInCollege);
			return college;
		}).toList();
		return newList;
	}
}
