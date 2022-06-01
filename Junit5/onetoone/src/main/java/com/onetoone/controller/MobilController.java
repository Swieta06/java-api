package com.onetoone.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.onetoone.dto.MobilDto;
import com.onetoone.dto.ResponseMobilDto;
import com.onetoone.service.MobilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/api/mobil")
public class MobilController {

    @Autowired
    private MobilService mobilService;

    @GetMapping("/todo")
    public void getToDo() throws JsonProcessingException {
        mobilService.getTodo();
    }

    // localhost:8080/api/mobil/getAll?pageNo=1&pageSize=2
    @GetMapping("/getAll")
    public ResponseEntity<ResponseMobilDto> getAll(@RequestParam int pageNo, @RequestParam int pageSize) {
        ResponseMobilDto responseMobilDto = this.mobilService.getAll(pageNo, pageSize);

        return new ResponseEntity<>(responseMobilDto, HttpStatus.OK);
    }

    // localhost:8080/api/mobil/getById/{1}
    @GetMapping("/getById/{id}")
    public ResponseEntity<MobilDto> getById(@PathVariable Integer id) throws JsonProcessingException {
        MobilDto mobilDto = this.mobilService.getById(id);

        return new ResponseEntity<>(mobilDto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<MobilDto> create(@RequestBody MobilDto mobilDto) {
        MobilDto mobilDtoCreated = this.mobilService.create(mobilDto);

        return new ResponseEntity<>(mobilDtoCreated, HttpStatus.CREATED);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<MobilDto> deleteById(@PathVariable Integer id) {
        MobilDto mobilDto = this.mobilService.deleteById(id);

        return new ResponseEntity<>(mobilDto, HttpStatus.OK);
    }

    @PostMapping("/upload")
    public ResponseEntity<MobilDto> uploadImage(@RequestParam Integer id, @RequestParam MultipartFile file) {
        MobilDto mobilDto = this.mobilService.uploadImage(id, file);

        return new ResponseEntity<>(mobilDto, HttpStatus.OK);
    }
}
