package com.onetoone.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

    private Integer id;
    private String name;
    private double gpa;
    private String email;
    private List<Passenger> passengers;
}
