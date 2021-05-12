package com.example.baitap.model;


import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Integer idProduct;
    @Column(name = "name_product")
    private String nameProduct;
    @Column(name = "price_product")
    private String price;
    @Column(name = "type_product")
    private String typeProduct;
    @Column(name = "amount_product")
    private Integer amount;

    @ManyToOne
    @JoinColumn(name="id_directory" ,nullable = false,referencedColumnName = "id_directory")
    private Directory directory;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_detail",referencedColumnName = "id_detail")
    private Detail detail;

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Directory getDirectory() {
        return directory;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }

    public Product() {
    }
}
