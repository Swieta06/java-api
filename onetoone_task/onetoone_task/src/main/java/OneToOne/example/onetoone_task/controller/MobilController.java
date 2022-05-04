package OneToOne.example.onetoone_task.controller;
import OneToOne.example.onetoone_task.dto.MobilDto;
import OneToOne.example.onetoone_task.model.Mobil;
import OneToOne.example.onetoone_task.model.MobilDetil;
import OneToOne.example.onetoone_task.service.MobilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/mobil")
public class MobilController {

@Autowired
private MobilService mobilService;

    @GetMapping("/test")
    public String test(){
        return "udh masuk";
    }

    //api/v1/mobil/create
 /* @PostMapping("/create")
    public ResponseEntity<MobilDto>createMobil(@RequestBody MobilDto mobilDto){
        MobilDto mobilDtocreated= this.mobilService.createMobil(mobilDto);
    return new ResponseEntity<>(mobilDtocreated, HttpStatus.CREATED);
    }*/
    @GetMapping("/getAll")
    public List<Mobil>getAll(){
    return this.mobilService.getMobils();
    }

    @GetMapping("/getAlls")
    public List<MobilDto> getMobils(){
        return this.mobilService.getMobilss();
    }

    @GetMapping("/{id}")
    public MobilDto getById(@PathVariable Long id){
        return this.mobilService.getById(id);
    }
    @PostMapping()
    public String createMobil(@RequestBody MobilDto mobilDto){
        this.mobilService.createMobil(mobilDto);
        return "Telah Membuat!!!";
    }
    @PutMapping("/{id}")//path parameter
    public String updateMobil(@PathVariable Long id,@RequestBody MobilDto mobilDto){
        this.mobilService.updateMobil(id,mobilDto);
        return null;
    }
    @DeleteMapping("/{id}")
    public void deletMapping(@PathVariable Long id){
        this.mobilService.deletMobil(id);
    }
   /* @PostMapping("/uploadImage")
    public ResponseEntity<MobilDto>uploadImage(@RequestParam Integer id, @RequestParam("image")MultipartFile){
        MobilDto mobilDtoUpload=this.mobilService.uploa(id,file);
    }*/

}
