package com.loyola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loyola.dao.LoyolaRepository;
import com.loyola.entity.LoyolaEntity;
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

}
