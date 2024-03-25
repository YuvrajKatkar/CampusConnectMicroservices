package com.yuvraj.CollegeService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuvraj.CollegeService.entity.College;
import com.yuvraj.CollegeService.repo.CollegeRepo;

@Service
public class CollegeService {
	@Autowired
	private CollegeRepo repo;
	public College saveCollege(College college) {
		// TODO Auto-generated method stub
		return repo.save(college);
	}
	public College getById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}
	public List<College> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
