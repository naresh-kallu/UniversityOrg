package com.loyola.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loyola.config.dao.LoyolaDaoImpl;
import com.loyola.dao.LoyolaRepository;
import com.loyola.entity.ListResponce;
import com.loyola.entity.LoyolaEntity;
import com.loyola.entity.StudentEntity;
import com.loyola.service.LoyolaServiceInt;

@RestController
public class LoyolaController {
	@Autowired
	LoyolaServiceInt serviceInt;
	@Autowired
	LoyolaRepository loyolaRepository;
	@PostMapping("/save")
	public LoyolaEntity saveLoyolaData(@RequestBody LoyolaEntity entity) {
		return serviceInt.saveData(entity);
	}
	@GetMapping("/list")
	public List<LoyolaEntity> getAllLoyolaData(LoyolaEntity entity){
		
		return serviceInt.getAllList(entity);
	}
	@GetMapping("/department/{loyola_branch}")
	public List<LoyolaEntity> getDepartment(@PathVariable("loyola_branch") String loyola_branch, LoyolaEntity entity){
		return loyolaRepository.findAllDepartment(loyola_branch,entity);
	}
	@GetMapping("/failStudentsDepartment/{loyola_branch}/{marks}")
	public List<ListResponce> failStudents(@PathVariable("loyola_branch") String loyola_branch,  @PathVariable("marks") int marks){
		return loyolaRepository.findAllFaildStudents(loyola_branch, marks);
	}
	@GetMapping("/allDepartmentFailList/{marks}")
	public List<ListResponce> failStudents(  @PathVariable("marks") int marks){
		return loyolaRepository.findAllFailStudents( marks);
	}
	@PutMapping("/saveAbove/{marks}")
	public List<LoyolaEntity> saveAbove(){
		return null;
	}
	@GetMapping("/aboveAll/{marks}")
	public List<ListResponce> aboveAll(@PathVariable("marks") int marks,ListResponce entity){
		System.out.println(entity.getMarks());
		StudentEntity e=new StudentEntity();
		e.setId(entity.getId());
		e.setBranch_code(entity.getBranch_code());
		e.setName(entity.getName());
		e.setAge(entity.getAge());
		e.setRollno(entity.getRollno());
		e.setMarks(entity.getMarks()+10);
		List<StudentEntity> studentEntities=new ArrayList<StudentEntity>();
		studentEntities.add(e);
	
		LoyolaEntity l=new LoyolaEntity(entity.getLid(), entity.getBranch_code(), entity.getLoyola_branch(), studentEntities);
		
		return loyolaRepository.findByStudents(marks);
	}
	@PutMapping("/addMarks/{marks}")
	public List<LoyolaEntity> addMarks(@PathVariable("marks") int marks,LoyolaEntity entity){
		loyolaRepository.findByStudents(marks);
		return null;
	}
	public List<LoyolaEntity> sortOrder(List<LoyolaEntity> entity){
		//Collections.sort();
	
		
		return loyolaRepository.findAll();
	}
	@GetMapping("/getHibernateAll")
	public List<LoyolaEntity> getAll(LoyolaEntity entity){
		LoyolaDaoImpl impl=new LoyolaDaoImpl();
		return impl.getAll(entity);
	}
	

}
