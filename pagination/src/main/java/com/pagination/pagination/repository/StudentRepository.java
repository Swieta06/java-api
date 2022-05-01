package com.pagination.pagination.repository;

import com.pagination.pagination.dto.StudentDto;
import com.pagination.pagination.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}
