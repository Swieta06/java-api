package com.onetoone.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.onetoone.dto.MobilDto;
import com.onetoone.dto.ResponseMobilDto;
import com.onetoone.entity.Mobil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface MobilService {
    public void getTodo() throws JsonProcessingException;

    public MobilDto create(MobilDto mobilDto);

    public ResponseMobilDto getAll(int pageNo, int pageSize);

    public MobilDto deleteById(Integer id);

    public MobilDto getById(Integer id) throws JsonProcessingException;

    public MobilDto uploadImage(Integer id, MultipartFile file);
}
