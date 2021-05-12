package com.example.baitap.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Directory {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="id_directory")
    private Integer id;
    @Column (name="name_directory")
    private String name;

    @OneToMany(mappedBy = "directory",cascade = CascadeType.ALL)
    private Set<Product> products;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Directory() {
    }
}
