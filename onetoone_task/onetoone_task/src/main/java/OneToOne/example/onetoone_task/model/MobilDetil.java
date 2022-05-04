package OneToOne.example.onetoone_task.model;

import lombok.*;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "mobilDetail")
public class MobilDetil {
    /*1. id (Long)
2. color (String)
3. isNew (Boolean)
4. year (Integer)
5. price (Double)
*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "color")
    private String color;
    @Column(name = "isNew")
    private Boolean isNew;
    @Column(name = "year")
    private Integer year;
    @Column(name = "price")
    private Double price;



}
