package com.project.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "addresses")
public class Addresses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id",unique = true)
    private Users users;

    @Column(name = "street",nullable = false)
    private String street;

    @Column(name = "city",nullable = false)
    private String city;

    @Column(name = "zipcode",nullable = false)
    private String zipcode;



}
