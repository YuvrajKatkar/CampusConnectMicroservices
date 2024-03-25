package com.yuvraj.StudentService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuvraj.StudentService.entity.Student;
import com.yuvraj.StudentService.repo.StudentRepo;

@Service
public class StudentService {
	@Autowired
	private StudentRepo repo;

	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return repo.save(student);
	}

	public Student getById(int id) {
		// TODO Auto-generated method stub
		Optional<Student> optional = repo.findById(id);
		if(optional.isPresent()) return optional.get();
		return null;
	}

	public List<Student> getByStudentId(int id) {
		// TODO Auto-generated method stub
		return repo.findByCollegeId(id);
	}

	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
}
