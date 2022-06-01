package com.onetoone.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "mobil")
@NoArgsConstructor
@Getter
@Setter
public class Mobil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "is_deleted") // snake case
    private Boolean isDeleted; // camel case

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mobil_detail_id", referencedColumnName = "id")
    private MobilDetail mobilDetail;
}
