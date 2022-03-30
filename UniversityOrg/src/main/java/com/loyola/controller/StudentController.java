package com.loyola.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loyola.dao.StudentRepository;
import com.loyola.entity.StudentEntity;

@RestController
public class StudentController {
	@Autowired
	StudentRepository repository;
	@GetMapping("/getFail/{marks}")
	public List<StudentEntity> getFailData(@PathVariable("marks") int marks,StudentEntity entity){
		return repository.findAllLessMarks(marks, entity);
	}
	@GetMapping("/fail/{marks}")
	public List<StudentEntity> findAllFailStudents(@PathVariable("marks") int marks){
		return repository.findByMarksLessThan(marks);
	}
	
	
	
	/*
	 * @DeleteMapping("/delete/{id}") public List<StudentEntity>
	 * deleteStud(@PathVariable("id") int id) { return
	 * repository.deleteStudents(id); }
	 */
	@PutMapping("/addMarksStudents/{marks}/{branch_code}")
	public List<StudentEntity> addMarks(@PathVariable("marks") int marks,@PathVariable("branch_code") int branch_code){
		
		return repository.addMarks(marks, branch_code);
	}
	
	@PutMapping("/addMarks")
	public List<StudentEntity> addMarks(){
		
		
		List<StudentEntity> list=repository.findAll();
		
		//Iterable<StudentEntity> list1=(Iterable<StudentEntity>) list.iterator();
			for (StudentEntity studentEntity : list) {
				
			
				//System.out.println(studentEntity.getMarks());
				if((studentEntity.getMarks() > 60) && (studentEntity.getBranch_code() == 8888) ) {
					
					System.out.println(studentEntity.getMarks());
				
	
					
					
					
					StudentEntity entity=new StudentEntity();
					entity.setId(studentEntity.getId());
					entity.setBranch_code(studentEntity.getBranch_code());
					entity.setRollno(studentEntity.getRollno());
					entity.setName(studentEntity.getName());
					int a=studentEntity.getMarks()+10;
					entity.setMarks(a);
					entity.setAge(studentEntity.getAge());
					
					entity.getId();
					entity.getBranch_code();
					entity.getRollno();
					entity.getName();
					entity.getMarks();
					entity.getAge();
					repository.save(entity);
					
					
					
					
					
				}
				
			}
		
		
		return null;
	}
	@DeleteMapping("/delete")
	public List<StudentEntity> delete(){
		List<StudentEntity> list=repository.findAll();
		for (StudentEntity studentEntity : list) {
			if(studentEntity.getMarks() < 10  && studentEntity.getBranch_code() == 8888) {
				repository.delete(studentEntity);
				
			}
			
		}
		
		return null;
	}
	

}
