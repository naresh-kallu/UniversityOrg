package com.loyola.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ListResponce {
	
	private int lid;
	private int branch_code;
	private String loyola_branch;
	private int id;
	private String rollno;
	
	
	public ListResponce(String loyola_branch, String name, int marks) {
		super();
		this.loyola_branch = loyola_branch;
		this.name = name;
		this.marks = marks;
	}
	public ListResponce() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ListResponce(int lid, int branch_code, String loyola_branch, int id, String rollno, String name, int marks,
			int age) {
		super();
		this.lid = lid;
		this.branch_code = branch_code;
		this.loyola_branch = loyola_branch;
		this.id = id;
		this.rollno = rollno;
		this.name = name;
		this.marks = marks;
		this.age = age;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public int getBranch_code() {
		return branch_code;
	}
	public void setBranch_code(int branch_code) {
		this.branch_code = branch_code;
	}
	public String getLoyola_branch() {
		return loyola_branch;
	}
	public void setLoyola_branch(String loyola_branch) {
		this.loyola_branch = loyola_branch;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	private String name;
	private int marks;
	private int age;
	
		

}
