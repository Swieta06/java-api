package OneToOne.example.onetoone_task.model;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@SQLDelete(sql = "UPDATE mobil SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=false")
@Table(name="mobil")
public class Mobil {
    /*Table Mobil memiliki field:
        1. id (Long)
        2. brand (String)
        3. mobil_detail_id (Long)
        4. is_deleted (boolean)
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @OneToOne(cascade = CascadeType.PERSIST)
    //nama foreingkey/reference primarykey dari class sebelah
    @JoinColumn(name = "mobil_detil_id",referencedColumnName = "id",unique = true)//uniqe=true,one to one
    private MobilDetil mobilDetil;


}
