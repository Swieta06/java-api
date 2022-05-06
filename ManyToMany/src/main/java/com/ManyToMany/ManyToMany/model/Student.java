package com.ManyToMany.ManyToMany.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "gpa")
    private Double gpa;
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "student",cascade = CascadeType.PERSIST)
    private List<CourseRating>courseRatingList;

}
