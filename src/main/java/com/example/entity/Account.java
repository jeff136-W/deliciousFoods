package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "level")
    private Integer level;
    @Column(name = "sex")
    private String sex;
    @Transient
    private String newPassword;
    private String address;
    @Column(name = "nickName")
    private String nickName;
    private String phone;
    @Transient
    private Double account;

}
