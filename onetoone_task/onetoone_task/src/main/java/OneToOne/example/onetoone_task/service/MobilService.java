package OneToOne.example.onetoone_task.service;

import OneToOne.example.onetoone_task.dto.MobilDto;
import OneToOne.example.onetoone_task.model.Mobil;

import java.util.List;

public interface MobilService {
  //MobilDto createMobil(MobilDto mobilDto);
    List<Mobil> getMobils();
    List<MobilDto> getMobilss();

    MobilDto getById(Long id);

    //void createMobill();

     public void createMobil(MobilDto mobilDto);
//update
    void updateMobil(Long id,MobilDto mobilDto);
//delet
    void deletMobil(Long id);

    //public Mobil createMobil(MobilDto mobilDto);
}
