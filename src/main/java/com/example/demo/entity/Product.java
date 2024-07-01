package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  //상품 아이디

    private String name; //상품 이름

    private String description;  //상품 설명

    private double price; //상품 가격

    @ManyToOne
    private Category category;




}
