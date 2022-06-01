package com.onetoone.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "student")
class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "student")
    Set<CourseRating> ratings;

    @Column(name = "name")
    private String name;

    @Column(name = "gpa")
    private Double gpa;

    @Column(name = "address")
    private String address;
}
