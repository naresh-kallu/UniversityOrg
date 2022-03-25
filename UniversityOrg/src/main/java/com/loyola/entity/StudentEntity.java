package com.loyola.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="student_table")
@Table(name="student_table")
public class StudentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int branch_code;
	private String rollno;
	private String name;
	private int marks;
	private int age;
	
	
	
	public StudentEntity(int branch_code, String rollno, String name, int marks, int age) {
		super();
		this.branch_code = branch_code;
		this.rollno = rollno;
		this.name = name;
		this.marks = marks;
		this.age = age;
	}
	public StudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentEntity(int id, int branch_code, String rollno, String name, int marks, int age) {
		super();
		this.id = id;
		this.branch_code = branch_code;
		this.rollno = rollno;
		this.name = name;
		this.marks = marks;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBranch_code() {
		return branch_code;
	}
	public void setBranch_code(int branch_code) {
		this.branch_code = branch_code;
	}
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
		
}
