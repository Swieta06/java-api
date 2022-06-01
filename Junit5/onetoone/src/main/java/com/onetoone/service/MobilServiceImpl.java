package com.onetoone.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.gson.Gson;
import com.onetoone.dto.MobilDetailDto;
import com.onetoone.dto.MobilDto;
import com.onetoone.dto.ResponseMobilDto;
import com.onetoone.entity.Mobil;
import com.onetoone.entity.MobilDetail;
import com.onetoone.dto.PlaceHolder;
import com.onetoone.dto.Student;
import com.onetoone.repository.MobilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MobilServiceImpl implements MobilService {

    @Autowired
    private MobilRepository mobilRepository;

    @Override
    public void getTodo() throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();
        List<PlaceHolder> response = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts",
                List.class);

        PlaceHolder placeHolder = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/{id}",
                PlaceHolder.class, 1);
        System.out.println("placeHolder.getUserId() = " + placeHolder.getUserId());
        System.out.println("placeHolder.getId() = " + placeHolder.getId());
        System.out.println("placeHolder.getTitle() = " + placeHolder.getTitle());
        System.out.println("placeHolder.getBody() = " + placeHolder.getBody());

        //
        String studentJsonString = "{" +
                "\"id\": 8," +
                "\"name\": \"Gajahmada\"," +
                "\"gpa\": 4.0," +
                "\"email\": null," +
                "\"passengers\": [{\"name\": \"jensen\",\"age\": 30},{\"name\": \"Jennifer\",\"age\": 35},{\"name\": \"Kelvin\",\"age\": 25}]" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();

        // JsonNode
        JsonNode jsonNode = objectMapper.readTree(studentJsonString);

        int id = jsonNode.get("id").asInt();
        String name = jsonNode.get("name").asText();
        double gpa = jsonNode.get("gpa").asDouble();
        String email = jsonNode.get("email").asText();
        JsonNode passengerList = jsonNode.get("passengers");

        System.out.println("id: " + id);
        System.out.println("name: " + name);
        System.out.println("gpa: " + gpa);
        System.out.println("email: " + email);

        if (passengerList.isArray()) {
            for (JsonNode passenger : passengerList) {
                System.out.println("  name: " + passenger.get("name"));
                System.out.println("  age: " +passenger.get("age"));
            }
        }

        // Gson
        Gson gson = new Gson();
        Student student = gson.fromJson(studentJsonString, Student.class);
        System.out.println("gson name: " + student.getName());
        System.out.println("gson gpa: " + student.getGpa());
        System.out.println("gson passenger(0): " + student.getPassengers().get(0));
        System.out.println("gson passenger(1): " + student.getPassengers().get(1));
        System.out.println("gson passenger(2): " + student.getPassengers().get(2));
    }

    @Override
    public MobilDto create(MobilDto mobilDto) {
        Mobil mobil = convertMobilDtoToMobil(mobilDto);

        Mobil mobilCreated = mobilRepository.save(mobil);

        MobilDto mobilDtoCreated = convertMobilToMobilDto(mobilCreated);

        return mobilDtoCreated;
    }

    @Override
    public ResponseMobilDto getAll(int pageNo, int pageSize) {
        ResponseMobilDto responseMobilDto = new ResponseMobilDto();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

        Page<Mobil> mobilList = mobilRepository.findAll(pageable);
        List<MobilDto> mobilDtoList = new ArrayList<>();

        for (Mobil mobil : mobilList) {
            MobilDto mobilDto = convertMobilToMobilDto(mobil);
            mobilDtoList.add(mobilDto);
        }

        mobilDtoList = mobilDtoList.stream().filter(mobilDto -> {
            return mobilDto.getIsDeleted() != null && mobilDto.getIsDeleted() == false;
                })
                        .collect(Collectors.toList());

        responseMobilDto.setMobilDto(mobilDtoList);
        responseMobilDto.setSuccess(true);
        responseMobilDto.setTotalData(mobilDtoList.size());
        responseMobilDto.setTotalPage(mobilList.getTotalPages());

        return responseMobilDto;
    }

    @Override
    public MobilDto deleteById(Integer id) {
        Optional<Mobil> mobilOptional = mobilRepository.findById(id.longValue());
        Mobil mobil = null;

        if (mobilOptional.isPresent()) {
            mobil = mobilOptional.get();
            mobil.setIsDeleted(true);
            Mobil mobilUpdated = mobilRepository.save(mobil);

            MobilDto mobilDtoUpdated = convertMobilToMobilDto(mobilUpdated);

            return mobilDtoUpdated;
        }

        return null;
    }

    @Override
    public MobilDto getById(Integer id) throws JsonProcessingException {
        Optional<Mobil> mobilOptional = mobilRepository.findById(id.longValue());
        Mobil mobil = new Mobil();

        if (mobilOptional.isPresent()) {
            mobil = mobilOptional.get();

            return convertMobilToMobilDto(mobil);
        }
        return null;
    }

    @Override
    public MobilDto uploadImage(Integer id, MultipartFile file) {
        return null;
    }

    private MobilDto convertMobilToMobilDto(Mobil mobilCreated) {
        // create new
        if (mobilCreated.getId() == null) {
            MobilDto mobilDtoCreated = new MobilDto();
            mobilDtoCreated.setId(mobilCreated.getId());
            mobilDtoCreated.setIsDeleted(mobilCreated.getIsDeleted());
            mobilDtoCreated.setBrand(mobilCreated.getBrand());

            MobilDetailDto mobilDetailDtoCreated = new MobilDetailDto();
            mobilDetailDtoCreated.setColor(mobilCreated.getMobilDetail().getColor());
            mobilDetailDtoCreated.setId(mobilCreated.getMobilDetail().getId());
            mobilDetailDtoCreated.setIsNew(mobilCreated.getMobilDetail().getIsNew());
            mobilDetailDtoCreated.setPrice(mobilCreated.getMobilDetail().getPrice());
            mobilDetailDtoCreated.setYear(mobilCreated.getMobilDetail().getYear());
            mobilDetailDtoCreated.setName(mobilCreated.getMobilDetail().getName());
            mobilDetailDtoCreated.setSpec(mobilCreated.getMobilDetail().getSpec());

            mobilDtoCreated.setMobilDetailDto(mobilDetailDtoCreated);
            return mobilDtoCreated;
        }
        // update
        else {
            Optional<Mobil> existingMobilOptional = mobilRepository.findById(mobilCreated.getId());
            Mobil existingMobil = existingMobilOptional.get();

            MobilDto mobilDtoCreated = new MobilDto();
            mobilDtoCreated.setId(existingMobil.getId());
            mobilDtoCreated.setIsDeleted(existingMobil.getIsDeleted());
            mobilDtoCreated.setBrand(existingMobil.getBrand());

            MobilDetailDto mobilDetailDtoUpdated = new MobilDetailDto();
            mobilDetailDtoUpdated.setColor(existingMobil.getMobilDetail().getColor());
            mobilDetailDtoUpdated.setId(existingMobil.getMobilDetail().getId());
            mobilDetailDtoUpdated.setIsNew(existingMobil.getMobilDetail().getIsNew());
            mobilDetailDtoUpdated.setPrice(existingMobil.getMobilDetail().getPrice());
            mobilDetailDtoUpdated.setYear(existingMobil.getMobilDetail().getYear());
            mobilDetailDtoUpdated.setName(existingMobil.getMobilDetail().getName());
            mobilDetailDtoUpdated.setSpec(existingMobil.getMobilDetail().getSpec());

            mobilDtoCreated.setMobilDetailDto(mobilDetailDtoUpdated);
            return mobilDtoCreated;
        }
    }

    private Mobil convertMobilDtoToMobil(MobilDto mobilDto) {
        Mobil mobil = new Mobil();
        mobil.setBrand(mobilDto.getBrand());
        mobil.setIsDeleted(false);

        MobilDetail mobilDetail = new MobilDetail();
        mobilDetail.setIsNew(mobilDto.getMobilDetailDto().getIsNew());
        mobilDetail.setColor(mobilDto.getMobilDetailDto().getColor());
        mobilDetail.setPrice(mobilDto.getMobilDetailDto().getPrice());
        mobilDetail.setYear(mobilDto.getMobilDetailDto().getYear());
        mobilDetail.setName(mobilDto.getMobilDetailDto().getName());
        mobilDetail.setSpec(mobilDto.getMobilDetailDto().getSpec());
        mobil.setMobilDetail(mobilDetail);
        return mobil;
    }
}
