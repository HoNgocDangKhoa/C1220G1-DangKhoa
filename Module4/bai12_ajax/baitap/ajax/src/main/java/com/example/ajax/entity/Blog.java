package com.example.ajax.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="Blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false,referencedColumnName = "category_id")
    private Category category;

    private String context;


    public Blog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }


}
