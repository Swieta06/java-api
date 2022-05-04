package OneToOne.example.onetoone_task.service.impl;

import OneToOne.example.onetoone_task.dto.MobilDetilDto;
import OneToOne.example.onetoone_task.dto.MobilDto;
import OneToOne.example.onetoone_task.model.Mobil;
import OneToOne.example.onetoone_task.model.MobilDetil;
import OneToOne.example.onetoone_task.repository.MobilRepository;
import OneToOne.example.onetoone_task.service.MobilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MobilServiceImpl implements MobilService {
    @Autowired
    private MobilRepository mobilRepository;


    @Override
    public List<Mobil> getMobils() {
        return this.mobilRepository.findAll();
    }

   /* @Override
    public Mobil createMobil(MobilDto mobilDto) {
        Mobil mobil = new Mobil();
        mobil.setBrand(mobilDto.getBrand());
        mobil.setIs_deleted(false);
        mobil.setMobilDetil(mobilDto.getMobilDetil());
        Mobil newMobil=mobilRepository.save(mobil);
        return newMobil;
    }*/

    public List<MobilDto> getMobilss() {
        //simpan list mobil
        List<Mobil> mobilList = this.mobilRepository.findAll();
        //tempat menyimpan mobil dto
        List<MobilDto> mobilDtoList = new ArrayList<>();//ini kosong tru di add!!

        for (Mobil mobil : mobilList) {
            MobilDto mobilDto=mobilToMobilDto(mobil);
            mobilDtoList.add(mobilDto);
        }
        return mobilDtoList;

    }

    @Override
    public MobilDto getById(Long id) {
        // return this.mobilRepository.findById(Long.valueOf(id));
        Optional<Mobil> mobilOptiona = this.mobilRepository.findById(id);
        if (mobilOptiona.isPresent()) {//ada gak?
        return mobilToMobilDto(mobilOptiona.get());
        }
        return null;
    }


    @Override
    public void createMobil(MobilDto mobilDto) {
  this.mobilRepository.save(mobilDtoToMobil(mobilDto));

    }

    @Override
    public void updateMobil(Long id, MobilDto mobilDto) {
        Optional <Mobil>mobilOptional=this.mobilRepository.findById(id);
        //cari dulu datanya dengan id
        mobilDto.setId(id);
        if (mobilOptional.isPresent()){
           Mobil mobil=mobilDtoToMobil(mobilDto);
           this.mobilRepository.save(mobil);
       }
    }

    @Override
    public void deletMobil(Long id) {
       this.mobilRepository.deleteById(id);
    }


    private Mobil mobilDtoToMobil(MobilDto mobilDto){
                return new Mobil(
                        mobilDto.getId(),
                        mobilDto.getBrand(),
                        mobilDto.getIsDeleted(),
                        new MobilDetil(
                                mobilDto.getMobilDetilDto().getId(),
                                mobilDto.getMobilDetilDto().getColor(),
                                mobilDto.getMobilDetilDto().getIsNew(),
                                mobilDto.getMobilDetilDto().getYear(),
                                mobilDto.getMobilDetilDto().getPrice()
                        )
                );
        }
    private MobilDto mobilToMobilDto(Mobil mobil) {
        return new MobilDto(
                mobil.getId(),
                mobil.getBrand(),
                mobil.getIsDeleted(),
                new MobilDetilDto(
                        mobil.getMobilDetil().getId(),
                        mobil.getMobilDetil().getColor(),
                        mobil.getMobilDetil().getIsNew(),
                        mobil.getMobilDetil().getYear(),
                        mobil.getMobilDetil().getPrice()
                )
        );
    }

}
