package com.loyola.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.loyola.entity.LoyolaEntity;
@Repository
public interface LoyolaRepository extends JpaRepository<LoyolaEntity, Integer> {
	//@Query("SELECT a.* ,b.loyola_branch FROM student_table as a inner join loyola_table as b on a.lid=b.lid where b.loyola_branch = 'computers ';")
	@Query(value = "SELECT l FROM loyola_table l WHERE l.loyola_branch LIKE %?1%")
	public List<LoyolaEntity> findAllDepartment(@PathVariable("loyola_branch") String loyola_branch,  LoyolaEntity entity);	
	
}
