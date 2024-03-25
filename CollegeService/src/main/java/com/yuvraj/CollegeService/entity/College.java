package com.yuvraj.CollegeService.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
@Entity
@Component
public class College {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Transient
	private List<Student> listOfStudent;
	public College() {
		super();
		// TODO Auto-generated constructor stub
	}
	public College(int id, String name, List<Student> listOfStudent) {
		super();
		this.id = id;
		this.name = name;
		this.listOfStudent = listOfStudent;
	}
	public College(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Student> getListOfStudent() {
		return listOfStudent;
	}
	public void setListOfStudent(List<Student> listOfStudent) {
		this.listOfStudent = listOfStudent;
	}
	@Override
	public String toString() {
		return "College [id=" + id + ", name=" + name + ", listOfStudent=" + listOfStudent + "]";
	}
	
	
	
	

}
