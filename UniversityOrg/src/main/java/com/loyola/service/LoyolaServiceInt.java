package com.loyola.service;

import java.util.List;

import com.loyola.entity.LoyolaEntity;

public interface LoyolaServiceInt {
	public LoyolaEntity saveData(LoyolaEntity entity);
	public List<LoyolaEntity> getAllList(LoyolaEntity entity);
	public List<LoyolaEntity> saveAboveMarks(int marks,LoyolaEntity entity);

}
