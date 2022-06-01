package com.onetoone.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Clob;

@Entity
@Table(name = "mobil_detail")
@NoArgsConstructor
@Getter
@Setter
public class MobilDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "color")
    private String color;

    @Column(name = "is_new")
    private Boolean isNew;

    @Column(name = "year")
    private Integer year;

    @Column(name = "price")
    private Double price;

    @Column(name = "name")
    private String name;

    @Column(name = "spec")
    @Lob // mysql: Clob
    private String spec;

    @Column(name = "image")
    @Lob // mysql: Blob
    private byte[] image;
}
