package OneToOne.example.onetoone_task.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MobilDto {
    private Long id;
    private String brand;
    private Boolean isDeleted;
    private MobilDetilDto mobilDetilDto;
}
