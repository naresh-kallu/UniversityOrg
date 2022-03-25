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

}
