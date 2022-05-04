package com.pagination.pagination.Service.impl;

import com.pagination.pagination.Service.StudentService;
import com.pagination.pagination.dto.StudentDto;
import com.pagination.pagination.model.Student;
import com.pagination.pagination.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
        student.setAlamat(studentDto.getAlamat());
        return this.studentRepository.save(student);
    }

    @Override
    public List<Student> findAllStudent() {
        return this.studentRepository.findAll();
    }

    @Override
    public List<StudentDto> getStudentPagination(int pageNo, int pageSize) {
        Pageable pageable= PageRequest.of(pageNo-1,pageSize);
        List<Student> pageStudent= this.studentRepository.findAll(pageable).getContent();

        List<StudentDto> studentList=new ArrayList<>();

        for (Student student:pageStudent){
            StudentDto studentDto=new StudentDto();
            studentDto.setId(student.getId());
            studentDto.setAge(student.getAge());
            studentDto.setAlamat(student.getAlamat());
            studentDto.setName(student.getName());
            //masukan ke list ketika sudah di convert
            studentList.add(studentDto);

        }
        return studentList;
    }

   /* @Override
    public StudentDto upload(Integer id, MultipartFile file) throws IOException {
        Optional<Student>studentOptional=studentRepository.findById(id.longValue());
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            if (student != null) {
                Byte[] imageObjects = new Byte[file.getBytes().length];
                int i = 0;for (byte b : file.getBytes()){imageObjects[i++] = b;
                }
                student.getName().setImage(imageObjects);
                mobilRepository.save(mobil);
                return convertMobilToMobilDto(mobil);
            }

        }
        return null;
    }*/


}
