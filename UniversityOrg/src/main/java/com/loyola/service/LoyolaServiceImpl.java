package com.loyola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loyola.dao.LoyolaRepository;
import com.loyola.entity.LoyolaEntity;
@Service
public class LoyolaServiceImpl implements LoyolaServiceInt {
	@Autowired
	LoyolaRepository loyolaRepository;

	@Override
	public LoyolaEntity saveData(LoyolaEntity entity) {
		
		return loyolaRepository.save(entity);
	}

	@Override
	public List<LoyolaEntity> getAllList(LoyolaEntity entity) {
		
		return loyolaRepository.findAll();
	}

}
