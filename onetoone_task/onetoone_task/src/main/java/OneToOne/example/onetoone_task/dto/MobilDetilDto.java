package OneToOne.example.onetoone_task.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MobilDetilDto {
    private Long id;
    private String color;
    private Boolean isNew;
    private Integer year;
    private Double price;


}
