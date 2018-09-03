package com.hrg.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}