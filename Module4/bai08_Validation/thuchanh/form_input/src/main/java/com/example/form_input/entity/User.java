package com.example.form_input.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
    @NotBlank(message = "Tên không đc để trống")
    @Size(min = 2, max = 20,message = "tên phải dài hơn 2 và nhỏ hơn 20 kí tự")
    private String name;
    @Min(value = 18,message = "tuổi phải lớn hơn 18")
    private int age;
    public User() {
    }
}
