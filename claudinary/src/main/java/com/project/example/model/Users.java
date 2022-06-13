package com.project.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="users",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class Users {
    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "password",nullable = false)
    private  String password;

    @Column(name = "role",nullable = false)
    private  String role;

    // one to many
    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Orders> orders;

    @OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
    private Addresses addresses;
}
