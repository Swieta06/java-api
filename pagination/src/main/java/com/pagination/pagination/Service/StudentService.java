package com.pagination.pagination.Service;

import com.pagination.pagination.dto.StudentDto;
import com.pagination.pagination.model.Student;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StudentService {
    Student createStudent(StudentDto studentDto);

    List<Student> findAllStudent();

    List<StudentDto> getStudentPagination(int pageNo, int pageSize);

    StudentDto upload(Integer id, MultipartFile file) throws IOException;
}
