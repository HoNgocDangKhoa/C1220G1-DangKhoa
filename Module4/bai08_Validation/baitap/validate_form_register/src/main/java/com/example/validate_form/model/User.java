package com.example.validate_form.model;



import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
@Entity
public class User implements Validator {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 5,max = 45,message = "do dai tu 5-45 ki tu")
    private String firstName;

    @NotBlank
    @Size(min = 5,max = 45,message = "do dai tu 5-45 ki tu")
    private String lastName;

    private String phone;

    @Min(value = 18 ,message = "tuoi phai lon hon 18")
    private int age;

    @Email(message = "email phai dung dịnh dang abc.@abc.com")
    private String email;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String phone = user.getPhone();
        ValidationUtils.rejectIfEmpty(errors, "phone", "phone.empty");
        if (phone.length()>11 || phone.length()<10){
            errors.rejectValue("phone", "phone.length");
        }
        if (!phone.startsWith("0")){
            errors.rejectValue("phone", "phone.startsWith");
        }
        if (!phone.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phone", "phone.matches");
        }
    }

    }

