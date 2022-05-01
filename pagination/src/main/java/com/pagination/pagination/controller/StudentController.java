package com.pagination.pagination.controller;

import com.pagination.pagination.Service.StudentService;
import com.pagination.pagination.dto.StudentDto;
import com.pagination.pagination.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/test")
    public String test(){
        return "masuk";
    }


    @PostMapping("/create")
    public Student createStudent(@RequestBody StudentDto studentDto){
        return this.studentService.createStudent(studentDto);
    }

    @GetMapping("/students")
  public List<Student> getAllStudent(){
        return this.studentService.findAllStudent();
    }
    //api/v1/student/pagination?pageNo=2&pageSize=5
    @GetMapping("/pagination")
    public List<StudentDto> getAllStudentPagination(@RequestParam int pageNo,@RequestParam int pageSize){
        return this.studentService.getStudentPagination(pageNo,pageSize);
    }
    @PostMapping("/uploadImage")
    public ResponseEntity<StudentDto>uploadImage(@RequestParam Integer id, @RequestParam("Image")MultipartFile file)throws IOException {
       StudentDto studentDtoUpload= this.studentService.upload(id,file);
       return  new ResponseEntity<>(studentDtoUpload, HttpStatus.OK);
    }

}
