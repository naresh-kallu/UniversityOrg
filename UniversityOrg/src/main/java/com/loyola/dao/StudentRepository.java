package com.loyola.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.loyola.entity.StudentEntity;
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
	@Query(value = "SELECT l FROM student_table l WHERE l.marks <?1")
	public List<StudentEntity> findAllLessMarks(@PathVariable("marks") int marks,StudentEntity entity);
	
	public List<StudentEntity> findByMarksLessThan(int marks);
	@Query(value = "SELECT s FROM student_table s WHERE s.marks < 40")
	public List<StudentEntity> findAllFail(StudentEntity entity);
	
	@Query(value = "UPDATE student_table s SET s.marks=s.marks+10 WHERE s.marks > ?1 AND s.branch_code=?2 AND s.id BETWEEN 1 AND 500")
	public List<StudentEntity> addMarks(@PathVariable("marks") int marks ,@PathVariable("branch_code") int branch_code);
	//public List<StudentEntity>  deleteStudents(@PathVariable("id") int id);
	
}
