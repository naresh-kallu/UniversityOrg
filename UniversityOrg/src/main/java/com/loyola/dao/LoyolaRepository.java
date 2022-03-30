package com.loyola.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import com.loyola.entity.*;
import com.loyola.entity.LoyolaEntity;
import com.loyola.entity.StudentEntity;
@Repository
public interface LoyolaRepository extends JpaRepository<LoyolaEntity, Integer> {
	//@Query("SELECT a.* ,b.loyola_branch FROM student_table as a inner join loyola_table as b on a.lid=b.lid where b.loyola_branch = 'computers ';")
	@Query(value = "SELECT l FROM loyola_table l WHERE l.loyola_branch LIKE %?1%")
	public List<LoyolaEntity> findAllDepartment(@PathVariable("loyola_branch") String loyola_branch,  LoyolaEntity entity);	
	
	  @Query(value = "SELECT new com.loyola.entity.ListResponce(l.loyola_branch,s.name,s.marks) FROM  student_table s  JOIN loyola_table l ON l.branch_code = s.branch_code AND l.loyola_branch = ?1 AND  s.marks < ?2")
	  public List<ListResponce> findAllFaildStudents(@PathVariable("loyola_branch") String loyola_branch,  @PathVariable("marks") int marks);
	  @Query(value = "SELECT new com.loyola.entity.ListResponce(l.loyola_branch,s.name,s.marks) FROM  student_table s  JOIN loyola_table l ON l.branch_code = s.branch_code AND   s.marks < ?1")
	  public List<ListResponce> findAllFailStudents(@PathVariable("marks") int marks);
	  
	  @Query(value = "SELECT new com.loyola.entity.ListResponce(l.lid,l.branch_code,l.loyola_branch,s.id,s.rollno,s.name,s.marks,s.age) FROM  student_table s  JOIN loyola_table l ON  l.branch_code=s.branch_code AND  s.marks > ?1")
	  public List<ListResponce> findByStudents(@PathVariable("marks") int marks);
	 
	  
	  
	  // public List<LoyolaEntity> findAllLessThanMarks(StudentEntity entities,int marks);
	  
		/*
		 * @Query("DELETE  FROM student_table s JOIN loyola_table l WHERE s.marks < ?1 "
		 * ) public int remove(@PathVariable("marks") int marks);
		 */ 
	 }
