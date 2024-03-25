package com.yuvraj.StudentService.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yuvraj.StudentService.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{
	public List<Student> findByCollegeId(int id);

}
