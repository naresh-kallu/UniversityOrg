package com.loyola.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="loyola_table")
@Table(name="loyola_table")
public class LoyolaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lid;
	private int branch_code;
	private String loyola_branch;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "lid")
	private List<StudentEntity> student;
	
	
	
	
	public LoyolaEntity(int lid, int branch_code, String loyola_branch, List<StudentEntity> student) {
		super();
		this.lid = lid;
		this.branch_code = branch_code;
		this.loyola_branch = loyola_branch;
		this.student = student;
	}
	public LoyolaEntity() {
		super();
		// TODO Auto-generated constructor stub
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
	public List<StudentEntity> getStudent() {
		return student;
	}
	public void setStudent(List<StudentEntity> student) {
		this.student = student;
	}
	
	
	
	
	
}
